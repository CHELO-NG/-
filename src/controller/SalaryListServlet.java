package controller;

import dao.SalaryDao;
import daoimpl.SalaryDaoImpl;
import entity.Goods;
import entity.Page;
import entity.Salary;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SalaryListServlet extends HttpServlet {
    private SalaryDao salaryDao=new SalaryDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int start=0;
        int count=10;
        start=Integer.parseInt(req.getParameter("page.start"));
        count=Integer.parseInt(req.getParameter("page.count"));

        Page page=new Page(start,count);
        List<Salary> salaries=null;
        try {
            salaries=salaryDao.list(page.getStart(),page.getCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int total=0;
        try {
            total=salaryDao.getTotal();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setTotal(total);
        req.setAttribute("goods",salaries);
        req.setAttribute("page",page);
        req.getRequestDispatcher("").forward(req,resp);// 工资页面
    }
}
