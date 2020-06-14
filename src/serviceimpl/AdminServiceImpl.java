package serviceimpl;

import dao.AdminDao;
import daoimpl.AdminDaoImpl;
import entity.Admin;
import service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao=new AdminDaoImpl();
    @Override
    public int register(Admin admin) throws SQLException {
        if (adminDao.findAdmin(admin.getAdminID())){
            return -1;
        }
        return adminDao.addAdmin(admin);
    }

    @Override
    public Admin login(String adminID, String adminPassword) throws SQLException {
        return adminDao.findAdmin(adminID,adminPassword);
    }
}
