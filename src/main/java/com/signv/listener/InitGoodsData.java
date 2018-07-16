package com.signv.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * @Author xp
 * @Description 监听程序初始化
 * @Date 2017/4/23 21:48
 */
@Component
public class InitGoodsData implements ServletContextListener,ApplicationContextAware{

    private static ApplicationContext applicationContext;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //先获取servlet上下文
        ServletContext application = servletContextEvent.getServletContext();
        //获取博客类别信息service，然后获取博客类别信息，并保存到域中
//        BlogTypeService blogTypeService = applicationContext.getBean(BlogTypeService.class);
//        List<BlogType> blogTypeList = blogTypeService.getBlogTypeDataCount();
//        application.setAttribute("blogTypeList",blogTypeList);
//        //获取博客信息service，然后获取博客信息，并保存到域中
//
//        //获取最新的博客信息service，然后获取最新的几条博客信息，并保存在域中
//        BlogService blogService = applicationContext.getBean(BlogService.class);
//        List<Blog> newBlogList = blogService.get5NewBlog();
//        application.setAttribute("newBlogList",newBlogList);

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        InitBloggerData.applicationContext = applicationContext;
    }
}
