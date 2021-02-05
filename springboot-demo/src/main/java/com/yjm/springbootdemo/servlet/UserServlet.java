package com.yjm.springbootdemo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义原生Servlet
 * demo：使用servlet3.0注解
 *
 */
@WebServlet(urlPatterns = "/api/test/customs", name = "userServlet")
public class UserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * 这里是获取http请求的参数，直接通过HttpServletRequest对象获取
         * 对比@RequestMapping，那边的是通过注解直接获取，直接封装了获取的过程
         */
        System.out.println(req.getParameter("username"));
        resp.getWriter().print("custom sevlet");
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //直接doPost中直接调用doGet，通过一个函数进行调用
        this.doGet(req, resp);


    }
}
