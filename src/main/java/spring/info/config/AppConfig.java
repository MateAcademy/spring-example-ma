package spring.info.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import spring.info.model.User;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Sergey Klunniy
 */
@Configuration
@ComponentScan(basePackages = {
        "spring.info.dao.impl",
        "spring.info.service.impl"
})
public class AppConfig {

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_example?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("Epic49$$");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactoryBean() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props = new Properties();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create-drop");

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class);
        return factoryBean;
    }
}
