package com.example.sb4_component_service_repository;

public interface GirlRepository {
    /**
     * Tìm kiếm một cô gái trong database theo tên
     * @param name
     * @return
     */

    Girl getGirlByName(String name);
}
