package seba0.javaszc4.spring.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seba0.javaszc4.spring.backend.model.repository.BrandRepository;
import seba0.javaszc4.spring.backend.model.repository.PromoCampaignRepository;
import seba0.javaszc4.spring.backend.model.entity.PromoCampaign;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class PromoCampaignService {

    @Autowired
    private PromoCampaignRepository campaignRepository;

    @Autowired
    private BrandRepository brandRepository;

    public void save(PromoCampaign campaign) {
        campaignRepository.save(campaign);
    }

    public List<PromoCampaign> getAll() {
        return campaignRepository.findAll();
    }

    public List<PromoCampaign> getAllForBrand(String brandName) {
        return brandRepository.getByName(brandName)
                .map(campaignRepository::getAllByBrand)
                .orElse(Collections.EMPTY_LIST);
    }

    public List<PromoCampaign> getFutureByBrand(String brandName) {
        final LocalDate date = LocalDate.now();
        return brandRepository.getByName(brandName)
                .map(brand -> campaignRepository.getAllByBrandAndBeginIsAfter(brand, date))
                .orElse(Collections.EMPTY_LIST);
    }

    public List<PromoCampaign> getCurrentByBrand(String brandName) {
        final LocalDate date = LocalDate.now();
        return brandRepository.getByName(brandName)
                .map(brand -> campaignRepository.getAllByBrandAndBeginIsBeforeAndEndIsAfter(brand, date, date))
                .orElse(Collections.EMPTY_LIST);
    }

    public List<PromoCampaign> getEndedByBrand(String brandName) {
        final LocalDate date = LocalDate.now();
        return brandRepository.getByName(brandName)
                .map(brand -> campaignRepository.getAllByBrandAndEndIsBefore(brand, date))
                .orElse(Collections.EMPTY_LIST);
    }
}
