package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.blog.javabean.megSubBean;

public class IntererstingImp {
	static Connection connection;
	static PreparedStatement statement;
	static ResultSet rs;
	static String sql;
	
	//数据分析结果并保存数据库
	public static Boolean WordCountSave(String username,List list) throws Exception{
		
		connection = DbUtils.getConnection();
		int status;  //数据库存储状态
		//查找id号
		String userId=null;
		userId= SelectID.selectId(username);
		if(userId!=null||userId!=""){
			//1.判断用户id是否存在
			sql = "select count(*) as ct from t_user_interesting where userId=? ";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			rs = statement.executeQuery();
			rs.next();
			int ct = rs.getInt("ct");
			//兴趣表中没有该用户的信息 --新建
			if(ct == 0){
				//词频只保存前三的的数据
				sql = "insert into t_user_interesting(interestingId,userId,interestingOne,interestingTwo,interestingThree) values(?,?,?,?,?)";
				try {
					statement = connection.prepareStatement(sql);
					UUID interestingId = UUID.randomUUID();
					statement.setString(1,interestingId.toString());
					statement.setString(2, userId);
					statement.setString(3, (String) list.get(0));
					statement.setString(4, (String) list.get(1));
					statement.setString(5, (String) list.get(2));
					status= statement.executeUpdate();
					if(status>0){
						System.out.println("jdbc:interesting:WordCountSave:兴趣推荐:数据保存成功");
					}else{
						System.out.println("jdbc:interesting:WordCountSave:兴趣推荐:数据保存失败");
						return false;
					}
				}catch (Exception e) {
				// TODO: handle exception
					System.out.println("jdbc:interesting:WordCountSave:兴趣推荐:数据异常:"+e);
					return false;
				} finally{
					DbUtils.close(connection, statement, rs);
				}
			}
			//兴趣表中存在该用户的信息 --更新数据
			else{
				//数据插入
				sql ="UPDATE t_user_interesting SET interestingOne=?,interestingTwo=?,interestingThree=? WHERE userId=?;";    
				try {
					statement = connection.prepareStatement(sql);
					statement.setString(1,(String) list.get(0));
					statement.setString(2,(String) list.get(1));
					statement.setString(3,(String) list.get(2));
					statement.setString(4,userId);
					int i = statement.executeUpdate();
					if(i>0){
						System.out.println("jdbc:interesting:WordCountSave:兴趣推荐:更新成功！");
					}else{
						System.out.println("jdbc:interesting:WordCountSave:兴趣推荐:更新失败！");
						return false;
					}
				}catch (Exception e) {
				// TODO: handle exception
					System.out.println("jdbc:interesting:WordCountSave:兴趣推荐::"+e);
					return false;
				} finally{
					DbUtils.close(connection, statement, rs);
				}
			}
		}else{
			System.out.println("jdbc:interesting:WordCountSave:兴趣推荐:用户ID不存在！");
			return false;
		}
		return true;
	}
	
	
	//根据分析结果进行文章推荐
	public static List tuijian(String username){
		connection = DbUtils.getConnection();
		String userId=null;
		String interestingOne = null;
		String interestingTwo = null;
		String interestingThree = null;
		String messageId;
		String title;
		String text;
		String type;
		Date date;
		String editorer;
		String introduce;
		String discuss;
		String homePage;
		int readNum=0;
		megSubBean message;
		List<megSubBean> list = new ArrayList<megSubBean>();
		//用户登录  根据用户的习惯推荐
		if(username != null && username.length() != 0){
			//查询用户经常点击的文章类别
			userId= SelectID.selectId(username);
			sql = "select interestingOne,interestingTwo,interestingThree from t_user_interesting where userId=?;";
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1,userId);
				rs = statement.executeQuery();
				while(rs.next()){
					 interestingOne = rs.getString("interestingOne");
					 interestingTwo = rs.getString("interestingTwo");
					 interestingThree = rs.getString("interestingThree");
				}
				
				//根据类别查询文章信息  -first
				sql = "select * from v_tuijian where type=?;";
				statement = connection.prepareStatement(sql);
				statement.setString(1,interestingOne);
				rs = statement.executeQuery();
				int k=0;
				while(rs.next()){
					messageId =  rs.getString("messageId");
					title = rs.getString("title");
					type= rs.getString("type");
					date = rs.getDate("ReleaseDate");
					editorer =rs.getString("username");
					readNum = rs.getInt("readNum");
					if(k<3){
						message = new megSubBean(messageId,editorer,title,null,null,null,null,date,type,readNum);
						list.add(message);
					}
					k++;
					
				}
				//根据类别查询文章信息  -second
				k=0;
				sql = "select * from v_tuijian where type=?;";
				statement = connection.prepareStatement(sql);
				statement.setString(1,interestingTwo);
				rs = statement.executeQuery();
				while(rs.next()){
					messageId =  rs.getString("messageId");
					title = rs.getString("title");
					introduce = rs.getString("introduce");
					type= rs.getString("type");
					date = rs.getDate("ReleaseDate");
					editorer =rs.getString("username");
					readNum = rs.getInt("readNum");
					if(k<3){
						message = new megSubBean(messageId,editorer,title,null,null,null,null,date,type,readNum);
						list.add(message);
					}
					k++;
				}
				//根据类别查询文章信息  -three
				k=0;
				sql = "select * from v_tuijian where type=?;";
				statement = connection.prepareStatement(sql);
				statement.setString(1,interestingThree);
				rs = statement.executeQuery();
				while(rs.next()){
					messageId =  rs.getString("messageId");
					title = rs.getString("title");
					introduce = rs.getString("introduce");
					type= rs.getString("type");
					date = rs.getDate("ReleaseDate");
					editorer =rs.getString("username");
					readNum = rs.getInt("readNum");
					if(k<3){
						message = new megSubBean(messageId,editorer,title,null,null,null,null,date,type,readNum);
						list.add(message);
					}
					k++;
				}
			}catch (Exception e) {
			// TODO: handle exception
				System.out.println("jdbc:interesting:tuijian:兴趣推荐:数据异常:"+e);
			} finally{
				DbUtils.close(connection, statement, rs);
			}
		//用户未登录  推荐点击量高的
		}else{
			int k=0;
			try{
				sql = "select * from v_tuijian;";
				statement = connection.prepareStatement(sql);
				rs = statement.executeQuery();
				while(rs.next()){
					messageId =  rs.getString("messageId");
					title = rs.getString("title");
					introduce = rs.getString("introduce");
					type= rs.getString("type");
					date = rs.getDate("ReleaseDate");
					editorer =rs.getString("username");
					readNum = rs.getInt("readNum");
					if(k<7){
						message = new megSubBean(messageId,editorer,title,null,null,null,null,date,type,readNum);
						list.add(message);
					}
					k++;
				}
			}catch (Exception e) {
			// TODO: handle exception
				System.out.println("jdbc:interesting:tuijian:兴趣推荐:数据异常:"+e);
			} finally{
				DbUtils.close(connection, statement, rs);
			}
			
		}
		return list;
	
	}
	public static String SelectMessageId(String releaseId){
		sql = "select messageId from t_usermessage where releaseId=?;";
		String id=null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,releaseId);
			rs = statement.executeQuery();
			while(rs.next()){
				id = rs.getString("messageId");
			}
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("messageId 查询异常!");
		} finally{
			DbUtils.close(connection, statement, rs);
		}
		return id;
	}
}
