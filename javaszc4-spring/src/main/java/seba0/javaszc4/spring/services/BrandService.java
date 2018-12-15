package seba0.javaszc4.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seba0.javaszc4.spring.model.entity.Brand;
import seba0.javaszc4.spring.model.repository.BrandRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    public Set<String> getAllNames() {
        return brandRepository.findAll().stream()
                .map(Brand::getName)
                .collect(Collectors.toSet());
    }
}
