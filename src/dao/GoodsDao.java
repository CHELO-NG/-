package dao;

import entity.Goods;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface GoodsDao {
    int addGoods(Goods goods);
    int deleteGoods(int goodsID);
    int updateGoods(Goods goods);
    int getTotal() throws SQLException;
    Goods selectGoods(int goodsID) throws SQLException;
    List<Goods> list(int start, int count) throws SQLException;
    List<Goods> listByKeywords(int start,int count ,String keywords) throws SQLException;
    List<Goods> listByDate(int start, int count , Date date) throws SQLException;
}
