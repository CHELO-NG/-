package dao;

import entity.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
    int addGoods(Goods goods);
    int deleteGoods(String goodsID);
    int updateGoods(Goods goods);
    int getTotal() throws SQLException;
    Goods selectGoods(String goodsID) throws SQLException;
    List<Goods> list(int start, int count) throws SQLException;
}
