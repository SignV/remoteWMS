package com.signv.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 将socket service随tomcat启动
 * @author zhangzhongwen
 *
 */
public class SocketServiceLoader implements ServletContextListener{
    //socket server 线程
//    private SocketThread socketThread;
    private SocketOperate socketOperate;

    public void contextDestroyed(ServletContextEvent arg0) {
//        if(null!=socketThread && !socketThread.isInterrupted())
//        {
//            socketThread.closeSocketServer();
//            socketThread.interrupt();
//        }
        if(null!=socketOperate && !socketOperate.isInterrupted())
        {
            socketOperate.closeSocketServer();
            socketOperate.interrupt();
        }
    }

    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
//        if(null==socketThread)
//        {
//            //新建线程类
//            socketThread=new SocketThread(null);
//            //启动线程
//            socketThread.start();
//        }
        if(null==socketOperate)
        {
            //新建线程类
            socketOperate=new SocketOperate();
            //启动线程
            socketOperate.start();
        }

    }

}
