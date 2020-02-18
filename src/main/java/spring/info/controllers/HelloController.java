package spring.info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.info.service.UserService;

/**
 * @author Sergey Klunniy
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

}
