package serviceimpl;

import dao.GoodsDao;
import daoimpl.GoodsDaoImpl;
import entity.Goods;
import service.GoodsService;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao=new GoodsDaoImpl();
    @Override
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    public int deleteGoods(String goodsID) {
        return goodsDao.deleteGoods(goodsID);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    @Override
    public Goods queryOneGoods(String goodsID) throws SQLException {
        return goodsDao.selectGoods(goodsID);
    }

    @Override
    public List<Goods> queryAllGoods(int start, int count) throws SQLException {
        return goodsDao.list(start, count);
    }
}
