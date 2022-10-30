package com.example.sb4_component_service_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    public Girl getGirl() {
        String name = girlName(10);
        return girlRepository.getGirlByName(name);
    }

    public String girlName(int length) {
        // Random một string có độ dài quy định
        // Sử dụng thư viện Apache Common Lang

        return "Taylor Swift";
    }
}
