package seba0.javaszc4.spring.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seba0.javaszc4.spring.model.entity.Customer;
import seba0.javaszc4.spring.services.CustomerService;

import java.util.List;


@RestController
@RequestMapping("customer")
class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    void add(@RequestBody Customer customer) {
        service.save(customer);
    }

    @GetMapping
    List<Customer> getAll() {
        return service.getAll();
    }
}
