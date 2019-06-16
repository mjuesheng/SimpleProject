package com.blog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.blog.javabean.imgUrlBean;

public class imgUrlImp {
	
	static Connection connection;
	static PreparedStatement statement;
	static ResultSet rs;
	
	public static Boolean imgSave(String username,String url,String imgName){
		
		connection = DbUtils.getConnection();
		String sql;
		int status;  //数据库存储状态
		//查找id号
		String id=null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式 
		id= SelectID.selectId(username);
		if(id!=null||id!=""){
			//数据插入
			
			   //1.先插入t_imgurl
			UUID imgid = UUID.randomUUID();
			sql="insert into t_imgurl(imgId,imgName,url,createDate) values(?,?,?,?)";
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1,imgid.toString());
				statement.setString(2, imgName);
				statement.setString(3, url);
				statement.setString(4, df.format(new Date()));
				status= statement.executeUpdate();
				if(status>0){
					//2. 再插入t_user_img
					UUID userImgId = UUID.randomUUID();
					sql="insert into t_user_img(userImgId,userId,imgId) values(?,?,?)";
					statement = connection.prepareStatement(sql);
					statement.setString(1,userImgId.toString());
					statement.setString(2, id);
					statement.setString(3, imgid.toString());
					status = statement.executeUpdate();
					if(status>0){
						//图片信息存储成功后，更新头像图片
						System.out.println("jdbc.imgUrlImp.imgSave:图像上传成功!");
						if(headerPtChgImp.imgSave(imgid.toString(),id)){
							System.out.println("jdbc.imgUrlImp.imgSave:头像更改成功!");
						}
					}
				}else{
					System.out.println("jdbc.imgUrlImp.imgSave:图像上传失败!");
					return false;
				}
			}catch (Exception e) {
			// TODO: handle exception
				if(e.toString().indexOf("for key 'PRIMARY")!=-1){  
					System.out.println("jdbc.imgUrlImp.imgSave:图像已存在"); 
					if(headerPtChgImp.imgSave(imgid.toString(),id)){
						System.out.println("jdbc.imgUrlImp.imgSave:头像更改成功!");
					}
				}
				return false;
			} finally{
				DbUtils.close(connection, statement, rs);
			}
		}
		return true;
	}
	
	//头像修改
	public static Boolean imgChange(String imgId,String userId){
		connection = DbUtils.getConnection();
		
		System.out.println(imgId);
		if(headerPtChgImp.imgSave(imgId,userId)){
			System.out.println("jdbc.imgUrlImp.imgChange:头像更改成功!");
		}
		else{
			System.out.println("jdbc.imgUrlImp.imgChange:头像上传失败!");
			return false;
		}
		return true;
	}
	
	
	//获取头像地址
	public static List getImgUrl(String username){
		String url;
		imgUrlBean imgBean;
		List<imgUrlBean> list = new ArrayList<imgUrlBean>();
		connection = DbUtils.getConnection();
		String sql;
		String userId = SelectID.selectId(username);
		sql = "select  d.url from t_user a,t_user_info b,t_user_img c,t_imgurl d where a.userId=? AND a.InfoId = b.InfoId AND b.imgId = c.imgId AND C.imgId = d.imgId;";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			rs = statement.executeQuery();
			while(rs.next()){
				url = rs.getString("url");
				imgBean = new imgUrlBean(null,url);
				list.add(imgBean);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("dbc.imgUrlImp.getImgUrl:查询失败,该用户不存在!");
		}finally{
			DbUtils.close(connection, statement,  rs);
		}
		return list;
	}
	
	//用户后台图片库信息获取
	public static List getPictureUrl(String username){
		String imgName;
		String url;
		imgUrlBean imgBean;
		List<imgUrlBean> list = new ArrayList<imgUrlBean>();
		connection = DbUtils.getConnection();
		String sql;
		String imgId=null;
		String id= SelectID.selectId(username);
		if(id!=null||id!=""){
			sql = "SELECT  * from t_user_img a,t_imgurl b WHERE a.userId = ? and a.imgId = b.imgId;";
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1,id);
				rs = statement.executeQuery();
				while(rs.next()){
					imgId = rs.getString("imgId");
					url = rs.getString("url");
					imgName = rs.getString("imgName");
					imgBean = new imgUrlBean(imgId,url,imgName);
					list.add(imgBean);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("jdbc.imgUrlImp.getPictureUrl:查询失败,该用户不存在!");
			}finally{
				DbUtils.close(connection, statement,  rs);
			}
		}else{
			System.out.println("jdbc.imgUrlImp.getPictureUrl:id不存在!");
		}
		return list;
	}
	
	
	public Boolean delectImg(String username,String imgName){
		connection = DbUtils.getConnection();
		String sql;
		String id=null;
		id= SelectID.selectId(username);
		if(id!=null||id!=""){
			
			sql = "delete from imgurl where imgName=?";
			try {
				statement=connection.prepareStatement(sql);
				statement.setObject(1, imgName);
				return statement.executeUpdate()>0?true:false;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DbUtils.close(connection, statement, null);
			}
		}else{
			System.out.println("jdbc.imgUrlImp.delectImg:id不存在");
			return false;
		}
		return true;
	}
}
