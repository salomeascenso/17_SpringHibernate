package com.redoutevant.sprinhibernate.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author dev
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry  serviceRegistry;

    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        return sessionFactory;
    }

    
    public static void close(){
        sessionFactory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
}
