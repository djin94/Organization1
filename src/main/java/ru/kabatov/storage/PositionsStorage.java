package ru.kabatov.storage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.kabatov.domain.Positions;
import ru.kabatov.domain.Users;

import java.util.Collection;

public class PositionsStorage extends Storage<Positions>{
    private final SessionFactory factory;
    public PositionsStorage() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(serviceRegistry);
    }
    @Override
    public Collection<Positions> values() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Positions ").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Positions get(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Positions) session.get(Positions.class, id);
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
