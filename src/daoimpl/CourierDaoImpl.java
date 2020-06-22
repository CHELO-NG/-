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
import java.util.regex.Pattern;

public class CourierDaoImpl  implements CourierDao {

    @Override
    public int addCourier(Courier courier) {
        String sql1 = "insert into courier (courierID,courierName,courierPhone,courierArea) values(?,?,?,?)";
        Object[] objs1 = {courier.getCourierID(),courier.getCourierName(),courier.getCourierPhone(),courier.getCourierArea()};
        int n1 = JDBCUtil.excuteDML(sql1, objs1);
        String sql2 = "insert into salary(courierID,courierSalary) values(?,?)";
        Object[] objs2 = {courier.getCourierID(),courier.getCourierSalary()};
        int n2 = JDBCUtil.excuteDML(sql2, objs2);
        return (n1+n2)/2;
    }

    @Override
    public int deleteCourier(int courierID) {
        String sql1 = "delete from salary where courierID=?";
        Object[] objs1 = {courierID};
        int n1 = JDBCUtil.excuteDML(sql1, objs1);
        String sql2 = "delete from courier where courierID=?";
        Object[] objs2 = {courierID};
        int n2 = JDBCUtil.excuteDML(sql2, objs2);
        return (n1+n2)/2;
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
    public Courier selectCourier(int courierID) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select courier.courierID,courierName,courierPhone,courierArea,courierSalary from courier,salary where courier.courierID=? and courier.courierID=salary.courierID";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        try {
            ps.setInt(1, courierID);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet rs = null;
        Courier courier=null;
        try {
            rs = ps.executeQuery();
            if(rs.next()) {
                courier = new Courier(rs.getInt("courier.courierID"),
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
                Courier courier = new Courier(rs.getInt("courierID"),
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

    @Override
    public List<Courier> listByKeywords(int start, int count,String keywords) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql="select * from (select courier.courierID,courierName,courierPhone,courierArea,courierSalary from courier,salary where courier.courierID=salary.courierID and (courier.courierID=? or courierName=? or courierPhone=? or courierArea=? )) c order by courierID limit ?,? ";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Courier> listByKeywords = new ArrayList<Courier>();
        try {
            Pattern pattern = Pattern.compile("[0-9]*");
            if (keywords!=null &&keywords!=""&& pattern.matcher(keywords).matches()){
                ps.setInt(1,Integer.parseInt(keywords));
            } else{
                ps.setString(1,keywords);
            }
            ps.setString(2,keywords);
            ps.setString(3,keywords);
            ps.setString(4,keywords);
            ps.setInt(5,start);
            ps.setInt(6,count);
            rs = ps.executeQuery();
            while(rs.next()) {
                Courier courier = new Courier(rs.getInt("courierID"),
                        rs.getString("courierName"), rs.getString("courierPhone"),
                        rs.getString("courierArea"),rs.getString("courierSalary"));
                listByKeywords.add(courier);
                System.out.println(courier.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return listByKeywords;
    }
}
