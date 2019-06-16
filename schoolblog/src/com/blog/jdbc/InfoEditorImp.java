package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.blog.javabean.PersonBean;

public class InfoEditorImp {

	static Connection connection;
	static PreparedStatement statement;
	static ResultSet rs;

	public static String getInfoId(String username){
		connection = DbUtils.getConnection();
		String sql;
		//数据插入
		sql ="SELECT InfoId from t_user  WHERE username=?";    
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			rs = statement.executeQuery();
			while(rs.next()){
				return rs.getString("InfoId");
			}
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("ajax.InfoEditorImp.getInfoId:"+e);
		} finally{
			DbUtils.close(connection, statement, rs);
		}
		return null;
	}
	
	
	
	public static Map getInfo(String username){

		Map map = new HashMap();
		connection = DbUtils.getConnection();
		String sql;
		//数据插入
		sql ="SELECT * from t_user_info a ,t_user b WHERE b.username=? AND b.InfoId = a.InfoId;";    
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			rs = statement.executeQuery();
			while(rs.next()){
				map.put("InfoId", rs.getString("InfoId"));
				map.put("name", rs.getString("name"));
				map.put("birthday", rs.getString("birthday"));
				map.put("email", rs.getString("email"));
				map.put("telephone", rs.getString("telephone"));
				map.put("introduce", rs.getString("introduce"));
				map.put("blood", rs.getString("bloodType"));
				map.put("sex", rs.getString("sex"));
			}
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("ajax.InfoEditorImp.getInfo:"+e);
		} finally{
			DbUtils.close(connection, statement, rs);
		}
		return map;
	}
	
	public static Boolean saveInfo(String InfoId,PersonBean person){
		connection = DbUtils.getConnection();
		String sql;
		//数据插入
		sql ="UPDATE t_user_info SET `name`=?,sex=?,birthday=?,email=?,telephone=?,introduce=?,bloodType=? WHERE InfoId=?;";    
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,person.getName());
			statement.setString(2,person.getSex());
			statement.setString(3,person.getBirthday());
			statement.setString(4,person.getEmail());
			statement.setString(5,person.getPhone());
			statement.setString(6,person.getIntroduce());
			statement.setString(7,person.getBlood());
			statement.setString(8,InfoId);
			int i = statement.executeUpdate();
			if(i>0){
				System.out.println("更新成功！");
			}
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("ajax.InfoEditorImp.getInfo:"+e);
			return false;
		} finally{
			DbUtils.close(connection, statement, rs);
		}
		return true;
		
	}
	
}
