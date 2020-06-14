package controller;

import dao.CourierDao;
import daoimpl.CourierDaoImpl;
import entity.Courier;
import entity.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CourierListServlet extends HttpServlet {
    private CourierDao courierDao=new CourierDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int start=0;
        int count=10;
        start=Integer.parseInt(req.getParameter("page.start"));
        count=Integer.parseInt(req.getParameter("page.count"));

        Page page=new Page(start,count);
        List<Courier> couriers=null;
        try {
            couriers=courierDao.list(page.getStart(),page.getCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int total=0;
        try {
            total=courierDao.getTotal();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setTotal(total);
        req.setAttribute("couriers",couriers);
        req.setAttribute("page",page);
        req.getRequestDispatcher("courier.jsp").forward(req,resp);// 派送员页面
    }
}
