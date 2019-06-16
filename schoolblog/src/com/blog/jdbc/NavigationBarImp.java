package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NavigationBarImp {
	static Connection connection;
	static PreparedStatement statement;
	static ResultSet rs;

	//获取导航栏名称
	public static List getInfo(){
		connection = DbUtils.getConnection();
		String sql;
		sql = "select name from NavigationBar ORDER BY createDate DESC";
		List list = new ArrayList();
		try {
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while(rs.next()){
				list.add(rs.getString("name"));
			}
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("ajax.NavigationBarImp.getInfo:"+e);
		} finally{
			DbUtils.close(connection, statement, rs);
		}
		return list;
	}
	
}
	
