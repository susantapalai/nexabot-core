package com.nexabot.service;

import com.nexabot.model.Business;
import com.nexabot.repository.BusinessRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public Business getById(Long id) {
        return businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found"));
    }

    public String buildContext(Business business) {
        return """
                Business Name: %s
                Location: %s
                Timings: %s
                Menu: %s
                FAQs: %s
                Delivery Info: %s
                Contact: %s
                """.formatted(
                business.getName(),
                business.getLocation(),
                business.getTimings(),
                business.getMenu(),
                business.getFaqs(),
                business.getDeliveryInfo(),
                business.getContactNumber()
        );
    }
}