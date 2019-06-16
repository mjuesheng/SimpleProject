package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class operationImp {
	static Connection connection;
	static PreparedStatement statement;
	static ResultSet rs;
	
	//保存操作信息
	                                //用户名                                    操作名称                       操作类型
	public Boolean saveOperation(String userName,String OperName,String type){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式 
		Connection connection = DbUtils.getConnection();
		String sql;
		String userId = null;
		userId = SelectID.selectId(userName);
		
		sql = "INSERT INTO t_user_operation(userId,upTime,operName,type) VALUES(?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,userId);
			statement.setString(2,df.format(new Date()));
			statement.setString(3,OperName);
			statement.setString(4,type);
			int i= statement.executeUpdate();
			if(i>0){
				System.out.println("jdbc.operationImp.saveOperation:历史记录保存成功!");
			}else{
				System.out.println("jdbc.operationImp.saveOperation:历史记录保存失败!");
				return false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}finally {
			DbUtils.close(connection, statement,  rs);
		}
		
		return true;
	}
}
