package dao;

import entity.Salary;

import java.sql.SQLException;
import java.util.List;

public interface SalaryDao {
    int updateSalary(Salary salary);
    int getTotal() throws SQLException;
    Salary selectSalary(String courierCode) throws SQLException;
    List<Salary> list(int start, int count) throws SQLException;
}
