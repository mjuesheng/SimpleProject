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
    	 //Session����ʱ������ 
    	application = sessionEvent.getSession().getServletContext();
        HttpSession session = sessionEvent.getSession();  
        ApplicationContext.SESSION_MAP.put(session.getId(), session);//����session  
        ApplicationContext.TOTAL_HISTORY_COUNT++;//������������ 
        //�����ǰ��������������ʷ��¼  
        if(ApplicationContext.SESSION_MAP.size()>ApplicationContext.MAX_ONLINE_COUNT){  
        	ApplicationContext.MAX_ONLINE_COUNT = ApplicationContext.SESSION_MAP.size();//���������������  
        	ApplicationContext.MAX_ONLINE_COUNT_DATE = new Date();//����ʱ��  
        }
        //����ǰ������������ʷ������������ȫ�ֱ���
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
    	ApplicationContext.SESSION_MAP.remove(session.getId());//�Ƴ�session��¼  
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
            //���Ҹ��˺���ô�������������ϵ�¼  
            for (HttpSession sess : ApplicationContext.SESSION_MAP.values()) {  
                //������˺��Ѿ������������ϵ�¼�ˣ�����ǰ�ĵ�¼ʧЧ  
                if(event.getValue().equals(sess.getAttribute("username")) && session.getId()!= sess.getId()){  
                    sess.invalidate();//ʹsessionʧЧ  
                }
            }  
        }  
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	// �������ʱ������  
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
    	// �޸�����ʱ������  
        if(event.getName().equals("username")){  
            HttpSession session = event.getSession();  
            //���Ҹ��˺���ô�������������ϵ�¼  
            for (HttpSession sess : ApplicationContext.SESSION_MAP.values()) {  
                //������˺��Ѿ������������ϵ�¼�ˣ�����ǰ�ĵ�¼ʧЧ  
                if(event.getValue().equals(sess.getAttribute("username")) && session.getId()!= sess.getId()){  
                    sess.invalidate();//ʹsessionʧЧ  
                }
            }  
        }  
    }
}
