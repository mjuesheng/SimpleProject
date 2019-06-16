package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.blog.javabean.PersonBean;



public class zhuceImp {
	
	static Connection connection;
	static PreparedStatement statement;
	static ResultSet rs;
	
	public static Boolean checkUsername(String username){
		
		//判断是否存在注册的用户名   true（可以使用）   false
		connection = DbUtils.getConnection();
		String sql = "select username from t_user where username=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			rs = statement.executeQuery();
			if(rs.next()){
				System.out.println("servlet.zhuceImp.checkUsername:用户名存在");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("servlet.zhuceImp.checkUsername:"+e);
			e.printStackTrace();
		}finally{
			DbUtils.close(connection, statement, rs);
		}
		return true;
	}
	
	public static Boolean SaveUserInformation(PersonBean person){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式 
		connection = DbUtils.getConnection();
		String sql;
		UUID userId;
		UUID infoId;
		
		//将注册的账户资料插入
		infoId = UUID.randomUUID();
		sql = "insert into t_user_info(InfoId,name,email,telephone) values(?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,infoId.toString());
			statement.setString(2,person.getName());
			statement.setString(3, person.getEmail());
			statement.setString(4, person.getPhone());
			int i= statement.executeUpdate();
			if(i>0){
				System.out.println("servlet.zhuceImp.SaveUserInformation:账户资料插入成功");
				//将注册的用户名、密码插入登录表
				sql = "insert into t_user(userId,infoId,username,password,createDate) values(?,?,?,?,?)";
				userId = UUID.randomUUID();
				statement = connection.prepareStatement(sql);
				statement.setString(1,userId.toString());
				statement.setString(2, infoId.toString());
				statement.setString(3, person.getUsername());
				statement.setString(4, person.getPassword());
				statement.setString(5, df.format(new Date()));
				i= statement.executeUpdate();
				if(i>0){
					System.out.println("servlet.zhuceImp.SaveUserInformation:用户名密码插入成功");
					//个人资料插入
				}
				else{
					return false;
				}
			} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("servlet.zhuceImp.SaveUserInformation:插入异常---"+e);
			return false;
		}finally{
			DbUtils.close(connection, statement, null);
		}
		return true;
	}
}
