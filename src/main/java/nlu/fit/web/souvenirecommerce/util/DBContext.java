package nlu.fit.web.souvenirecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBContext {

    public static Connection getConnection() throws SQLException {
        Properties props = ApplicationLoader.getProperties();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Không tìm thấy MySQL Driver", e);
        }
        return DriverManager.getConnection(
                props.getProperty("db_url"),
                props.getProperty("db_username"),
                props.getProperty("db_password")
        );
    }

    public static void main(String[] args) {
        try {
            System.out.println(getConnection());
            System.out.println("Kết nối CSDL thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}