package com.yjm.springbootdemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter过滤器demo
 *
 * javax.servlet 创建servlet
 *
 * @ServletComponentScan 启动类声明-》扫描servlet bean
 * @WebFilter： 声明类为filter过滤器-》提供给容器扫描调用
 * 对url进行通配符拦截
 * urlPatterns，路由：拦截规则，支持正则
 */
//@WebFilter(urlPatterns = "/api/v1/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    /**
     * 容器加载的时候调用
     * Filter 的整个生命周期只会被调用一次
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginFilter");
    }

    /**
     * 请求被拦截的时候进行调用
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter loginFilter");

        //获得客户端请求的所有信息
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //应答请求的所有信息
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String username = req.getParameter("username");

        //权鉴规则，用户名校验-》校验通过后不进行过滤
        //控制chain.doFilter的方法的调用，来实现是否通过放行
        if ("yjm".equals(username)) {
            /**
             * 通过FilterChain对象的doFilter接口，来决定是否调用web资源
             * 继续走下面的步骤
             */
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            /**
             * 拦截--》重定向跳转页面：适用于非前后端分离框架
             */
            resp.sendRedirect("/index.html");
            return;
        }
    }

    /**
     * 容器被销毁的时候被调用
     * Filter 的整个生命周期只会被调用一次
     */
    @Override
    public void destroy() {

        System.out.println("destroy loginFilter");
    }
}
