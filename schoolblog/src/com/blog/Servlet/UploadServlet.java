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
		// 2.����servlet�ļ��ϴ����
		ServletFileUpload upload = new ServletFileUpload(diif);
		// 3.�ļ��б�
		List fileList = null;
		// ����request�Ӷ��õ�ǰ̨���������ļ�
		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			ex.printStackTrace();
			return;
		}
		String saveUrl="upload\\"+username;
		String dirFile=this.getServletConfig().getServletContext().getRealPath("/")+saveUrl;
		//�����ļ���
		File newFile = new File(dirFile); 
		if(!new File(dirFile).exists()){
			System.out.println("�ļ��в�����!");
			Boolean cr = newFile.mkdirs();
			if(cr){
				System.out.println("�ļ��д����ɹ�!");
			}
		}
		@SuppressWarnings("unchecked")
		Iterator<FileItem> it = fileList.iterator();
		while (it.hasNext()) {
			FileItem item = it.next();
			String fileName = item.getName();
			long fileSize = item.getSize();
			// ���������ͨ���򣬵����ļ���������
			if (!item.isFormField()) {
				//����ļ���С
				BufferedInputStream in = new BufferedInputStream(item.getInputStream());
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(new File(dirFile + "\\"
								+ item.getName())));
				System.out.println("����·��:"+dirFile+"\\"+item.getName());   //����·��
				System.out.println("���·��:"+saveUrl+item.getName());    //���浽���ݿ�����·��
				String url = saveUrl+"\\"+item.getName();
				Boolean save = imgUrlImp.imgSave(username, url,item.getName());
				if(save){
					System.out.println("Servlet��Ϣ:�ϴ��ɹ�!");
				}else{
					System.out.println("Servlet��Ϣ:�ϴ�ʧ��!");
				}
				Streams.copy(in, out, true);
				response.sendRedirect("PersonalAdmin.jsp");
			}else{
				System.out.println(item.getFieldName());
			}
		}
	}
}
