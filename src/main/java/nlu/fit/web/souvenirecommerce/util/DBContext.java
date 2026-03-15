package nlu.fit.web.souvenirecommerce.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBContext {
    public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        Properties prop = ApplicationLoader.load();
        String dbUrl = prop.getProperty("db.url");
        String dbUser = prop.getProperty("db.user");
        String dbPassword = prop.getProperty("db.pass");

        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
}