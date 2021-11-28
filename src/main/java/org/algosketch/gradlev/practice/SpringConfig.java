package org.algosketch.gradlev.practice;

import org.algosketch.gradlev.practice.repository.*;
import org.algosketch.gradlev.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;

    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }

//    @Bean
//    public UserRepository userRepository() {
//        return new JdbcUserRepository(dataSource);
//        return new MemoryUserRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaUserRepository(em);
//    }
}
