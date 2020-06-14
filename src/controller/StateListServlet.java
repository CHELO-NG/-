package controller;

import dao.StateDao;
import daoimpl.StateDaoImpl;
import entity.Page;
import entity.State;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StateListServlet extends HttpServlet {
    private StateDao stateDao=new StateDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int start=0;
        int count=10;
        start=Integer.parseInt(req.getParameter("page.start"));
        count=Integer.parseInt(req.getParameter("page.count"));

        Page page=new Page(start,count);
        List<State> states=null;
        try {
            states=stateDao.list(page.getStart(),page.getCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int total=0;
        try {
            total=stateDao.getTotal();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setTotal(total);
        req.setAttribute("goods",states);
        req.setAttribute("page",page);
        req.getRequestDispatcher("").forward(req,resp);// 货物状态页面
    }
}
