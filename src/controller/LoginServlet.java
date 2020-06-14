package controller;

import entity.Admin;
import service.AdminService;
import serviceimpl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String adminID=req.getParameter("adminID");
        String adminPassword=req.getParameter("adminPassword");
        AdminService adminService=new AdminServiceImpl();
        Admin admin=null;
        try {
            admin=adminService.login(adminID,adminPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (admin!=null){
            req.getSession().setAttribute("admin",admin);
            resp.sendRedirect("index.jsp");// 首页
        }else {
            req.getRequestDispatcher("").forward(req,resp);// 登录失败页面
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
