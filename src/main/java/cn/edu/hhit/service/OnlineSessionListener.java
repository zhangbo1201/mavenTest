package cn.edu.hhit.service;

import javax.servlet.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2117:59
 */
public class OnlineSessionListener implements HttpSessionListener,ServletContextListener,ServletContextAttributeListener,ServletRequestListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scab) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scab) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scab) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        Integer num = (Integer) se.getSession().getServletContext().getAttribute("onlineNum");
        if(num==null){
            num = 0;
        }
        se.getSession().getServletContext().setAttribute("onlineNum",num+1);
        System.out.println("人数加1");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Integer num = (Integer) se.getSession().getServletContext().getAttribute("onlineNum");
        if(num==null){
            num = 0;
        }
        se.getSession().getServletContext().setAttribute("onlineNum",num-1);
        System.out.println("人数减1");
    }
}
