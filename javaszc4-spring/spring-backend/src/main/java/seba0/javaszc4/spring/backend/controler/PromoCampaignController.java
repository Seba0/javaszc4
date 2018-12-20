package seba0.javaszc4.spring.backend.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seba0.javaszc4.spring.backend.services.PromoCampaignService;
import seba0.javaszc4.spring.backend.model.entity.PromoCampaign;

import java.util.List;


@RestController
@RequestMapping("campaign")
class PromoCampaignController {

    @Autowired
    private PromoCampaignService service;

    @PostMapping
    void add(@RequestBody PromoCampaign campaign) {
        if (!campaign.getBegin()
                .isBefore(campaign.getEnd())) {
            throw new IllegalArgumentException("End before begin");
        } else if (!campaign.getCreator()
                .getBrand().equals(campaign.getBrand())) {
            throw new IllegalArgumentException("Creator from other brand");
        }
        service.save(campaign);
    }

    @GetMapping
    List<PromoCampaign> getAll() {
        return service.getAll();
    }

    @GetMapping("{brand}")
    List<PromoCampaign> getAllForBrand(@PathVariable String brand) {
        return service.getAllForBrand(brand);
    }


    @GetMapping("{brand}/future")
    List<PromoCampaign> getFuture(@PathVariable String brand) {
        return service.getFutureByBrand(brand);
    }

    @GetMapping("{brand}/current")
    List<PromoCampaign> getCurrent(@PathVariable String brand) {
        return service.getCurrentByBrand(brand);
    }

    @GetMapping("{brand}/ended")
    List<PromoCampaign> getEnded(@PathVariable String brand) {
        return service.getEndedByBrand(brand);
    }
}
