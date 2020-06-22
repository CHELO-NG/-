package controller;

import entity.Courier;
import service.CourierService;
import serviceimpl.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCourierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String courierName=req.getParameter("courierName");
        String courierPhone=req.getParameter("courierPhone");
        String courierArea=req.getParameter("courierArea");
        String courierSalary=req.getParameter("courierSalary");
        Courier courier=new Courier(0,courierName,courierPhone,courierArea,courierSalary);

        CourierService courierService=new CourierServiceImpl();
        int n=courierService.addCourier(courier);

        if (n>0){
            resp.sendRedirect("courier");// 派送员页面
        }else {
            req.getRequestDispatcher("addCourier.jsp").forward(req,resp);// 添加派送员页面
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
