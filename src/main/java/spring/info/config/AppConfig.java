package spring.info.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import spring.info.model.User;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Sergey Klunniy
 */
@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = {
        "spring.info.dao.impl",
        "spring.info.service.impl",
        "spring.info.controllers"
})
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driver"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactoryBean() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties properties = new Properties();
        properties.put("hibernate.show_sql",
                environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto",
                environment.getProperty("hibernate.hbm2ddl.auto"));

        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(User.class);
        return factoryBean;
    }

}
