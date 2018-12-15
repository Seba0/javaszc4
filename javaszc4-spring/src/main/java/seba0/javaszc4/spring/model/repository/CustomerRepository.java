package seba0.javaszc4.spring.model.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import seba0.javaszc4.spring.model.entity.Brand;
import seba0.javaszc4.spring.model.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {

    List<Customer> getAllByBrand(Brand brand);
}
