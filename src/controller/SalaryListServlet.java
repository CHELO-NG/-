package controller;

import dao.SalaryDao;
import daoimpl.SalaryDaoImpl;
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
        String keywords=req.getParameter("keywords");
        try {
            start=Integer.parseInt(req.getParameter("page.start"));
            count=Integer.parseInt(req.getParameter("page.count"));
        }catch (Exception e){
            e.printStackTrace();
        }

        Page page=new Page(start,count);
        List<Salary> salary=null;

        try {
            if (keywords==null){
                salary=salaryDao.list(page.getStart(),page.getCount());
            }else {
                salary=salaryDao.listByKeywords(page.getStart(),page.getCount(),keywords);
            }

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
        req.setAttribute("salary",salary);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/salary.jsp").forward(req,resp);// 货物页面
    }
}
