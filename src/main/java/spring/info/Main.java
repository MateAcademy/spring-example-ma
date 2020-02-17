package spring.info;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.info.config.AppConfig;
import spring.info.model.User;
import spring.info.service.UserService;

/**
 * @author Sergey Klunniy
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User( "mike@gmail.com", "123" ));

    }
}
