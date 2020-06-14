package service;

import entity.State;

import java.sql.SQLException;
import java.util.List;

public interface StateService {
    int updateState(State state);
    State queryOneState(String goodsID) throws SQLException;
    List<State> queryAllState(int start, int count) throws SQLException;
}
