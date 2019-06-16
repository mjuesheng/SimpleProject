package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectID {
	
	static Connection connection;
	static PreparedStatement statement;
	static ResultSet rs;
	public static String selectId(String username){
		connection = DbUtils.getConnection();
		String sql;
		String id=null;
		//查找id号
		sql = "select userId from t_user where username=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			rs = statement.executeQuery();
			while(rs.next()){
				id = rs.getString("userId");   //获取随机产生的id值
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			System.out.println("jdbc.selectID:查询失败,该用户不存在!");
			return "";
		}
		return id+"";
	}
}
