package seba0.javaszc4.spring.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seba0.javaszc4.spring.backend.model.entity.Brand;
import seba0.javaszc4.spring.backend.model.entity.Customer;
import seba0.javaszc4.spring.backend.model.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean add(Customer customer) {
        if (customerRepository
                .findFirstByLogin(customer.getLogin())
                .isPresent()) {
            return false;
        }
        customerRepository.save(customer);
        return customer.getId() != null;
    }

    public Optional<Customer> delete(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(customerRepository::delete);
        return customer;
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAllForBrand(Brand brand) {
        return customerRepository.getAllByBrand(brand);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
