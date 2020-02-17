package spring.info.dao;

import spring.info.model.User;

import java.util.List;

/**
 * @author Sergey Klunniy
 */
public interface UserDao {
    void add (User user);

    List<User> getAll();

    public User getUserById(Long userId);
}
