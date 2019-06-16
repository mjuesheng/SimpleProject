package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.javabean.megSubBean;
import com.blog.jdbc.megSubImpl;
import com.blog.jdbc.messageImpl;

/**
 * Servlet implementation class megUpdateServlet
 */
@WebServlet("/megUpdateServlet")
public class megUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public megUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//删除原文章
		String id = request.getParameter("id");
		messageImpl m = new messageImpl();
		m.delectMessage(id);
		//创建一个新的文章
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String result=null;
		String username = (String) request.getSession().getAttribute("username");
		String title = request.getParameter("title");
		String introduce = request.getParameter("introduce");
		String text = request.getParameter("textEditor");
		String inlineRadioOptions = request.getParameter("inlineRadioOptions");//存入草稿箱
		String inlineCheckbox1 = request.getParameter("inlineCheckbox1");  //允许评论
		String inlineCheckbox2 = request.getParameter("inlineCheckbox2");  //显示在我的博客首页    
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
		//允许发布  允许评论  首页
		if(inlineCheckbox1!=null && inlineCheckbox2!=null&& inlineCheckbox1.equals("discuss") && inlineCheckbox2.equals("homePage")){
			System.out.println("------------------ 允许评论  首页   ---------------------");
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
					System.out.println("发布成功");
					break;
				case "draftbox":
					result = imp.saveDraftBox(megSub);
					request.getSession().setAttribute("megMsg", result);
					System.out.println("草稿箱保存成功");
					break;
				default:
					request.getSession().setAttribute("megMsg", "发布和草稿箱选一个!");
					System.out.println("发布和草稿箱选一个!");
			}
			
			
		}
		else if(!inlineCheckbox1.equals("discuss") && inlineCheckbox2.equals("homePage")){
			System.out.println("------------------  不允许评论  首页  ---------------------");
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
					request.getSession().setAttribute("megMsg", "发布和草稿箱选一个!");
					System.out.println("发布和草稿箱选一个!");
			}
		}
		else if(inlineCheckbox1.equals("discuss") && !inlineCheckbox2.equals("homePage")){
			System.out.println("------------------  允许评论  不首页  ---------------------");
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
					request.getSession().setAttribute("megMsg", "发布和草稿箱选一个!");
					System.out.println("发布和草稿箱选一个!");
			}
		}else{
			System.out.println("------------------  不允许评论  不首页  ---------------------");
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
					request.getSession().setAttribute("megMsg", "发布和草稿箱选一个!");
					System.out.println("发布和草稿箱选一个!");
			}
		}
		response.sendRedirect("msgInfo.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
