package service;

import entity.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsService {
    int addGoods(Goods goods);
    int deleteGoods(String goodsID);
    int updateGoods(Goods goods);
    Goods queryOneGoods(String goodsID) throws SQLException;
    List<Goods> queryAllGoods(int start, int count) throws SQLException;
}
