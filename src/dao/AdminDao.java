package dao;

import entity.Admin;

import java.sql.SQLException;

public interface AdminDao {
    int addAdmin(Admin admin);
    boolean findAdmin(String adminID) throws SQLException;
    Admin findAdmin(String adminID, String adminPassword) throws SQLException;
}
