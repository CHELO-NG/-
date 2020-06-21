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
        String sql = "insert all" +
                " into courier (courierID,courierName,courierPhone,courierArea) values(?,?,?,?)" +
                " into salary(courierID,courierSalary) values(?,?)";
        Object[] objs = {courier.getCourierID(),courier.getCourierName(),courier.getCourierPhone(),courier.getCourierArea(),courier.getCourierID(),courier.getCourierSalary()};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public int deleteCourier(String courierID) {
        String sql1 = "delete from salary where courierID=?";
        Object[] objs1 = {courierID};
        int n1 = JDBCUtil.excuteDML(sql1, objs1);
        String sql2 = "delete from courier where courierID=?";
        Object[] objs2 = {courierID};
        int n2 = JDBCUtil.excuteDML(sql2, objs2);
        return (n1+n2);
    }

    @Override
    public int updateCourier(Courier courier) {
        String sql1 = "update courier set courierName=?,courierPhone=?,courierArea=? where courierID=?";
        Object[] objs1 = {courier.getCourierName(),courier.getCourierPhone(),courier.getCourierArea(),courier.getCourierID()};
        int n1 = JDBCUtil.excuteDML(sql1, objs1);
        String sql2 = "update salary set courierSalary=? where courierID=?";
        Object[] objs2 = {courier.getCourierSalary(),courier.getCourierID()};
        int n2 = JDBCUtil.excuteDML(sql2, objs2);
        System.out.println("更新了"+(n1+n2));
        return n1+n2;
    }

    @Override
    public int getTotal() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        int total = 0;
        String sql = "SELECT COUNT(*) FROM courier,salary where courier.courierID=salary.courierID";
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
    public Courier selectCourier(String courierID) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select courier.courierID,courierName,courierPhone,courierArea,courierSalary from courier,salary where courier.courierID=? and courier.courierID=salary.courierID";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        try {
            ps.setString(1, courierID);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet rs = null;
        Courier courier=null;
        try {
            rs = ps.executeQuery();
            if(rs.next()) {
                courier = new Courier(rs.getString("courier.courierID"),
                        rs.getString("courierName"), rs.getString("courierPhone"),
                        rs.getString("courierArea"),rs.getString("courierSalary"));
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
        String sql="select * from (select courier.courierID,courierName,courierPhone,courierArea,courierSalary from courier,salary where courier.courierID=salary.courierID) c order by courierID limit ?,? ";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Courier> list = new ArrayList<Courier>();
        try {
            ps.setInt(1,start);
            ps.setInt(2,count);
            rs = ps.executeQuery();
            while(rs.next()) {
                Courier courier = new Courier(rs.getString("courierID"),
                        rs.getString("courierName"), rs.getString("courierPhone"),
                        rs.getString("courierArea"),rs.getString("courierSalary"));
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
