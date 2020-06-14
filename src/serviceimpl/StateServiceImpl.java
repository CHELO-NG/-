package serviceimpl;

import dao.StateDao;
import daoimpl.StateDaoImpl;
import entity.State;
import service.StateService;

import java.sql.SQLException;
import java.util.List;

public class StateServiceImpl implements StateService {
    private StateDao stateDao=new StateDaoImpl();
    @Override
    public int updateState(State state) {
        return stateDao.updateState(state);
    }

    @Override
    public State queryOneState(String goodsID) throws SQLException {
        return stateDao.selectState(goodsID);
    }

    @Override
    public List<State> queryAllState(int start, int count) throws SQLException {
        return stateDao.list(start, count);
    }
}
