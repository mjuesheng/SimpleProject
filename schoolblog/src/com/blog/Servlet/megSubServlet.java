package com.blog.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.javabean.megSubBean;
import com.blog.jdbc.megSubImpl;
import com.blog.jdbc.messageImpl;

@WebServlet("/megSubServlet")
public class megSubServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String result=null;
		String username = (String) request.getSession().getAttribute("username");
		String title = request.getParameter("title");
		String introduce = request.getParameter("introduce");
		String text = request.getParameter("textEditor");
		String inlineRadioOptions = request.getParameter("inlineRadioOptions");//����ݸ���
		String inlineCheckbox1 = request.getParameter("inlineCheckbox1");  //��������
		String inlineCheckbox2 = request.getParameter("inlineCheckbox2");  //��ʾ���ҵĲ�����ҳ    
		String textType = request.getParameter("textType");
		megSubBean megSub = new megSubBean();
		megSubImpl imp = new megSubImpl();
		
		System.out.println(inlineRadioOptions);
		System.out.println(textType);
		if(inlineCheckbox1==null||inlineCheckbox1.length() <= 0){
			inlineCheckbox1 = "kong";
		}
		if(inlineCheckbox2==null||inlineCheckbox2.length() <= 0){
			inlineCheckbox2 = "kong";
		}
		//��������  ��������  ��ҳ
		if(inlineCheckbox1!=null && inlineCheckbox2!=null&& inlineCheckbox1.equals("discuss") && inlineCheckbox2.equals("homePage")){
			System.out.println("------------------ ��������  ��ҳ   ---------------------");
			megSub.setUsername(username);
			megSub.setTitle(title);
			megSub.setIntroduce(introduce);
			megSub.setText(text);
			megSub.setTextType(textType);
			megSub.setDiscuss("Y");
			megSub.setHomePage("Y");
			switch (inlineRadioOptions) {
				case "release":
					result = imp.saveRelease(megSub);
					request.getSession().setAttribute("megMsg", result);
					System.out.println("�����ɹ�");
					break;
				case "draftbox":
					result = imp.saveDraftBox(megSub);
					request.getSession().setAttribute("megMsg", result);
					System.out.println("�ݸ��䱣��ɹ�");
					break;
				default:
					request.getSession().setAttribute("megMsg", "�����Ͳݸ���ѡһ��!");
					System.out.println("�����Ͳݸ���ѡһ��!");
			}
			
			
		}
		else if(!inlineCheckbox1.equals("discuss") && inlineCheckbox2.equals("homePage")){
			System.out.println("------------------  ����������  ��ҳ  ---------------------");
			megSub.setUsername(username);
			megSub.setTitle(title);
			megSub.setIntroduce(introduce);
			megSub.setText(text);
			megSub.setTextType(textType);
			megSub.setDiscuss("N");
			megSub.setHomePage("Y");
			switch (inlineRadioOptions) {
				case "release":
					result = imp.saveRelease(megSub);
					request.getSession().setAttribute("megMsg", result);
					break;
				case "draftbox":
					result = imp.saveDraftBox(megSub);
					request.getSession().setAttribute("megMsg", result);
					break;
				default:
					request.getSession().setAttribute("megMsg", "�����Ͳݸ���ѡһ��!");
					System.out.println("�����Ͳݸ���ѡһ��!");
			}
		}
		else if(inlineCheckbox1.equals("discuss") && !inlineCheckbox2.equals("homePage")){
			System.out.println("------------------  ��������  ����ҳ  ---------------------");
			megSub.setUsername(username);
			megSub.setTitle(title);
			megSub.setIntroduce(introduce);
			megSub.setText(text);
			megSub.setTextType(textType);
			megSub.setDiscuss("N");
			megSub.setHomePage("Y");
			switch (inlineRadioOptions) {
				case "release":
					result = imp.saveRelease(megSub);
					request.getSession().setAttribute("megMsg", result);
					break;
				case "draftbox":
					result = imp.saveDraftBox(megSub);
					request.getSession().setAttribute("megMsg", result);
					break;
				default:
					request.getSession().setAttribute("megMsg", "�����Ͳݸ���ѡһ��!");
					System.out.println("�����Ͳݸ���ѡһ��!");
			}
		}else{
			System.out.println("------------------  ����������  ����ҳ  ---------------------");
			megSub.setUsername(username);
			megSub.setTitle(title);
			megSub.setIntroduce(introduce);
			megSub.setText(text);
			megSub.setTextType(textType);
			megSub.setDiscuss("N");
			megSub.setHomePage("N");
			switch (inlineRadioOptions) {
				case "release":
					result = imp.saveRelease(megSub);
					request.getSession().setAttribute("megMsg", result);
					break;
				case "draftbox":
					result = imp.saveDraftBox(megSub);
					request.getSession().setAttribute("megMsg", result);
					break;
				default:
					request.getSession().setAttribute("megMsg", "�����Ͳݸ���ѡһ��!");
					System.out.println("�����Ͳݸ���ѡһ��!");
			}
		}
		response.sendRedirect("msgInfo.jsp");
	}
}