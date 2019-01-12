package seba0.javaszc4.spring.backend.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seba0.javaszc4.spring.backend.model.entity.Customer;
import seba0.javaszc4.spring.backend.services.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("customer")
class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    ResponseEntity<String> add(@Valid @RequestBody Customer customer) {
        if (service.add(customer)) {
            return ResponseEntity.ok()
                    .body("Customer added success full.");
        }
        return ResponseEntity.badRequest()
                .body("Customer already exist.");
    }

    private Customer clearPassword(Customer customer) {
        customer.setPassword("");
        return customer;
    }

    @GetMapping
    List<Customer> getAll() {
        return service.getAll().stream()
                .map(this::clearPassword)
                .collect(Collectors.toList());
    }

    @DeleteMapping("{id}")
    ResponseEntity delete(@PathVariable String id) {
        return service.delete(id)
                .map(this::clearPassword)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }
}
