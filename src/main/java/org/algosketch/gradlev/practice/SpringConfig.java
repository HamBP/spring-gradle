package org.algosketch.gradlev.practice;

import org.algosketch.gradlev.practice.repository.JdbcTemplateMemberRepository;
import org.algosketch.gradlev.practice.repository.JdbcUserRepository;
import org.algosketch.gradlev.practice.repository.MemoryUserRepository;
import org.algosketch.gradlev.practice.repository.UserRepository;
import org.algosketch.gradlev.practice.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
//        return new JdbcUserRepository(dataSource);
//        return new MemoryUserRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
