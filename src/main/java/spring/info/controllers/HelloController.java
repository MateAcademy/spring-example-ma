package spring.info.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.UserResponseDto;

/**
 * @author Sergey Klunniy
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello123";
    }

}
