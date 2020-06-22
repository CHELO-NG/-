package service;

import entity.Courier;

import java.sql.SQLException;
import java.util.List;

public interface CourierService {
    int addCourier(Courier courier);
    int deleteCourier(int courierID);
    int updateCourier(Courier courier);
    Courier queryOneCourier(int courierID) throws SQLException;
    List<Courier> queryAllCourier(int start, int count) throws SQLException;
    List<Courier> queryCourierByKeywords(int start,int count,String keywords) throws SQLException;
}
