package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blog.javabean.megSubBean;

public class draftboxImp {
	//int id=0;
		String messageId;
		String title;
		String text;
		String type;
		Date date;
		String introduce;
		String discuss;
		String homePage;
		megSubBean message;
		String sql;     //sql查询字符串
		ResultSet res;
		PreparedStatement ps=null; 
		Statement sq = null;
		//int i=0;    //控制message数组
		List<megSubBean> list = new ArrayList<megSubBean>();
		
		public  List SelectMessage(String t,String user){
			Connection connection = DbUtils.getConnection();
			if(t.equals("0")){
				String id = SelectID.selectId(user);
				if(id!=null||id!=""){
					sql = "select u.messageId,p.title,p.introduce,p.type,p.discuss,p.draftDate from t_usermessage u,t_draftbox p where u.userId='"+id+"' and u.draftboxId=p.draftboxId";
					try {
						sq = connection.createStatement();
						res = sq.executeQuery(sql);
						while(res.next()){
							messageId = res.getString("messageId");
							title = res.getString("title");
							introduce = res.getString("introduce");
							type= res.getString("type");
							discuss = res.getString("discuss");
							date = res.getDate("DraftDate");
							message = new megSubBean(messageId,user,title,introduce,text,discuss,homePage,date,type);
							list.add(message);
					//		i++; 
						}
						return list;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						try {
							sq.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						DbUtils.close(connection, null, res);
					}
				}else{
					System.out.println("jdbc.draftboxImp:id不存在!");
				}
			}
			return null;
		}
		
		
		public Boolean delectMessage(String draftId){
			Connection connection = DbUtils.getConnection();
			String sql="delete from t_usermessage where messageId=?";
			try {
				ps=connection.prepareStatement(sql);
				ps.setObject(1, draftId);
				return ps.executeUpdate()>0?true:false;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DbUtils.close(connection, ps, null);
			}
			return false;
		}
		
}
