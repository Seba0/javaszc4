package seba0.javaszc4.spring.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seba0.javaszc4.spring.backend.model.entity.Brand;
import seba0.javaszc4.spring.backend.model.repository.CustomerRepository;
import seba0.javaszc4.spring.backend.model.entity.Customer;

import java.util.List;

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
