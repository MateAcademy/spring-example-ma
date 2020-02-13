package spring.info.dao.impl;

import org.springframework.stereotype.Repository;
import spring.info.dao.UserDao;
import spring.info.model.User;

import java.util.List;

/**
 * @author Sergey Klunniy
 */
@Repository
public class UserDaoExeptionImpl implements UserDao {

    @Override
    public void add(User user) {
        throw new RuntimeException("I am a new implementation");
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
