package seba0.javaszc4.spring.backend.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seba0.javaszc4.spring.backend.model.entity.Customer;
import seba0.javaszc4.spring.backend.services.CustomerService;

import java.util.List;


@RestController
@RequestMapping("customer")
class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    ResponseEntity<String> add(@RequestBody Customer customer) {
        if(service.add(customer)) {
            ResponseEntity
                    .ok()
                    .body("Customer added success full.");
        }
        return ResponseEntity
                .badRequest()
                .body("Unable to add customer.");
    }

    @GetMapping
    List<Customer> getAll() {
        return service.getAll();
    }
}
