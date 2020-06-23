package dao;

import entity.Salary;

import java.sql.SQLException;
import java.util.List;

public interface SalaryDao {
    int updateSalary(Salary salary);
    int getTotal() throws SQLException;
    Salary selectSalary(int courierID) throws SQLException;
    List<Salary> list(int start, int count) throws SQLException;
    List<Salary> listByKeywords(int start, int count,String keywords) throws SQLException;
}
