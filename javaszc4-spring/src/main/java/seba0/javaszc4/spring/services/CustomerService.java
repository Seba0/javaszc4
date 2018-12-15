package seba0.javaszc4.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seba0.javaszc4.spring.model.entity.Brand;
import seba0.javaszc4.spring.model.entity.Customer;
import seba0.javaszc4.spring.model.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

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
