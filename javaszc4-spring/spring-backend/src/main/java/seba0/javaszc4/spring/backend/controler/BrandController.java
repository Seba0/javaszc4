package seba0.javaszc4.spring.backend.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seba0.javaszc4.spring.backend.model.entity.Brand;
import seba0.javaszc4.spring.backend.services.BrandService;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("brand")
class BrandController {

    @Autowired
    private BrandService service;

    @PostMapping
    void add(@RequestBody Brand brand) {
        service.save(brand);
    }

    @GetMapping
    List<Brand> getAll() {
        return service.getAll();
    }

    @GetMapping("names")
    Set<String> getAllNames() {
        return service.getAllNames();
    }
}
