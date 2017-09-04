package ru.kabatov.storage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.kabatov.domain.Users;
import java.util.List;

public class UsersStorage extends Storage<Users>{
    public UsersStorage() {
    super();
    }
    @Override
    public List<Users> values() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Users").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Users get(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Users) session.get(Users.class, id);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Users findByName(String name) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from Users as user where user.username=:name");
            query.setString("name", name);
            return (Users) query.iterate().next();
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
