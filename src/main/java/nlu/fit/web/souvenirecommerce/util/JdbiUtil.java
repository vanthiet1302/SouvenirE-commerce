package nlu.fit.web.souvenirecommerce.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.io.IOException;
import java.util.Properties;

public class JdbiUtil {
    private static Jdbi jdbi;

    static {
        try {
            Properties props = ApplicationLoader.load();

            HikariConfig config = new HikariConfig();
            config.setDriverClassName(props.getProperty("db.driver"));
            config.setJdbcUrl(props.getProperty("db.url"));
            config.setUsername(props.getProperty("db.user"));
            config.setPassword(props.getProperty("db.password"));

            config.setMaximumPoolSize(Integer.parseInt(props.getProperty("hikari.maximumPoolSize", "10")));
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            HikariDataSource ds = new HikariDataSource(config);

            jdbi = Jdbi.create(ds);
            jdbi.installPlugin(new SqlObjectPlugin());

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi khởi tạo JDBI: " + e.getMessage());
        }
    }

    public static Jdbi getJdbi() {
        return jdbi;
    }

    public static <T> T getDao(Class<T> daoClass) {
        return jdbi.onDemand(daoClass);
    }
}