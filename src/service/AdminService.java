package service;

import entity.Admin;

import java.sql.SQLException;

public interface AdminService {
    int register(Admin user) throws SQLException;
    Admin login(String adminID, String adminPassword) throws SQLException;
}
