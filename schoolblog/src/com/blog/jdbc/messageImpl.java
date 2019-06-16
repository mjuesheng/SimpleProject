package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.blog.javabean.megSubBean;

public class messageImpl {
	String messageId;
	String username;
	String title;
	String text;
	String type;
	Date date;
	String introduce;
	String discuss;
	String homePage;
	int readNum=0;
	megSubBean message;
	String sql;     //sql��ѯ�ַ���
	ResultSet res;
	PreparedStatement ps=null; 
	Statement sq = null;
	List<megSubBean> list = new ArrayList<megSubBean>();
	
	
	//�ѷ��������²�ѯ     1.ǰ̨---������ʾ    2.��̨-----�ѷ������¹���  
	public  List SelectMessage(String t,String user,String type){
		Connection connection = DbUtils.getConnection();
		//t=0---ȫ�����²�ѯ   
		if(t.equals("0")){
			// ǰ̨���²�ѯ ----user����Ϊ��
			if(user==null||user==""){
				sql = "select messageId,username,title,type,introduce,ReleaseDate,readNum from v_releaseInfo;";
				try {
					sq = connection.createStatement();
					res = sq.executeQuery(sql);
					while(res.next()){
						messageId =  res.getString("messageId");
						username = res.getString("username");
						title = res.getString("title");
						introduce = res.getString("introduce");
						type= res.getString("type");
						date = res.getDate("ReleaseDate");
						readNum = res.getInt("readNum");
						message = new megSubBean(messageId,username,title,introduce,text,discuss,homePage,date,type,readNum);
						list.add(message);
					}
					return list;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						sq.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					DbUtils.close(connection, null, res);
				}
			//��̨������Ϣ��ѯ -----  user������Ϊ��
			}else{
				String id = SelectID.selectId(user);
				if(id!=null||id!=""){
					sql = "select u.messageId,p.title,p.introduce,p.type,p.discuss,p.ReleaseDate from t_usermessage u,t_publish p where u.userId='"+id+"' and u.releaseId=p.releaseId";
					try {
						sq = connection.createStatement();
						res = sq.executeQuery(sql);
						while(res.next()){
							messageId = res.getString("messageId");
							title = res.getString("title");
							introduce = res.getString("introduce");
							type= res.getString("type");
							discuss = res.getString("discuss");
							date = res.getDate("ReleaseDate");
							message = new megSubBean(messageId,user,title,introduce,text,discuss,homePage,date,type);
							list.add(message);
				//			i++;
						}
						return list;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						try {
							sq.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						DbUtils.close(connection, null, res);
					}
				}else{
					System.out.println("jdbc.messagempl:id������!");
				}
			}
		//t==1  ������ѯ
		}else{
			//��Ϊ�Ƽ���ʱ�򣬰������µ��Ķ�����ǰ�����Ƽ�
			if(type.equals("�Ƽ�")){
				sql="select * from v_tuijian;";
				try {
					ps=connection.prepareStatement(sql);
					res = ps.executeQuery();
					while(res.next()){
						messageId = res.getString("messageId");
						username = res.getString("username");
						title = res.getString("title");
						introduce = res.getString("introduce");
						text = res.getString("txt");
						discuss = res.getString("discuss");
						date = res.getDate("ReleaseDate");
						introduce = res.getString("introduce");;
						readNum = res.getInt("readNum");
						message = new megSubBean(messageId,username,title,introduce,text,discuss,homePage,date,type,readNum);
						list.add(message);
					}
					return list;	
				}catch(Exception e){
					System.out.println(e);
					System.out.println("jdbc.messageImpl.SelectMessage:��������ѯ�������⣡");
				}finally{
					DbUtils.close(connection, ps, null);
				}
			//�������Ƽ�
			}else if(type.equals("��������")){
				sql="select * from v_lastNewMeg;";
				try {
					ps=connection.prepareStatement(sql);
					res = ps.executeQuery();
					while(res.next()){
						messageId = res.getString("messageId");
						username = res.getString("username");
						title = res.getString("title");
						introduce = res.getString("introduce");
						text = res.getString("txt");
						discuss = res.getString("discuss");
						date = res.getDate("ReleaseDate");
						introduce = res.getString("introduce");;
						readNum = res.getInt("readNum");
						message = new megSubBean(messageId,username,title,introduce,text,discuss,homePage,date,type,readNum);
						list.add(message);
				//		i++;
					}
					return list;	
				}catch(Exception e){
					System.out.println(e);
					System.out.println("jdbc.messageImpl.SelectMessage:��������ѯ�������⣡");
				}finally{
					DbUtils.close(connection, ps, null);
				}
			//������ѯ
			}else{
				sql="select * from v_releaseinfo where type=?";
				try {
					ps=connection.prepareStatement(sql);
					ps.setString(1, type);
					res = ps.executeQuery();
					while(res.next()){
						messageId = res.getString("messageId");
						System.out.println(messageId);
						username = res.getString("username");
						title = res.getString("title");
						introduce = res.getString("introduce");
						text = res.getString("txt");
						discuss = res.getString("discuss");
						date = res.getDate("ReleaseDate");
						introduce = res.getString("introduce");;
						readNum = res.getInt("readNum");
						message = new megSubBean(messageId,username,title,introduce,text,discuss,homePage,date,type,readNum);
						list.add(message);
				//		i++;
					}
					return list;	
				}catch(Exception e){
					System.out.println(e);
					System.out.println("jdbc.messageImpl.SelectMessage:��������ѯ�������⣡");
				}finally{
					DbUtils.close(connection, ps, null);
				}
			}
		}
		return null;
	}
	
	public  Map getReleaseById(String id){
		Map map = new HashMap();
		String releaseId = null;
		Connection connection = DbUtils.getConnection();
		//id��messageId ������Ҫ��ȡrelaseId
		String sql = "select  releaseId from t_usermessage where messageId=?";
		try {
			ps=connection.prepareStatement(sql);
			ps.setString(1, id);
			res = ps.executeQuery();
			while(res.next()){
				releaseId = res.getString("releaseId");
			}
			sql = "select * from t_publish where releaseId=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1, releaseId);
			res = ps.executeQuery();
			while(res.next()){
				map.put("messageId", id);
				map.put("title", res.getString("title"));
				map.put("introduce", res.getString("introduce"));
				map.put("txt", res.getString("txt"));
				map.put("type", res.getString("type"));
				map.put("discuss", res.getString("discuss"));
				map.put("homePage", res.getString("homePage"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("jdbc.mesageImpl.getMegById:"+e);
			return null;
		}finally{
			DbUtils.close(connection, ps, res);
		}
		return map;
		
	}
	public  Map getDraftById(String id){
		Map map = new HashMap();
		String draftboxId = null;
		Connection connection = DbUtils.getConnection();
		String sql = "select  draftboxId from t_usermessage where messageId=?";
		try {
			ps=connection.prepareStatement(sql);
			ps.setString(1, id);
			res = ps.executeQuery();
			while(res.next()){
				draftboxId = res.getString("draftboxId");
			}
			sql = "select * from t_draftbox where draftboxId=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1, draftboxId);
			res = ps.executeQuery();
			while(res.next()){
				map.put("messageId", id);
				map.put("title", res.getString("title"));
				map.put("introduce", res.getString("introduce"));
				map.put("txt", res.getString("txt"));
				map.put("type", res.getString("type"));
				map.put("discuss", res.getString("discuss"));
				map.put("homePage", res.getString("homePage"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("jdbc.mesageImpl.getMegById:"+e);
			return null;
		}finally{
			DbUtils.close(connection, ps, res);
		}
		return map;
		
	}
	
	
	//�Ժ�̨����������Ϣ ����ɾ������
	public Boolean delectMessage(String messageId){
		Connection connection = DbUtils.getConnection();
		String sql="delete from t_usermessage where messageId=?";
		try {
			ps=connection.prepareStatement(sql);
			ps.setObject(1, messageId);
			return ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtils.close(connection, ps, null);
		}
		return false;
	}
	//��ѯ�������µ�����
	public int releaseNum(String username){
		Connection connection = DbUtils.getConnection();
		String userId = SelectID.selectId(username);
		String sql="select count(releaseId) as num from t_usermessage where userId =?";
		try{
			ps=connection.prepareStatement(sql);
			ps.setObject(1, userId);
			res = ps.executeQuery();
			res.next();
			return res.getInt("num");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtils.close(connection, ps, null);
		}
		
		return 0;
	}
	
	
	//��ѯδ�������µ�����
		public int DraftNum(String username){
			String userId = null;
			Connection connection = DbUtils.getConnection();
			userId = SelectID.selectId(username);
			sql="select count(draftboxId) as num from t_usermessage where userId =?";
			try{
				ps=connection.prepareStatement(sql);
				ps.setObject(1, userId);
				res = ps.executeQuery();
				res.next();
				return res.getInt("num");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtils.close(connection, ps, null);
			}
			
			return 0;
		}
}