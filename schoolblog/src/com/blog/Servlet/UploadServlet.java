package com.blog.Servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.blog.jdbc.headerPtChgImp;
import com.blog.jdbc.imgUrlImp;
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = (String) request.getSession().getAttribute("username");
		//username="admin";
		
		response.setContentType("text/html");//"application/json"  //"image/png"
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		DiskFileItemFactory diif=new DiskFileItemFactory();
		// 2.创建servlet文件上传组件
		ServletFileUpload upload = new ServletFileUpload(diif);
		// 3.文件列表
		List fileList = null;
		// 解析request从而得到前台传过来的文件
		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			ex.printStackTrace();
			return;
		}
		String saveUrl="upload\\"+username;
		String dirFile=this.getServletConfig().getServletContext().getRealPath("/")+saveUrl;
		//创建文件夹
		File newFile = new File(dirFile); 
		if(!new File(dirFile).exists()){
			System.out.println("文件夹不存在!");
			Boolean cr = newFile.mkdirs();
			if(cr){
				System.out.println("文件夹创建成功!");
			}
		}
		@SuppressWarnings("unchecked")
		Iterator<FileItem> it = fileList.iterator();
		while (it.hasNext()) {
			FileItem item = it.next();
			String fileName = item.getName();
			long fileSize = item.getSize();
			// 如果不是普通表单域，当做文件域来处理
			if (!item.isFormField()) {
				//检查文件大小
				BufferedInputStream in = new BufferedInputStream(item.getInputStream());
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(new File(dirFile + "\\"
								+ item.getName())));
				System.out.println("绝对路径:"+dirFile+"\\"+item.getName());   //绝对路径
				System.out.println("相对路径:"+saveUrl+item.getName());    //保存到数据库的相对路径
				String url = saveUrl+"\\"+item.getName();
				Boolean save = imgUrlImp.imgSave(username, url,item.getName());
				if(save){
					System.out.println("Servlet消息:上传成功!");
				}else{
					System.out.println("Servlet消息:上传失败!");
				}
				Streams.copy(in, out, true);
				response.sendRedirect("PersonalAdmin.jsp");
			}else{
				System.out.println(item.getFieldName());
			}
		}
	}
}
