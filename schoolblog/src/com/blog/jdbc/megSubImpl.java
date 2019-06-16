package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.blog.javabean.megSubBean;
import com.blog.jdbc.DbUtils;

public class megSubImpl {
	static Connection connection;
	static PreparedStatement statement;
	static ResultSet rs;
	UUID uuid;
	operationImp operImp = new operationImp();
	//存入发布箱
	public String saveRelease(megSubBean megSub){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式 
		connection = DbUtils.getConnection();
		String sql;
		String usrId = null ;
		//查找id号
		sql = "select userId from t_user where username=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,megSub.getUsername());
			rs = statement.executeQuery();
			while(rs.next()){
				usrId = rs.getString("userId");   //获取随机产生的id值
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			System.out.println("servlet.megSubImp.saveRelease:查询失败,该用户不存在!  -----  提示信息：用户失效!");
			return "用户失效！";
		}
		
		
		//1.先插入 t_public 
		uuid = UUID.randomUUID();
		String Releaseid = uuid.toString();
		sql ="insert into t_publish(releaseId,title,introduce,txt,discuss,homePage,ReleaseDate,type) values(?,?,?,?,?,?,?,?)";
		try {
			
			statement = connection.prepareStatement(sql);
			statement.setString(1,Releaseid);
			/*
			 * 这个地方存在一个标题相同的sql异常
			 */
			statement.setString(2,megSub.getTitle());
			statement.setString(3,megSub.getIntroduce());
			statement.setString(4,megSub.getText());
			statement.setString(5,megSub.getDiscuss());
			statement.setString(6,megSub.getHomePage());
			statement.setString(7,df.format(new Date()));
			statement.setString(8,megSub.getTextType());
			int i= statement.executeUpdate();
			if(i>0){
				System.out.println("servlet.megSubImp.saveRelease:发布成功!");
			}else{
				return "发布失败！！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("servlet.megSubImp.saveRelease:"+e);
			return "发布失败！";
		}
		
		//2.插入 t_userMessage 
		uuid = UUID.randomUUID();
		String messageId = uuid.toString();
		sql ="insert into t_usermessage(messageId,userId,releaseId) values(?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,messageId);
			statement.setString(2,usrId);
			statement.setString(3,Releaseid);
			int i= statement.executeUpdate();
			if(i>0){
				System.out.println("servlet.megSubImp.saveRelease:发布成功!");
			}else{
				return "发布失败！！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("servlet.megSubImp.saveRelease:"+e);
			return "发布失败！";
		}finally{
			DbUtils.close(connection, statement, rs);
		}
		
	
		//历史操作记录保存
		String operName = "文本操作";
		String type = "发布文章";
		operImp.saveOperation(megSub.getUsername(), operName, type);
		
		
		return "发布成功！";
	}
	
	//存入草稿箱
	public String saveDraftBox(megSubBean megSub){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式 
		connection = DbUtils.getConnection();
		String sql;
		String usrId = null ;
		//查找id号
		sql = "select userId from t_user where username=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,megSub.getUsername());
			rs = statement.executeQuery();
			while(rs.next()){
				usrId = rs.getString("userId");   //获取随机产生的id值
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			System.out.println("servlet.megSubImp.saveRelease:查询失败,该用户不存在!  -----  提示信息：用户失效!");
			return "用户失效！";
		}
		
		
		//1.先插入 t_draftbox
		uuid = UUID.randomUUID();
		String DraftId = uuid.toString();
		sql ="insert into t_draftbox(draftboxId,title,introduce,txt,discuss,homePage,draftDate,type) values(?,?,?,?,?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,DraftId);
			/*
			 * 这个地方存在一个标题相同的sql异常
			 */
			statement.setString(2,megSub.getTitle());
			statement.setString(3,megSub.getIntroduce());
			statement.setString(4,megSub.getText());
			statement.setString(5,megSub.getDiscuss());
			statement.setString(6,megSub.getHomePage());
			statement.setString(7,df.format(new Date()));
			statement.setString(8,megSub.getTextType());
			int i= statement.executeUpdate();
			if(i>0){
				System.out.println("servlet.megSubImp.saveDraft:发布成功!");
			}else{
				return "草稿箱保存失败！！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("servlet.megSubImp.saveDraft:"+e);
			return "草稿箱保存失败！";
		}
		
		//2.插入 t_userMessage 
		uuid = UUID.randomUUID();
		String messageId = uuid.toString();
		sql ="insert into t_usermessage(messageId,userId,draftboxId) values(?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,messageId);
			statement.setString(2,usrId);
			statement.setString(3,DraftId);
			int i= statement.executeUpdate();
			if(i>0){
				System.out.println("servlet.megSubImp.saveDraft:发布成功!");
			}else{
				return "草稿箱保存失败！！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("servlet.megSubImp.saveDraft:"+e);
			return "草稿箱保存失败！";
		}finally{
			DbUtils.close(connection, statement, rs);
		}
		
		//历史操作记录保存
		String operName = "文本操作";
		String type = "存入草稿";
		operImp.saveOperation(megSub.getUsername(), operName, type);
		
		return "草稿箱保存成功！";
	}
	
//	//文章删除
//	public Boolean delectMessage(String titl){
//		Connection connection = DbUtils.getConnection();
//		String sql="delete from `release` where title=?";
//		try {
//			statement=connection.prepareStatement(sql);
//			statement.setObject(1, titl);
//			return statement.executeUpdate()>0?true:false;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			DbUtils.close(connection, statement, null);
//		}
//		
//	
//	}
}
