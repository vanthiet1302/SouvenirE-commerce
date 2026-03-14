package nlu.fit.web.souvenirecommerce.util;

import org.jdbi.v3.core.Jdbi;

import java.io.IOException;
import java.util.Properties;

public class JdbiFactory {

    private static Jdbi jdbi;

    public static Jdbi getJdbi() throws IOException {

        if (jdbi == null) {
            Properties prop = ApplicationLoader.load();

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");

            jdbi = Jdbi.create(url, user, password);
        }

        return jdbi;
    }
}