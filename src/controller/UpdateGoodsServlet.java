package controller;

import entity.Goods;
import service.GoodsService;
import serviceimpl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String goodsID=req.getParameter("goodsID");
        String goodsName=req.getParameter("goodsName");
        String goodsStart=req.getParameter("goodsStart");
        String goodsSend=req.getParameter("goodsSend");
        String consigner=req.getParameter("consigner");
        String consignee=req.getParameter("consignee");
        String phone=req.getParameter("phone");
        String courierID=req.getParameter("courierID");
        String date_str = req.getParameter("date");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Goods goods=null;
        try {
            Date date=df.parse(date_str);
            goods=new Goods(goodsID,goodsName,goodsStart,goodsSend,consigner,consignee,phone,courierID,date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        GoodsService goodsService=new GoodsServiceImpl();
        int n=goodsService.updateGoods(goods);
        if (n>0){
            resp.sendRedirect("goods.jsp");// 货物页面
        }else {
            resp.getWriter().println("更新失败！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
