package spring.info.utill;

import org.hibernate.SessionFactory;

/**
 * @author Sergey Klunniy
 */
public interface HibernateUtill {
    SessionFactory initSessionFactory();
}
