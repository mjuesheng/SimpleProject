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
	//���뷢����
	public String saveRelease(megSubBean megSub){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ 
		connection = DbUtils.getConnection();
		String sql;
		String usrId = null ;
		//����id��
		sql = "select userId from t_user where username=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,megSub.getUsername());
			rs = statement.executeQuery();
			while(rs.next()){
				usrId = rs.getString("userId");   //��ȡ���������idֵ
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			System.out.println("servlet.megSubImp.saveRelease:��ѯʧ��,���û�������!  -----  ��ʾ��Ϣ���û�ʧЧ!");
			return "�û�ʧЧ��";
		}
		
		
		//1.�Ȳ��� t_public 
		uuid = UUID.randomUUID();
		String Releaseid = uuid.toString();
		sql ="insert into t_publish(releaseId,title,introduce,txt,discuss,homePage,ReleaseDate,type) values(?,?,?,?,?,?,?,?)";
		try {
			
			statement = connection.prepareStatement(sql);
			statement.setString(1,Releaseid);
			/*
			 * ����ط�����һ��������ͬ��sql�쳣
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
				System.out.println("servlet.megSubImp.saveRelease:�����ɹ�!");
			}else{
				return "����ʧ�ܣ���";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("servlet.megSubImp.saveRelease:"+e);
			return "����ʧ�ܣ�";
		}
		
		//2.���� t_userMessage 
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
				System.out.println("servlet.megSubImp.saveRelease:�����ɹ�!");
			}else{
				return "����ʧ�ܣ���";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("servlet.megSubImp.saveRelease:"+e);
			return "����ʧ�ܣ�";
		}finally{
			DbUtils.close(connection, statement, rs);
		}
		
	
		//��ʷ������¼����
		String operName = "�ı�����";
		String type = "��������";
		operImp.saveOperation(megSub.getUsername(), operName, type);
		
		
		return "�����ɹ���";
	}
	
	//����ݸ���
	public String saveDraftBox(megSubBean megSub){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ 
		connection = DbUtils.getConnection();
		String sql;
		String usrId = null ;
		//����id��
		sql = "select userId from t_user where username=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,megSub.getUsername());
			rs = statement.executeQuery();
			while(rs.next()){
				usrId = rs.getString("userId");   //��ȡ���������idֵ
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			System.out.println("servlet.megSubImp.saveRelease:��ѯʧ��,���û�������!  -----  ��ʾ��Ϣ���û�ʧЧ!");
			return "�û�ʧЧ��";
		}
		
		
		//1.�Ȳ��� t_draftbox
		uuid = UUID.randomUUID();
		String DraftId = uuid.toString();
		sql ="insert into t_draftbox(draftboxId,title,introduce,txt,discuss,homePage,draftDate,type) values(?,?,?,?,?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,DraftId);
			/*
			 * ����ط�����һ��������ͬ��sql�쳣
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
				System.out.println("servlet.megSubImp.saveDraft:�����ɹ�!");
			}else{
				return "�ݸ��䱣��ʧ�ܣ���";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("servlet.megSubImp.saveDraft:"+e);
			return "�ݸ��䱣��ʧ�ܣ�";
		}
		
		//2.���� t_userMessage 
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
				System.out.println("servlet.megSubImp.saveDraft:�����ɹ�!");
			}else{
				return "�ݸ��䱣��ʧ�ܣ���";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("servlet.megSubImp.saveDraft:"+e);
			return "�ݸ��䱣��ʧ�ܣ�";
		}finally{
			DbUtils.close(connection, statement, rs);
		}
		
		//��ʷ������¼����
		String operName = "�ı�����";
		String type = "����ݸ�";
		operImp.saveOperation(megSub.getUsername(), operName, type);
		
		return "�ݸ��䱣��ɹ���";
	}
	
//	//����ɾ��
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
