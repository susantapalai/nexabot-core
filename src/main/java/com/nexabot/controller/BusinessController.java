package com.nexabot.controller;

import com.nexabot.model.Business;
import com.nexabot.service.BusinessService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/business")
@CrossOrigin(origins = "*")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    // Get all businesses
    @GetMapping
    public List<Business> getAll() {
        return businessService.getAll();
    }

    // Get one business
    @GetMapping("/{id}")
    public Business getById(@PathVariable Long id) {
        return businessService.getById(id);
    }

    // Create new business
    @PostMapping
    public Business create(@RequestBody Business business) {
        return businessService.save(business);
    }

    // Update business
    @PutMapping("/{id}")
    public Business update(@PathVariable Long id,
                           @RequestBody Business business) {
        business.setId(id);
        return businessService.save(business);
    }
}