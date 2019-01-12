package seba0.javaszc4.spring.backend.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import seba0.javaszc4.spring.backend.model.entity.Brand;
import seba0.javaszc4.spring.backend.model.entity.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> getAllByBrand(Brand brand);

    Optional<Customer> findFirstByLogin(String login);
}
