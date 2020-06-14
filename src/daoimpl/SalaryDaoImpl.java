package daoimpl;

import dao.SalaryDao;
import entity.Goods;
import entity.Salary;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDaoImpl implements SalaryDao {
    @Override
    public int updateSalary(Salary salary) {
        String sql = "update salary set courierSalary=? where courierID=?";
        Object[] objs = {salary.getCourierSalary(),salary.getCourierID()};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public int getTotal() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        int total = 0;
        String sql = "SELECT COUNT(*) FROM salary";
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
    public Salary selectSalary(String courierID) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from salary where courierID=?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        try {
            ps.setString(1, courierID);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet rs = null;
        Salary salary=null;
        try {
            rs = ps.executeQuery();
            if(rs.next()) {
                salary = new Salary(rs.getString("courierID"), rs.getString("courierSalary"));
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
        String sql="select * from salary limit ?,?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Salary> list = new ArrayList<Salary>();
        try {
            ps.setInt(1,start);
            ps.setInt(2,count);
            rs = ps.executeQuery();
            while(rs.next()) {
                Salary salary = new Salary(rs.getString("courierID"), rs.getString("courierSalary"));
                list.add(salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return list;
    }
}
