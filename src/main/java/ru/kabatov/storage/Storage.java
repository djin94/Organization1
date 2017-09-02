package ru.kabatov.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.kabatov.domain.Organization;
import ru.kabatov.domain.Users;

import java.util.Collection;

public abstract class Storage<T extends Organization> {
    protected final SessionFactory factory;
    public Storage() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(serviceRegistry);
    }

    public abstract Collection<T> values();

    public int add(final T var){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(var);
            return var.getId();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void edit(final T var){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(var);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void delete(final int id){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(get(id));
        } finally {
            tx.commit();
            session.close();
        }
    }

    public abstract T get(final int id);

    public abstract int generateId();

    public abstract void close();
}
