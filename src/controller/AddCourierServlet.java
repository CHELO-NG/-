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

        String courierCode=req.getParameter("courierCode");
        String courierName=req.getParameter("courierName");
        String courierPhone=req.getParameter("courierPhone");
        Courier courier=new Courier(courierCode,courierName,courierPhone);

        CourierService courierService=new CourierServiceImpl();
        int n=courierService.addCourier(courier);
        if (n>0){
            resp.sendRedirect("");// 派送员页面
        }else {
            req.getRequestDispatcher("").forward(req,resp);// 添加派送员页面
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
