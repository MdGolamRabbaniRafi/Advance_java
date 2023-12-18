package dev.service;

import dev.Repository.database.DBUtil;
import dev.domain.User;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    private DBUtil dbUtil;

    public UserService(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public static void create(User user) throws SQLException, ClassNotFoundException {
        user.setFullname(user.getFullname().toUpperCase());
        DBUtil.create(user);
    }

    public static void update(User user) throws SQLException, ClassNotFoundException {
        DBUtil.update(user);
    }

    public static User get(int Id) throws SQLException, ClassNotFoundException {
        return DBUtil.searchUser(Id);
    }

    public static void delete(User user) throws SQLException, ClassNotFoundException {
        DBUtil.delete(user);
    }

    public static List<User> getAlluser() throws SQLException, ClassNotFoundException {
       return DBUtil.getAllUsers();
    }
}