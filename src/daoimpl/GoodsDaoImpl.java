package daoimpl;

import dao.GoodsDao;
import entity.Courier;
import entity.Goods;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public int addGoods(Goods goods) {
        String sql1 = "insert into goods (goodsID,goodsName,goodsStart,goodsSend,consigner,consignee,phone,courierID,date) values(?,?,?,?,?,?,?,?,?)";
        Object[] objs1 = {goods.getGoodsID(),goods.getGoodsName(),goods.getGoodsStart(),
        goods.getGoodsSend(),goods.getConsigner(),goods.getConsignee(),goods.getPhone(),
        goods.getCourierID(),goods.getDate()};
        int n1 = JDBCUtil.excuteDML(sql1, objs1);
        String sql2 = "insert into state (goodsID,goodsState) values(?,?)";
        Object[] objs2 = {goods.getGoodsID(),goods.getGoodsState()};
        int n2= JDBCUtil.excuteDML(sql2, objs2);
        return (n1+n2)/2;
    }

    @Override
    public int deleteGoods(String goodsID) {
        String sql1 = "delete from state where goodsID=?";
        Object[] objs1 = {goodsID};
        int n1 = JDBCUtil.excuteDML(sql1, objs1);
        String sql2 = "delete from goods where goodsID=?";
        Object[] objs2 = {goodsID};
        int n2 = JDBCUtil.excuteDML(sql2, objs2);
        return (n1+n2);
    }

    @Override
    public int updateGoods(Goods goods) {
        String sql1 = "update goods set goodsName=?,goodsStart=?,goodsSend=?,consigner=?,consignee=?,phone=?" +
                "courierID=?,date=?,goodsState=? where goodsID=?";
        Object[] objs1 = {goods.getGoodsName(),goods.getGoodsStart(),
                goods.getGoodsSend(),goods.getConsigner(),goods.getConsignee(),goods.getPhone(),
                goods.getCourierID(),goods.getDate(),goods.getGoodsState(),goods.getGoodsID()};
        int n1 = JDBCUtil.excuteDML(sql1, objs1);
        String sql2 = "update state set goodsState=? where goodsID=?";
        Object[] objs2 = {goods.getGoodsState(),goods.getGoodsID()};
        int n2 = JDBCUtil.excuteDML(sql2, objs2);
        return n1+n2;
    }

    @Override
    public int getTotal() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        int total = 0;
        String sql = "SELECT COUNT(*) FROM goods,state,courier where goods.goodsID=state.goodsID and goods.courierID=courier.courierID";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        try {
            rs=ps.executeQuery();
            while (rs.next()){
                total=rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(total);
        return total;
    }

    @Override
    public Goods selectGoods(String goodsID) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select goods.goodsID,goodsName,goodsStart,goodsSend,consigner,consignee,phone,goods.courierID," +
                "courierPhone,date,goodsState from goods,state,courier where goods.goodsID=? and goods.goodsID=state.goodsID and goods.courierID=courier.courierID";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        try {
            ps.setString(1, goodsID);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet rs = null;
        Goods goods=null;
        try {
            rs = ps.executeQuery();
            if(rs.next()) {
                goods = new Goods(rs.getString("goods.goodsID"), rs.getString("goodsName"), rs.getString("goodsStart"),
                        rs.getString("goodsSend"), rs.getString("consigner"), rs.getString("consignee"),
                        rs.getString("phone"), rs.getString("goods.courierID"),rs.getString("courierPhone"),
                        rs.getDate("date"),rs.getString("goodsState"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return goods;
    }

    @Override
    public List<Goods> list(int start, int count) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql="select * from (select goods.goodsID,goodsName,goodsStart,goodsSend,consigner,consignee,phone,courier.courierID," +
                "courierPhone,date,goodsState from goods,state,courier where goods.goodsID=state.goodsID and goods.courierID=courier.courierID) g limit ?,?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Goods> list = new ArrayList<Goods>();
        try {
            ps.setInt(1,start);
            ps.setInt(2,count);
            rs = ps.executeQuery();
            while(rs.next()) {
                Goods goods = new Goods(rs.getString("goodsID"), rs.getString("goodsName"), rs.getString("goodsStart"),
                        rs.getString("goodsSend"), rs.getString("consigner"), rs.getString("consignee"),
                        rs.getString("phone"), rs.getString("courierID"),rs.getString("courierPhone"),
                        rs.getDate("date"),rs.getString("goodsState"));
                list.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return list;
    }
}
