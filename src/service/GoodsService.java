package service;

import entity.Goods;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface GoodsService {
    int addGoods(Goods goods);
    int deleteGoods(int goodsID);
    int updateGoods(Goods goods);
    Goods queryOneGoods(int goodsID) throws SQLException;
    List<Goods> queryAllGoods(int start, int count) throws SQLException;
    List<Goods> queryGoodsByKeywords(int start, int count,String keywords) throws SQLException;
    List<Goods> queryGoodsByDate(int start, int count, Date date) throws SQLException;
}
