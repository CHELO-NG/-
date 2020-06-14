package controller;

import entity.State;
import service.StateService;
import serviceimpl.StateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateStateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String goodsID=req.getParameter("goodsID");
        String goodsState=req.getParameter("goodsState");
        State state=new State(goodsID,goodsState);

        StateService stateService=new StateServiceImpl();
        int n=stateService.updateState(state);
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
