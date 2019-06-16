package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class headerPtChgImp {
	
	static Connection connection;
	static PreparedStatement statement;
	static ResultSet rs;
	
	public static Boolean imgSave(String imgId,String userId){
		
		connection = DbUtils.getConnection();
		String sql;
		
		//数据插入
		sql ="UPDATE t_user_info set imgId =? WHERE InfoId in (select InfoId FROM t_user where userId =?);";
		    
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,imgId);
			statement.setString(2,userId);
			int i= statement.executeUpdate();
			if(i>0){
				System.out.println("jdbc.headerPtChgImp.imgSave:图像上传成功!");
			}else{
				System.out.println("图像上传失败!");
				return false;
			}
		}catch (Exception e) {
		// TODO: handle exception
			if(e.toString().indexOf("for key 'PRIMARY")!=-1){  
				System.out.println("图像已存在");
			}
			return false;
		} finally{
			DbUtils.close(connection, statement, rs);
		}
		return true;
	}
}
