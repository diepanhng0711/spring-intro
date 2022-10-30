package com.example.introtospring;

import org.springframework.stereotype.Component;

/*
 Đánh dấu class bằng @Component
 Class này sẽ được Spring Boot hiểu là một Bean (hoặc dependency)
 Và sẽ được Spring Boot quản lý
*/
@Component
public class Shirt implements Outfit{
    @Override
    public void wear() {
        System.out.println("Wearing Shirt");
    }

    public void show() {
        System.out.println("Showing shirt");
    }
}
