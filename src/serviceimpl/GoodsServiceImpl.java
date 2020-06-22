package serviceimpl;

import dao.GoodsDao;
import daoimpl.GoodsDaoImpl;
import entity.Goods;
import service.GoodsService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao=new GoodsDaoImpl();
    @Override
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    public int deleteGoods(int goodsID) {
        return goodsDao.deleteGoods(goodsID);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    @Override
    public Goods queryOneGoods(int goodsID) throws SQLException {
        return goodsDao.selectGoods(goodsID);
    }

    @Override
    public List<Goods> queryAllGoods(int start, int count) throws SQLException {
        return goodsDao.list(start, count);
    }

    @Override
    public List<Goods> queryGoodsByKeywords(int start, int count,String keywords) throws SQLException {
        return goodsDao.listByKeywords(start, count, keywords);
    }

    @Override
    public List<Goods> queryGoodsByDate(int start, int count, Date date) throws SQLException {
        return goodsDao.listByDate(start, count, date);
    }
}
