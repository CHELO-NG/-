package service;

import entity.Goods;
import entity.Salary;

import java.sql.SQLException;
import java.util.List;

public interface SalaryService {
    int updateSalary(Salary salary);
    Salary queryOneSalary(int courierID) throws SQLException;
    List<Salary> queryAllSalary(int start, int count) throws SQLException;
    List<Salary> querySalaryByKeywords(int start, int count, String keywords) throws SQLException;
}
