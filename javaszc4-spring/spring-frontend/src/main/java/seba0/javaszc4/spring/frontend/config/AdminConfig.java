package seba0.javaszc4.spring.frontend.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AdminConfig {

    @Value("${admin.username}")
    private String username;

    @Value("${admin.password}")
    private String password;
}
