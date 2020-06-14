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
    public Salary queryOneSalary(String courierCode) throws SQLException {
        return salaryDao.selectSalary(courierCode);
    }

    @Override
    public List<Salary> queryAllSalary(int start, int count) throws SQLException {
        return salaryDao.list(start, count);
    }
}
