package spring.info.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.info.dao.UserDao;
import spring.info.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        Transaction transaction = null;
        try (final Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
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

    @Override
    public User getUserById(Long userId) {
        try (Session session = sessionFactory.openSession()) {
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<User> cq = cb.createQuery(User.class);
//            Root<User> root = cq.from(User.class);
//            cq.select(root).where(cb.and(cb.equal(root.get("id"), userId)));
//            return session.createQuery(cq).uniqueResult();
            return session.get(User.class, userId);
        } catch (Exception e) {
            throw new RuntimeException("Cat't get user from db", e);
        }
    }

}
