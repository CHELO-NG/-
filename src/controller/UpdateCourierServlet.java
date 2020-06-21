package controller;

import entity.Courier;
import service.CourierService;
import serviceimpl.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCourierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String courierID=req.getParameter("courierID");
        String courierName=req.getParameter("courierName");
        String courierPhone=req.getParameter("courierPhone");
        String courierArea=req.getParameter("courierArea");
        String courierSalary=req.getParameter("courierSalary");
        Courier courier=new Courier(courierID,courierName,courierPhone,courierArea,courierSalary);

        CourierService courierService=new CourierServiceImpl();
        int n=courierService.updateCourier(courier);
        if (n>0){
            resp.sendRedirect("courier");// 派送员页面
        }else {
            resp.sendRedirect("courier");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
