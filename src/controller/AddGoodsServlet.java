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

public class AddGoodsServlet extends HttpServlet {
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
        String courierPhone=req.getParameter("courierPhone");
        String goodsState=req.getParameter("goodsState");
        String date_str = req.getParameter("date");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Goods goods=null;
        try {
            Date date=df.parse(date_str);
            goods=new Goods(goodsID,goodsName,goodsStart,goodsSend,consigner,consignee,phone,courierID,courierPhone,date,goodsState);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        GoodsService goodsService=new GoodsServiceImpl();
        int n=goodsService.addGoods(goods);
        if (n>0){
            resp.sendRedirect("goods");// 货物页面
        }else {
            req.getRequestDispatcher("addGoods.jsp").forward(req,resp);// 添加货物页面
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
