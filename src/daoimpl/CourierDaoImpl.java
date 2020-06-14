package daoimpl;

import dao.CourierDao;
import entity.Courier;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourierDaoImpl  implements CourierDao {

    @Override
    public int addCourier(Courier courier) {
        String sql = "insert into courier values(?,?,?)";
        Object[] objs = {courier.getCourierCode(),courier.getCourierName(),courier.getCourierPhone()};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public int deleteCourier(String courierCode) {
        String sql = "delete from courier where courierCode=?";
        Object[] objs = {courierCode};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public int updateCourier(Courier courier) {
        String sql = "update courier set courierName=?,courierPhone=? where courierCode=?";
        Object[] objs = {courier.getCourierName(),courier.getCourierPhone(),courier.getCourierCode()};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public int getTotal() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        int total = 0;
        String sql = "SELECT COUNT(*) FROM courier";
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
    public Courier selectCourier(String courierCode) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from courier where courierCode=?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        try {
            ps.setString(1, courierCode);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet rs = null;
        Courier courier=null;
        try {
            rs = ps.executeQuery();
            if(rs.next()) {
                courier = new Courier(rs.getString("courierCode"), rs.getString("courierName"), rs.getString("courierPhone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return courier;
    }

    @Override
    public List<Courier> list(int start, int count) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql="select * from courier limit ?,?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Courier> list = new ArrayList<Courier>();
        try {
            ps.setInt(1,start);
            ps.setInt(2,count);
            rs = ps.executeQuery();
            while(rs.next()) {
                Courier courier = new Courier(rs.getString("courierCode"), rs.getString("courierName"), rs.getString("courierPhone"));
                list.add(courier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return list;
    }
}
