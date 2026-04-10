package nlu.fit.web.souvenirecommerce.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }

    public static Collection<?> getManagedEntities(Session session){
        return session.getManagedEntities();
    }
}
