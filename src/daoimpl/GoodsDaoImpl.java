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
        String sql = "insert into goods values(?,?,?,?,?,?,?,?,?)";
        Object[] objs = {goods.getGoodsID(),goods.getGoodsName(),goods.getGoodsStart(),
        goods.getGoodsSend(),goods.getConsigner(),goods.getConsignee(),goods.getPhone(),
        goods.getCourierID(),goods.getDate()};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public int deleteGoods(String goodsID) {
        String sql = "delete from goods where goodsID=?";
        Object[] objs = {goodsID};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public int updateGoods(Goods goods) {
        String sql = "update goods set goodsName=?,goodsStart=?,goodsSend=?,consigner=?,consignee=?,phone=?" +
                "courierID=?,date=? where goodsID=?";
        Object[] objs = {goods.getGoodsName(),goods.getGoodsStart(),
                goods.getGoodsSend(),goods.getConsigner(),goods.getConsignee(),goods.getPhone(),
                goods.getCourierID(),goods.getDate(),goods.getGoodsID()};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public int getTotal() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        int total = 0;
        String sql = "SELECT COUNT(*) FROM goods";
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
        String sql = "select * from goods where goodsID=?";
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
                goods = new Goods(rs.getString("goodsID"), rs.getString("goodsName"), rs.getString("goodsStart"),
                        rs.getString("goodsSend"), rs.getString("consigner"), rs.getString("consignee"),
                        rs.getString("phone"), rs.getString("courierID"), rs.getDate("date"));
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
        String sql="select * from goods limit ?,?";
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
                        rs.getString("phone"), rs.getString("courierID"), rs.getDate("date"));
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
