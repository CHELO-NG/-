package dao;

import entity.Courier;

import java.sql.SQLException;
import java.util.List;

public interface CourierDao {
    int addCourier(Courier courier);
    int deleteCourier(int courierID);
    int updateCourier(Courier courier);
    int getTotal() throws SQLException;
    Courier selectCourier(int courierID) throws SQLException;
    List<Courier> list(int start,int count) throws SQLException;
    List<Courier> listByKeywords(int start,int count ,String keywords) throws SQLException;
}
