package com.example.sb11_springboot_jpa_mysql;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Sb11SpringBootJpaMySqlApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Sb11SpringBootJpaMySqlApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        //lấy ra toàn bộ thông tin trong Database
//        userRepository.findAll().forEach(System.out::println);
//
//        //Lưu user xuống database
//        User user = userRepository.save(new User());

//        //Khi lưu xong, nó tr về User đã lưu kèm theo Id
//        System.out.println("User vừa lưu xuống Db có ID: " + user.getId());
//        Long userId = user.getId();
//
//        //Cập nhật user
//        user.setAgi(100);
//        //Update user
//        //Lưu ý, lúc này đối tượng user đã có Id
//        //Nên nó sẽ update vào đối tượng có Id này
//        //Chứ không phải insert một bản ghi mới
//        userRepository.save(user);
//
//        //Query lấy ra user vừa xong để kiểm tra xem
//        User user2 = userRepository.findById(userId).get();
//        System.out.println("User: " + user);
//        System.out.println("User2: " + user2);
//
//        //Xóa user khỏi Db
//        userRepository.delete(user);
//
//        //In ra kiểm tra xem userId còn tồn tại trong Db không ?
//        User user3 = userRepository.findById(userId).orElse(null);
//        System.out.println("User3: " + user3);

        System.out.println("Tìm user với Agi trong khoảng (25 - 30)");
        System.out.println("findAllByAgiBetween: ");
        userRepository.findAllByAgiBetween(25, 30).forEach(System.out::println);

        System.out.println("===========================================");
        System.out.println("Tìm user với Agi trong lớn hơn 97");
        System.out.println("findAllByAgiGreaterThan: ");
        userRepository.findAllByAgiGreaterThan(97).forEach(System.out::println);

        // Tìm kiếm tất cả theo Atk = 74
        System.out.println("===========================================");
        System.out.println("Tìm user với Atk = 74");
        System.out.println("findAllByAtk: ");
        userRepository.findAllByAtk(74).forEach(System.out::println);

        System.out.println("===========================================");
        System.out.println("Tìm User với def = 13");
        System.out.println("SELECT u FROM User u WHERE u.def = :def");
        User user = userRepository.findUserByDefQuery(13);
        System.out.println("User: " + user);
    }
}
