package com.blog.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class DbUtils {
	//用户名
	private static String username="root";
	//密码
	private static String password="xu123";
	//数据库链接//jdbc:mysql://139.129.210.174:3307/weixin
	private static String url="jdbc:mysql://localhost:3306/schoolblog";
	//数据库驱动
	private static String driver="com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库链接
	 * @return
	 */
	public static  Connection getConnection(){
		try {
			/*
			 * 注册驱动
			 */
			Class.forName(driver);
			/*
			 * 获取连接
			 */
			Connection connection= DriverManager.getConnection(url, username, password);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection connection,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			
			if(ps!=null){
				ps.close();
			}
			if(connection!=null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
