package org.coffeestore;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Config {
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties props = new Properties();
                props.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                props.put(Environment.DRIVER, "org.postgresql.Driver");
                props.put(Environment.URL, "jdbc:postgresql://localhost:5432/telegramStats");
                props.put(Environment.USER, "postgres");
                props.put(Environment.PASS, "admin");
                props.put(Environment.HBM2DDL_AUTO, "create-drop");

                sessionFactory = new Configuration()
                        .setProperties(props)
                        .addAnnotatedClass(org.coffeestore.entity.BaseEntity.class)
                        .addAnnotatedClass(org.coffeestore.entity.Chats.class)
                        .addAnnotatedClass(org.coffeestore.entity.List.class)
                        .addAnnotatedClass(org.coffeestore.entity.Message.class)
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace(); // Логирование исключения
                throw new RuntimeException("Failed to create session factory", e);
            }
        }
        return sessionFactory;
    }
}
