package ru.kabatov.storage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.kabatov.domain.Groups;
import ru.kabatov.domain.Users;

import java.util.Collection;

public class GroupsStorage extends Storage<Groups>{
    private final SessionFactory factory;
    public GroupsStorage() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(serviceRegistry);
    }
    @Override
    public Collection<Groups> values() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Groups ").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Groups get(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Groups) session.get(Groups.class, id);
        } finally {
            tx.commit();
            session.close();
        }
    }


    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        this.factory.close();
    }
}

