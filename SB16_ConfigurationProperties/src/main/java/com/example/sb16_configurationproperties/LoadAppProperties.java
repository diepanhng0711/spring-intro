package com.example.sb16_configurationproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@PropertySource("classpath:application.yaml")   //Đánh đấu để lấy config từ trong file diepanhng0711.yml
@ConfigurationProperties(prefix = "application")  //Chỉ lấy các config có tiền tố là diepanhng0711
public class LoadAppProperties {
    private String email;
    private String googleAnalysticsId;

    private List<String> authors;

    private Map<String, String> exampleMap;
}
