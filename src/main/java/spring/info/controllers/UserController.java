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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> list = new ArrayList<>();
        userService.listUsers().forEach(u -> list.add(getDtoFromUser(u)));
        return list;
    }


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public UserResponseDto getUser(@PathVariable Long id) {
        return getDtoFromUser(userService.getUserById(id));
    }

    private UserResponseDto getDtoFromUser(User user) {
        return new UserResponseDto(user.getName(), user.getPassword());
    }

    @GetMapping("/inject")
    private String injectUsers() {

        User user1 = new User();
        user1.setName("ava@hr.ua");
        user1.setEmail("ava@hr.ua");
        user1.setPassword("111");

        User user2 = new User();
        user2.setName("tukulova");
        user2.setEmail("ava2@hr.ua");
        user2.setPassword("222");


        User user3 = new User();
        user3.setName("roma");
        user3.setEmail("ava3@hr.ua");
        user3.setPassword("333");

        User user4 = new User();
        user4.setName("valera");
        user4.setEmail("ava4@hr.ua");
        user4.setPassword("444");

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        return "Success";
    }

}
