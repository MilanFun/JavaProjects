package util;

import entity.Goods;
import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtil {
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if(sessionFactory == null) {
      try {
        Configuration configuration = new Configuration();

        // Hibernate settings == to hibernate.cfg.xml
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.postgresql.Driver");
        settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/jhibernate");
        settings.put(Environment.USER, "postgres");
        settings.put(Environment.PASS, "Lansik99$");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");

        configuration.setProperties(settings);
        configuration.addAnnotatedClass(User.class);

        //don't forget to add entity!!!
        configuration.addAnnotatedClass(Goods.class);

        StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return sessionFactory;
  }
}
