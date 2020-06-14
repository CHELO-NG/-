package service;

import entity.Salary;

import java.sql.SQLException;
import java.util.List;

public interface SalaryService {
    int updateSalary(Salary salary);
    Salary queryOneSalary(String courierCode) throws SQLException;
    List<Salary> queryAllSalary(int start, int count) throws SQLException;
}
