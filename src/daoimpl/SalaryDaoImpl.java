package daoimpl;

import dao.SalaryDao;
import entity.Salary;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SalaryDaoImpl implements SalaryDao {
    @Override
    public int updateSalary(Salary salary) {
        String sql = "update salary set courierSalary=? where courierID=?";
        Object[] objs = {salary.getCourierSalary(), salary.getCourierID()};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public int getTotal() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        int total = 0;
        String sql = "SELECT COUNT(*) from goods,salary,courier,state where goods.courierID=courier.courierID and courier.courierID=salary.courierID and state.goodsState='已签收' and goods.goodsID=state.goodsID group by goods.courierID";
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
    public Salary selectSalary(int courierID) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select goods.courierID,courier.courierName,count(goods.courierID),courierSalary from goods,salary,courier,state where courier.courierID=? and goods.courierID=courier.courierID and courier.courierID=salary.courierID and state.goodsState='已签收' and state.goodsID=goods.goodsID";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        try {
            ps.setInt(1, courierID);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet rs = null;
        Salary salary = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                salary = new Salary(rs.getInt("goods.courierID"), rs.getString("courierName"), rs.getInt("count(goods.courierID)"),
                        rs.getInt("courierSalary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return salary;
    }

    @Override
    public List<Salary> list(int start, int count) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from (select goods.courierID,courier.courierName,count(goods.courierID),courierSalary from goods,salary,courier,state where goods.courierID=courier.courierID and courier.courierID=salary.courierID and state.goodsState='已签收' and goods.goodsID=state.goodsID group by goods.courierID) g limit ?,?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Salary> list = new ArrayList<Salary>();

        try {
            ps.setInt(1, start);
            ps.setInt(2, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                Salary salary = new Salary(rs.getInt("courierID"), rs.getString("courierName"), rs.getInt("count(goods.courierID)"),
                        rs.getInt("courierSalary"));
                list.add(salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return list;
    }

    @Override
    public List<Salary> listByKeywords(int start, int count, String keywords) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from (select goods.courierID,courier.courierName,count(goods.courierID),courierSalary " +
                "from goods,salary,courier,state where goods.courierID=courier.courierID and courier.courierID=salary.courierID and state.goodsState='已签收' and goods.goodsID=state.goodsID and(goods.courierID=? or courier.courierName=?) group by goods.courierID) g limit ?,?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Salary> listByKeywords = new ArrayList<Salary>();

        try {
            Pattern pattern1 = Pattern.compile("[0-9]*");

            if (keywords != null && keywords != "" && pattern1.matcher(keywords).matches()) {
                ps.setInt(1, Integer.parseInt(keywords));
                ps.setString(2,null);
                System.out.println("keywords1=" + Integer.parseInt(keywords));
            } else {
                ps.setString(1, null);
                ps.setString(2, keywords);
                System.out.println("keywords2=" + keywords);
            }
            ps.setInt(3, start);
            ps.setInt(4, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                Salary salary = new Salary(rs.getInt("courierID"), rs.getString("courierName"), rs.getInt("count(goods.courierID)"),
                        rs.getInt("courierSalary"));
                listByKeywords.add(salary);
                System.out.println(salary.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return listByKeywords;
    }
}
