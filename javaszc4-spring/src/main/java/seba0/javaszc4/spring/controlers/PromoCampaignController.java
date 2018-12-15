package seba0.javaszc4.spring.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seba0.javaszc4.spring.model.entity.PromoCampaign;
import seba0.javaszc4.spring.services.PromoCampaignService;

import java.util.List;


@RestController
@RequestMapping("campaign")
class PromoCampaignController {

    @Autowired
    private PromoCampaignService service;

    @PostMapping
    void add(@RequestBody PromoCampaign campaign) {
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
