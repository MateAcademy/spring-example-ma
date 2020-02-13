package spring.info.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.info.dao.UserDao;
import spring.info.model.User;

import java.util.List;

/**
 * @author Sergey Klunniy
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        System.out.println("We in the UserDaoImpl");
        Transaction transaction = null;
        try (final Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Long itemId = (Long) session.save(user);
            transaction.commit();
            user.setId(itemId);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("can't add user entity", e);
        }
    }

    @Override
    public List<User> getAll() {
        Query<User> from_user = sessionFactory.openSession()
                .createQuery("from User", User.class);
        return from_user.getResultList();
    }
}
