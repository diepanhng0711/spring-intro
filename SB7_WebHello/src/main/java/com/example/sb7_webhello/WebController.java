package com.example.sb7_webhello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Đánh dấu đây là một Controller
//Nơi tiếp nhận các request từ phía người dùng
@Controller
public class WebController {

    // Đón nhận request GET nếu người dùng request tới địa chỉ "/"
    @GetMapping("/")
    public String index() {
        return "index"; //Trả về index.html
    }

    //Request tới /about
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    //Request tới /hello
    @GetMapping("/hello")
    public String hello(
          //Request param "name" sẽ được gán vào giá trị biến String
          @RequestParam(name = "name", required = false, defaultValue = "") String name,
          //Model là một object của Spring Boot, được gắn vào trong mọi request
          Model model
    ) {
        //Gắn vào model giá trị name nhận được
        model.addAttribute("name", name);

        return "hello"; //trả về file hello.html cùng với thông tin trong object Model
    }
}
