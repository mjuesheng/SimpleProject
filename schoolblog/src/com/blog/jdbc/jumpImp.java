package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.blog.javabean.historyBean;
import com.blog.javabean.megSubBean;

public class jumpImp {
	static Connection connection;
	static PreparedStatement statement;
	static ResultSet rs;

	public List selectInfo(String userId,String strPage){
		
		int pages=0;            //待显示页面
	    int count=0;            //总条数
	    int totalpages=0;        //总页数
	    int limit=5;            //每页显示记录条数    
	    
	    connection = DbUtils.getConnection();
	    String sql = "select count(*) from t_user_operation where userId=?";
	    
	    //计算记录总数的第二种办法：使用mysql的聚集函数count(*)
	    try {
	    	statement = connection.prepareStatement(sql);
		    statement.setString(1, userId);
			rs = statement.executeQuery();
			if(rs.next()){
		        count = rs.getInt(1);//结果为count(*)表，只有一列。这里通过列的下标索引（1）来获取值
			}   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("jdbc.jump.selectInfo:页面总数count查询失败");
		}
	    //由记录总数除以每页记录数得出总页数
	    totalpages = (int)Math.ceil(count/(limit*1.0));
	    //获取跳页时传进来的当前页面参数
	    //判断当前页面参数的合法性并处理非法页号（为空则显示第一页，小于0则显示第一页，大于总页数则显示最后一页）
	    System.out.println(strPage);
	    if (strPage == null) { 
	        pages = 1;
	    } else {
	        try{
	            pages = java.lang.Integer.parseInt(strPage);
	        }catch(Exception e){
	            pages = 1;
	        }
	        
	        if (pages < 1){
	            pages = 1;
	        }
	        
	        if (pages > totalpages){
	            pages = totalpages;
	        }                            
	    }
	    //由(pages-1)*limit算出当前页面第一条记录，由limit查询limit条记录。则得出当前页面的记录
	    sql = "select * from t_user_operation where userId = ? order by userId limit ?,?";
	    List<historyBean> list = new ArrayList<historyBean>();
	    try {
	    	statement = connection.prepareStatement(sql);
		    statement.setString(1, userId);
		    statement.setInt(2, (pages - 1) * limit);
		    statement.setInt(3, limit);
	    	rs = statement.executeQuery();
			while (rs.next()){
				Date upTime = rs.getDate("upTime");
				String operName = rs.getString("operName");
				String type=  rs.getString("type");
				historyBean history = new historyBean(upTime, operName, type,totalpages);
				list.add(history);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("jdbc.jump.selectInfo:历史操作信息查询失败");
		}finally{
			DbUtils.close(connection, statement,  rs);
		}
		
		return null;
	}
	
	
	
}
