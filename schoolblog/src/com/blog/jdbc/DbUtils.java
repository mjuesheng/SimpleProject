package com.blog.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class DbUtils {
	//�û���
	private static String username="root";
	//����
	private static String password="xu123";
	//���ݿ�����//jdbc:mysql://139.129.210.174:3307/weixin
	private static String url="jdbc:mysql://localhost:3306/schoolblog";
	//���ݿ�����
	private static String driver="com.mysql.jdbc.Driver";
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	public static  Connection getConnection(){
		try {
			/*
			 * ע������
			 */
			Class.forName(driver);
			/*
			 * ��ȡ����
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
