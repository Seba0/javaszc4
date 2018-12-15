package seba0.javaszc4.spring.model.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import seba0.javaszc4.spring.model.entity.Brand;

import java.util.Optional;

@Repository
public interface BrandRepository extends MongoRepository<Brand, ObjectId> {

    Optional<Brand> getByName(String name);
}
