package daoimpl;

import dao.StateDao;
import entity.State;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDaoImpl implements StateDao {

    @Override
    public int updateState(State state) {
        String sql = "update state set goodsState=? where goodsID=?";
        Object[] objs = {state.getGoodsState(),state.getGoodsID()};
        int n = JDBCUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public int getTotal() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        int total = 0;
        String sql = "SELECT COUNT(*) FROM state";
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
    public State selectState(String goodsID) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from state where goodsID=?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        try {
            ps.setString(1, goodsID);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet rs = null;
        State state=null;
        try {
            rs = ps.executeQuery();
            if(rs.next()) {
                state = new State( rs.getString("goodsID"),rs.getString("goodsState"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return state;
    }

    @Override
    public List<State> list(int start, int count) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql="select * from state limit ?,?";
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<State> list = new ArrayList<State>();
        try {
            ps.setInt(1,start);
            ps.setInt(2,count);
            rs = ps.executeQuery();
            while(rs.next()) {
                State state = new State(rs.getString("goodsID"),rs.getString("goodsState"));
                list.add(state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return list;
    }
}
