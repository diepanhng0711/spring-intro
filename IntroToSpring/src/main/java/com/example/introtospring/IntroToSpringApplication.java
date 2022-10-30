package com.example.introtospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class IntroToSpringApplication {

    public static void main(String[] args) {
        //ApplicationContext chính là container, chứa toàn bộ các bean
        ApplicationContext context = SpringApplication.run(IntroToSpringApplication.class, args);

        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
        // dấu @Component.

        //Lấy Bean
        Outfit outfit = context.getBean(Outfit.class);

        System.out.println("Instance: " + outfit);
        outfit.wear();

        Girl girl = context.getBean(Girl.class);

        System.out.println("Girl Instance: " + girl);

        System.out.println("Girl Outfit: " + girl.outfit);

        girl.outfit.wear();
    }
}
