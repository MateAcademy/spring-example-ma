package spring.info.service;

import spring.info.model.User;
import spring.UserResponseDto;

import java.util.List;

/**
 * @author Sergey Klunniy
 */
public interface UserService {
    void add (User user);

    List<User> listUsers();

    User getUserById(Long userId);

}
