package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.blog.javabean.loginBean;


public class loginImpl {
	static Connection connection;
	static PreparedStatement statement;
	static ResultSet res;
	
	
	public Boolean imp(String user,String psd,String flag){
		String sql="select * from t_user";
		String username;
		String password;
		loginBean login = new loginBean();
		connection = DbUtils.getConnection();
		try {
			Statement sq = connection.createStatement();
			res = sq.executeQuery(sql);
			while(res.next()){
				username = res.getString("username");
				password = res.getString("password");
				if(username.equals(user)&password.equals(psd)&flag.equals("1")){
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtils.close(connection, null, res);
		return false;
	}
	
	
	
	
	public Boolean upPsd(String userId,String psd){
		String sql = "update t_user set `password`=? where userId=? ";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,psd);
			statement.setString(2, userId);
			int status= statement.executeUpdate();
			if(status>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
