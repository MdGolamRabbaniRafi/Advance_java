import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBUtil {


    public static User searchUser(String email, String password) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        String sql = "SELECT * FROM users WHERE Email = ? AND Password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int userId = resultSet.getInt("Id");
            String fullName = resultSet.getString("FullName");
            User user = new User(userId, fullName, email, password);
            return user;
        } else {
            return null;
        }
    }
    public static void create(String Fullname, String Email, String Password) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        String sql = "INSERT INTO users SET FullName = ? , Email = ? , Password= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Fullname);
        preparedStatement.setString(2, Email);
        preparedStatement.setString(3, Password);
        preparedStatement.execute();
    }

}