package com.common.Listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.common.until.ApplicationContext;

/**
 * Application Lifecycle Listener implementation class SessionLisenter
 *
 */
@WebListener
public class SessionLisenter implements HttpSessionListener, HttpSessionAttributeListener {

	ServletContext application = null;
    /**
     * Default constructor. 
     */
    public SessionLisenter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent sessionEvent)  { 
		// TODO Auto-generated method stub
    	 //Session创建时被调用 
    	application = sessionEvent.getSession().getServletContext();
        HttpSession session = sessionEvent.getSession();  
        ApplicationContext.SESSION_MAP.put(session.getId(), session);//保存session  
        ApplicationContext.TOTAL_HISTORY_COUNT++;//访问人数增加 
        //如果当前在线人数超过历史记录  
        if(ApplicationContext.SESSION_MAP.size()>ApplicationContext.MAX_ONLINE_COUNT){  
        	ApplicationContext.MAX_ONLINE_COUNT = ApplicationContext.SESSION_MAP.size();//更新最大在线人数  
        	ApplicationContext.MAX_ONLINE_COUNT_DATE = new Date();//更新时间  
        }
        //将当前在线人数和历史在线人数放入全局变量
        application.setAttribute("historypeople", ApplicationContext.TOTAL_HISTORY_COUNT);
        application.setAttribute("onlinepeople", ApplicationContext.CURRENT_LOGIN_COUNT);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent sessionEvent)  { 
         // TODO Auto-generated method stub
    	ApplicationContext.CURRENT_LOGIN_COUNT = ApplicationContext.CURRENT_LOGIN_COUNT-1;
    	application.setAttribute("onlinepeople", ApplicationContext.CURRENT_LOGIN_COUNT);
    	
    	HttpSession session = sessionEvent.getSession();  
    	ApplicationContext.SESSION_MAP.remove(session.getId());//移除session记录  
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	if(event.getName().equals("username")){  
        	ApplicationContext.CURRENT_LOGIN_COUNT++;
        	
        	// *****************************
            application.setAttribute("onlinepeople", ApplicationContext.CURRENT_LOGIN_COUNT);
            application.setAttribute("historypeople", ApplicationContext.TOTAL_HISTORY_COUNT);
            // *****************************
            
            HttpSession session = event.getSession();  
            //查找该账号有么有在其他机器上登录  
            for (HttpSession sess : ApplicationContext.SESSION_MAP.values()) {  
                //如果该账号已经在其他机器上登录了，则以前的登录失效  
                if(event.getValue().equals(sess.getAttribute("username")) && session.getId()!= sess.getId()){  
                    sess.invalidate();//使session失效  
                }
            }  
        }  
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	// 添加属性时被调用  
    	if(event.getName().equals("username")){  
    		ApplicationContext.CURRENT_LOGIN_COUNT--; 
    		// *****************************
            application.setAttribute("onlinepeople", ApplicationContext.CURRENT_LOGIN_COUNT);
            application.setAttribute("historypeople", ApplicationContext.TOTAL_HISTORY_COUNT);
            // *****************************
        }  
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	// 修改属性时被调用  
        if(event.getName().equals("username")){  
            HttpSession session = event.getSession();  
            //查找该账号有么有在其他机器上登录  
            for (HttpSession sess : ApplicationContext.SESSION_MAP.values()) {  
                //如果该账号已经在其他机器上登录了，则以前的登录失效  
                if(event.getValue().equals(sess.getAttribute("username")) && session.getId()!= sess.getId()){  
                    sess.invalidate();//使session失效  
                }
            }  
        }  
    }
}
