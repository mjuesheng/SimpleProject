package com.blog.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.javabean.docBean;
import com.blog.jdbc.IntererstingImp;
import com.blog.jdbc.docImp;
import com.common.until.Logger;
import com.common.until.wordcount;

/**
 * Servlet implementation class documentServlet
 */
@WebServlet("/documentServlet")
public class documentServlet extends HttpServlet {
      
    public documentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String messageId = request.getParameter("messageId");
		List<docBean> list = docImp.getDocInfo(messageId);
		//文章阅读数+1   统计文章阅读数，方便推荐
		docImp.addReadNum(messageId);
		Map map = new HashMap();
		String url = docImp.getImgUrl(list.get(0).getImgId());
		for(int i=0;i<list.size();i++){
			map.put("messageId", list.get(i).getMessageId());
			map.put("username", list.get(i).getUsername());
			map.put("personalIntro", list.get(i).getPersonalIntro());
			map.put("imgurl", url);
			map.put("textName", list.get(i).getTextName());
			map.put("txt", list.get(i).getTxt());
			map.put("date", list.get(i).getDate());
			map.put("txtNum", list.get(i).getTxtNum());
			map.put("readNum", list.get(i).getReadNum());
			map.put("type", list.get(i).getType());
		}
		
		//日志写入   --记录用户访问类型
		String username = (String) request.getSession().getAttribute("username");
		if(username != null && username.length()!= 0){
			Logger log = new Logger(username);	
			log.log((String)map.get("type")+" "+(String)map.get("textName"));
		}
		
		//词频分析
		if(username != null && username.length()!= 0){
			wordcount w = new wordcount();
			List l = w.readFile("E:/logs/"+username);
			List ll = new ArrayList();
			for(int i=0;i<l.size();i++){
				String str[] = l.get(i).toString().split("=");
				if(str[0].equals("推荐") || str[0].equals("最新文章")){
					continue;
				}else{
					ll.add(str[0]);
				}
			}
			try {
				IntererstingImp.WordCountSave(username, ll);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("/document.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
