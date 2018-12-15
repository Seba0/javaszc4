package seba0.javaszc4.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seba0.javaszc4.spring.model.entity.PromoCampaign;
import seba0.javaszc4.spring.model.repository.BrandRepository;
import seba0.javaszc4.spring.model.repository.PromoCampaignRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromoCampaignService {

    @Autowired
    private PromoCampaignRepository campaignRepository;

    @Autowired
    private BrandRepository brandRepository;

    public void save(PromoCampaign campaign) {
        if (!campaign.getBegin()
                .isBefore(campaign.getEnd())) {
            throw new IllegalArgumentException("End before begin");
        } else if (campaign.getCreator()
                .getBrand().equals(campaign.getBrand())) {
            throw new IllegalArgumentException("Creator from other brand");
        }
        campaignRepository.save(campaign);
    }

    public List<PromoCampaign> getAll() {
        return campaignRepository.findAll();
    }

    public List<PromoCampaign> getAllForBrand(String brand) {
        return brandRepository.getByName(brand)
                .map(campaignRepository::getAllByBrand)
                .orElse(Collections.EMPTY_LIST);
    }

    public List<PromoCampaign> getFutureByBrand(String brand) {
        final LocalDate date = LocalDate.now();
        return getAllForBrand(brand).stream()
                .filter(campaign -> date.isBefore(campaign.getBegin()))
                .collect(Collectors.toList());
    }

    public List<PromoCampaign> getCurrentByBrand(String brand) {
        final LocalDate date = LocalDate.now();
        return getAllForBrand(brand).stream()
                .filter(campaign -> date.isAfter(campaign.getBegin()))
                .filter(campaign -> date.isBefore(campaign.getEnd()))
                .collect(Collectors.toList());
    }

    public List<PromoCampaign> getEndedByBrand(String brand) {
        final LocalDate date = LocalDate.now();
        return getAllForBrand(brand).stream()
                .filter(campaign -> date.isAfter(campaign.getEnd()))
                .collect(Collectors.toList());
    }
}
