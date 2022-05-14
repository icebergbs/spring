package com.example.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyDataContextListener implements ServletContextListener {
    private ServletContext context = null;

    //该方法在ServletContext 启动子后被调用,并准备好处理客户端请求
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.context = servletContextEvent.getServletContext();
        //通过你可以实现自己的逻辑并将结果记录在属性中
        context.setAttribute("myData", "this is myData");
    }

    //这个方法在ServletContext将要关闭的时候调用
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.context = null;
    }
}
