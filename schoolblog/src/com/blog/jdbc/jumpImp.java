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
		
		int pages=0;            //����ʾҳ��
	    int count=0;            //������
	    int totalpages=0;        //��ҳ��
	    int limit=5;            //ÿҳ��ʾ��¼����    
	    
	    connection = DbUtils.getConnection();
	    String sql = "select count(*) from t_user_operation where userId=?";
	    
	    //�����¼�����ĵڶ��ְ취��ʹ��mysql�ľۼ�����count(*)
	    try {
	    	statement = connection.prepareStatement(sql);
		    statement.setString(1, userId);
			rs = statement.executeQuery();
			if(rs.next()){
		        count = rs.getInt(1);//���Ϊcount(*)��ֻ��һ�С�����ͨ���е��±�������1������ȡֵ
			}   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("jdbc.jump.selectInfo:ҳ������count��ѯʧ��");
		}
	    //�ɼ�¼��������ÿҳ��¼���ó���ҳ��
	    totalpages = (int)Math.ceil(count/(limit*1.0));
	    //��ȡ��ҳʱ�������ĵ�ǰҳ�����
	    //�жϵ�ǰҳ������ĺϷ��Բ�����Ƿ�ҳ�ţ�Ϊ������ʾ��һҳ��С��0����ʾ��һҳ��������ҳ������ʾ���һҳ��
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
	    //��(pages-1)*limit�����ǰҳ���һ����¼����limit��ѯlimit����¼����ó���ǰҳ��ļ�¼
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
			System.out.println("jdbc.jump.selectInfo:��ʷ������Ϣ��ѯʧ��");
		}finally{
			DbUtils.close(connection, statement,  rs);
		}
		
		return null;
	}
	
	
	
}
