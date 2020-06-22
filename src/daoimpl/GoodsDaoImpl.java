package daoimpl;

import dao.GoodsDao;
import entity.Courier;
import entity.Goods;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public int addGoods(Goods goods) {
        String sql1 = "insert into goods (goodsID,goodsName,goodsStart,goodsSend,consigner,consignee,phone,courierID,date) values(?,?,?,?,?,?,?,?,?)";
        Object[] objs1 = {goods.getGoodsID(), goods.getGoodsName(), goods.getGoodsStart(),
                goods.getGoodsSend(), goods.getConsigner(), goods.getConsignee(), goods.getPhone(),
                goods.getCourierID(), goods.getDate()};
        int n1 = JDBCUtil.excuteDML(sql1, objs1);
        String sql2 = "insert into state (goodsID,goodsState) values(?,?)";
        Object[] objs2 = {goods.getGoodsID(), goods.getGoodsState()};
        int n2 = JDBCUtil.excuteDML(sql2, objs2);
        return (n1 + n2) / 2;
    }

    @Override
    public int deleteGoods(int goodsID) {
        String sql1 = "delete from state where goodsID=?";
        Object[] objs1 = {goodsID};
        int n1 = JDBCUtil.excuteDML(sql1, objs1);
        String sql2 = "delete from goods where goodsID=?";
        Object[] objs2 = {goodsID};
        int n2 = JDBCUtil.excuteDML(sql2, objs2);
        return (n1 + n2) / 2;
    }

    @Override
    public int updateGoods(Goods goods) {
        String sql1 = "update goods set goodsName=?,goodsStart=?,goodsSend=?,consigner=?,consignee=?,phone=?" +
                "courierID=?,date=?,goodsState=? where goodsID=?";
        Object[] objs1 = {goods.getGoodsName(), goods.getGoodsStart(),
                goods.getGoodsSend(), goods.getConsigner(), goods.getConsignee(), goods.getPhone(),
                goods.getCourierID(), goods.getDate(), goods.getGoodsState(), goods.getGoodsID()};
        int n1 = JDBCUtil.excuteDML(sql1, objs1);
        String sql2 = "update state set goodsState=? where goodsID=?";
        Object[] objs2 = {goods.getGoodsState(), goods.getGoodsID()};
        int n2 = JDBCUtil.excuteDML(sql2, objs2);
        return n1 + n2;
    }

    @Override
    public int getTotal() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        int total = 0;
        String sql = "SELECT COUNT(*) FROM goods,state,courier where goods.goodsID=state.goodsID and goods.courierID=courier.courierID";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(total);
        return total;
    }

    @Override
    public Goods selectGoods(int goodsID) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select goods.goodsID,goodsName,goodsStart,goodsSend,consigner,consignee,phone,goods.courierID," +
                "courierPhone,date,goodsState from goods,state,courier where goods.goodsID=? and goods.goodsID=state.goodsID and goods.courierID=courier.courierID";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        try {
            ps.setInt(1, goodsID);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet rs = null;
        Goods goods = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                goods = new Goods(rs.getInt("goods.goodsID"), rs.getString("goodsName"), rs.getString("goodsStart"),
                        rs.getString("goodsSend"), rs.getString("consigner"), rs.getString("consignee"),
                        rs.getString("phone"), rs.getInt("goods.courierID"), rs.getString("courierPhone"),
                        rs.getDate("date"), rs.getString("goodsState"));
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
        String sql = "select * from (select goods.goodsID,goodsName,goodsStart,goodsSend,consigner,consignee,phone,courier.courierID," +
                "courierPhone,date,goodsState from goods,state,courier where goods.goodsID=state.goodsID and goods.courierID=courier.courierID) g limit ?,?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Goods> list = new ArrayList<Goods>();
        try {
            ps.setInt(1, start);
            ps.setInt(2, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                Goods goods = new Goods(rs.getInt("goodsID"), rs.getString("goodsName"), rs.getString("goodsStart"),
                        rs.getString("goodsSend"), rs.getString("consigner"), rs.getString("consignee"),
                        rs.getString("phone"), rs.getInt("courierID"), rs.getString("courierPhone"),
                        rs.getDate("date"), rs.getString("goodsState"));
                list.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return list;
    }

    @Override
    public List<Goods> listByKeywords(int start, int count, String keywords) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from (select goods.goodsID,goodsName,goodsStart,goodsSend,consigner,consignee,phone,courier.courierID,courierPhone,date,goodsState " +
                "from goods,state,courier where goods.goodsID=state.goodsID and goods.courierID=courier.courierID " +
                "and (goods.goodsID=? or goodsName=? or goodsStart=? or goodsSend=? or consigner=? or consignee=? or phone=? or courier.courierID=? or courierPhone=? or date=? or goodsState=?)) g limit ?,?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Goods> listByKeywords = new ArrayList<Goods>();

        try {
            Pattern pattern1 = Pattern.compile("[0-9]*");
            Pattern pattern2 = Pattern.compile("^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$");

            if (keywords != null && keywords != "" && pattern1.matcher(keywords).matches()) {
                ps.setInt(1, Integer.parseInt(keywords));
                ps.setInt(9, Integer.parseInt(keywords));
                ps.setString(10,null);
                System.out.println("keywords1=" + Integer.parseInt(keywords));
            }else if (keywords != null && keywords != "" &&pattern2.matcher(keywords).matches()){
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                ps.setString(1, "null");
                ps.setString(9, "null");
                ps.setDate(10,new java.sql.Date(df.parse(keywords).getTime()));
                System.out.println("keywords3=" + keywords);
                keywords=null;
            } else {
                ps.setString(1, keywords);
                ps.setString(9, keywords);
                ps.setString(10,null);
                System.out.println("keywords2=" + keywords);
            }
            ps.setString(2, keywords);
            ps.setString(3, keywords);
            ps.setString(4, keywords);
            ps.setString(5, keywords);
            ps.setString(6, keywords);
            ps.setString(7, keywords);
            ps.setString(8, keywords);
            ps.setString(11, keywords);
            ps.setInt(12, start);
            ps.setInt(13, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                Goods goods = new Goods(rs.getInt("goodsID"), rs.getString("goodsName"), rs.getString("goodsStart"),
                        rs.getString("goodsSend"), rs.getString("consigner"), rs.getString("consignee"),
                        rs.getString("phone"), rs.getInt("courierID"), rs.getString("courierPhone"),
                        rs.getDate("date"), rs.getString("goodsState"));
                listByKeywords.add(goods);
                System.out.println(goods.toString());
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return listByKeywords;
    }

    @Override
    public List<Goods> listByDate(int start, int count, Date date) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from (select goods.goodsID,goodsName,goodsStart,goodsSend,consigner,consignee,phone,courier.courierID,courierPhone,date,goodsState " +
                "from goods,state,courier where goods.goodsID=state.goodsID and goods.courierID=courier.courierID " +
                "and date=?) g limit ?,?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Goods> listByKeywords = new ArrayList<Goods>();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ps.setDate(1, (java.sql.Date) date);
            ps.setInt(2, start);
            ps.setInt(3, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                Goods goods = new Goods(rs.getInt("goodsID"), rs.getString("goodsName"), rs.getString("goodsStart"),
                        rs.getString("goodsSend"), rs.getString("consigner"), rs.getString("consignee"),
                        rs.getString("phone"), rs.getInt("courierID"), rs.getString("courierPhone"),
                        rs.getDate("date"), rs.getString("goodsState"));
                listByKeywords.add(goods);
                System.out.println(goods.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return listByKeywords;
    }
}
