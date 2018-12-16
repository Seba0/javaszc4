package seba0.javaszc4.spring.model.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import seba0.javaszc4.spring.model.entity.Brand;
import seba0.javaszc4.spring.model.entity.PromoCampaign;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PromoCampaignRepository extends MongoRepository<PromoCampaign, ObjectId> {

    List<PromoCampaign> getAllByBrand(Brand brand);

    List<PromoCampaign> getAllByBrandAndBeginIsAfter(Brand brand, LocalDate after);

    List<PromoCampaign> getAllByBrandAndEndIsBefore(Brand brand, LocalDate before);

    List<PromoCampaign> getAllByBrandAndBeginIsBeforeAndEndIsAfter(Brand brand, LocalDate dateFrom, LocalDate dateTo);

}
