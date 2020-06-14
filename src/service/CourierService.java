package service;

import entity.Courier;

import java.sql.SQLException;
import java.util.List;

public interface CourierService {
    int addCourier(Courier courier);
    int deleteCourier(String goodsID);
    int updateCourier(Courier courier);
    Courier queryOneCourier(String goodsID) throws SQLException;
    List<Courier> queryAllCourier(int start, int count) throws SQLException;
}
