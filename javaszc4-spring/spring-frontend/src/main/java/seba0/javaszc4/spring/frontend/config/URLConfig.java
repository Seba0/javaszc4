package seba0.javaszc4.spring.frontend.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class URLConfig {

    @Value("${url.customer}")
    private String customer;

}
