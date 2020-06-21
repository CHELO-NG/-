package controller;

import entity.Goods;
import service.GoodsService;
import serviceimpl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class QueryGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String goodsID=req.getParameter("goodsID");
        GoodsService courierService=new GoodsServiceImpl();
        Goods goods=null;
        try {
            goods=courierService.queryOneGoods(goodsID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (goods!=null){
            req.setAttribute("goods",goods);
            req.getRequestDispatcher("updateGoods.jsp").forward(req,resp);
        }
    }
}
