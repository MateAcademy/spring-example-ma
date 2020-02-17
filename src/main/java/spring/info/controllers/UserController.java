package spring.info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.UserResponseDto;
import spring.info.model.User;
import spring.info.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Klunniy
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/inject")
    private String injectUsers() {
        User user1 = new User();
        user1.setEmail("ava@hr.ua");
        user1.setPassword("vasia");

        User user2 = new User();
        user2.setPassword("tukulova");
        user2.setEmail("ava2@hr.ua");

        User user3 = new User();
        user3.setPassword("roma");
        user3.setEmail("ava3@hr.ua");

        User user4 = new User();
        user4.setPassword("valera");
        user4.setEmail("ava4@hr.ua");

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        return "Success";
    }

    @GetMapping(value = "/")
    private List<UserResponseDto> getUsers() {
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (User user : userService.listUsers()) {
            userResponseDtoList.add(new UserResponseDto(user.getEmail(), user.getPassword()));
        }
        return userResponseDtoList;
    }
}
