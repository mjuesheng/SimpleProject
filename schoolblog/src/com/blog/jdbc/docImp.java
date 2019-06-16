package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blog.javabean.docBean;

public class docImp {

	
	
	public static List getDocInfo(String messageId){
		
		String username;
		String personalIntro;
		String imgId;
		String textName;
		String txt;
		Date date;
		String type;
		int txtNum;
		int readNum;
		Connection connection = DbUtils.getConnection();
		String userId = null;
		String releaseId = null;
		ResultSet res = null;
		PreparedStatement ps=null; 
		Statement statement = null;
		docBean docbean ;
		List<docBean> list = new ArrayList<docBean>();
		String sql;
		try {
			//第一步查询出用户id和文章id
			sql = "select userId,releaseId from t_usermessage where messageId = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, messageId);
			res = ps.executeQuery();
			while(res.next()){
				userId = res.getString("userId");
				releaseId =res.getString("releaseId");
			}
			
			//第二部 查询对应Id的具体信息
			sql = "SELECT i.`name`,i.introduce,i.imgId,p.title,p.txt,p.type,p.ReleaseDate,p.readNum,COUNT(m.releaseId) FROM t_user u,t_user_info i,t_publish p,t_usermessage m WHERE u.userId = ? AND m.userId = u.userId AND u.InfoId = i.InfoId AND p.releaseId = ?;";
			ps = connection.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, releaseId);
			res = ps.executeQuery();
			while(res.next()){
				username = res.getString("name");
				personalIntro = res.getString("introduce");
				imgId = res.getString("imgId");
				textName = res.getString("title");
				txt = res.getString("txt");
				date = res.getDate("ReleaseDate");
				txtNum = res.getInt("COUNT(m.releaseId)");
				readNum = res.getInt("readNum");
				type = res.getString("type");
				docbean = new docBean(messageId, username, personalIntro, imgId, textName, txt, date, txtNum,readNum,type);
				list.add(docbean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.close(connection, ps, res);
		}
		return list;	
	}
	
	public static String getImgUrl(String imgId){
		ResultSet res = null;
		PreparedStatement ps=null; 
		Statement statement = null;
		String sql;
		String url=null;
		Connection connection = DbUtils.getConnection();
		try {
			//第一步查询出用户id和文章id
			sql = "select url from t_imgurl where imgId = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, imgId);
			res = ps.executeQuery();
			while(res.next()){
				url = res.getString("url");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.close(connection, ps, res);
		}
		
		return url;
		
	}
	public static void addReadNum(String messageId){
		ResultSet res = null;
		PreparedStatement ps=null; 
		String sql;
		Connection connection = DbUtils.getConnection();
		String releaseId = null;
		sql = "select releaseId from t_usermessage where messageId = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, messageId);
			res = ps.executeQuery();
			while(res.next()){
				releaseId =res.getString("releaseId");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			//第一步查询出用户id和文章id
			sql = "update t_publish set readNum = (readNum + 1) where releaseId = ?;";
			ps = connection.prepareStatement(sql);
			ps.setString(1, releaseId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.close(connection, ps, res);
		}
	}
	
}
