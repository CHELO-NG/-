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

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String adminID=req.getParameter("adminID");
        String adminPassword=req.getParameter("adminPassword");

        Admin admin=new Admin(adminID,adminPassword);
        AdminService adminService=new AdminServiceImpl();
        int n=0;
        try {
            n=adminService.register(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (n>0){
            req.getSession().setAttribute("admin",admin);
            resp.sendRedirect("adminLogin.jsp");// 注册成功
        }else {
            String error="注册失败";
            if (n==1){
                error="您填写的登录ID已经存在！";
            }
            req.getSession().setAttribute("error",error);
            resp.sendRedirect("");// 注册失败
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
