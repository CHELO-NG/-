package serviceimpl;

import dao.SalaryDao;
import daoimpl.SalaryDaoImpl;
import entity.Salary;
import service.SalaryService;

import java.sql.SQLException;
import java.util.List;

public class SalaryServiceImpl implements SalaryService {
    private SalaryDao salaryDao=new SalaryDaoImpl();

    @Override
    public int updateSalary(Salary salary) {
        return salaryDao.updateSalary(salary);
    }

    @Override
    public Salary queryOneSalary(int courierID) throws SQLException {
        return salaryDao.selectSalary(courierID);
    }

    @Override
    public List<Salary> queryAllSalary(int start, int count) throws SQLException {
        return salaryDao.list(start, count);
    }

    @Override
    public List<Salary> querySalaryByKeywords(int start, int count, String keywords) throws SQLException {
        return salaryDao.listByKeywords(start, count, keywords);
    }
}
