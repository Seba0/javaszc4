package seba0.javaszc4.spring.backend.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seba0.javaszc4.spring.backend.model.entity.Customer;
import seba0.javaszc4.spring.backend.services.CustomerService;

import javax.validation.Valid;
import java.util.List;


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

    @GetMapping
    ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{login}")
    ResponseEntity<Customer> getByLogin(@PathVariable String login) {
        return service.getByLogin(login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }

    @DeleteMapping("{id}")
    ResponseEntity<Customer> delete(@PathVariable String id) {
        return service.delete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }
}
