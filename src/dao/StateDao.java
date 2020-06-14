package dao;

import entity.State;

import java.sql.SQLException;
import java.util.List;

public interface StateDao {
    int updateState(State state);
    int getTotal() throws SQLException;
    State selectState(String goodsID) throws SQLException;
    List<State> list(int start, int count) throws SQLException;
}
