package daoimpl;

import dao.AdminDao;
import entity.Admin;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public int addAdmin(Admin admin) {
        String sql = "insert into admin values (?,?,?,?,?,?)";
        Object[] objs = {admin.getAdminID(),admin.getAdminPassword()};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public boolean findAdmin(String adminID) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from admin where adminID=?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        try {
            ps.setString(1, adminID);

            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.close(rs, ps, conn);
        }
        return false;
    }

    @Override
    public Admin findAdmin(String adminID, String adminPassword) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from admin where adminID=? and adminPassword=?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        Admin admin = null;
        try {
            ps.setString(1, adminID);
            ps.setString(2, adminPassword);

            rs = ps.executeQuery();
            if(rs.next()) {
                admin = new Admin(rs.getString("adminID"), rs.getString("adminPassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.close(rs, ps, conn);
        }
        return admin;
    }
}
