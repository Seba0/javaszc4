package seba0.javaszc4.spring.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calc")
class Calculator {

    @GetMapping("add/{a}/{b}")
    BigDecimal add(@PathVariable BigDecimal a, @PathVariable BigDecimal b) {
        return a.add(b);
    }
}
