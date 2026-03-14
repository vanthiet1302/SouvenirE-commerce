package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.util.DBContext;
import nlu.fit.web.souvenirecommerce.util.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {
    public boolean register(String email, String password, String fullName, String phone) {
        String sql = "INSERT INTO users (full_name, email, password, phone, status, role, avatar) " +
                "VALUES (?, ?, ?, ?, 'Active', 'User', 'default-avatar.png')";

        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, PasswordUtils.hashPassword(password));
            ps.setString(4, phone);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
