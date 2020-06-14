package controller;

import entity.Salary;
import service.SalaryService;
import serviceimpl.SalaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateSalaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String courierID=req.getParameter("courierID");
        String courierSalary=req.getParameter("courierSalary");
        Salary salary=new Salary(courierID,courierSalary);

        SalaryService salaryService=new SalaryServiceImpl();
        int n=salaryService.updateSalary(salary);
        if (n>0){
            resp.sendRedirect("salary.jsp");// 工资页面
        }else {
            resp.getWriter().println("更新失败！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
