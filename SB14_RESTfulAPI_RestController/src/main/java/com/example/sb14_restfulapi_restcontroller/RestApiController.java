package com.example.sb14_restfulapi_restcontroller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Lưu ý, @RequestMapping ở class, sẽ tác động tới
 * tất cả các RequestMapping ở bên trong nó.
 *
 * Mọi Request ở trong method sẽ được gắn thêm prefix /api/v1
 */
@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    private List<Todo> todoList = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init() {
        //Thêm null vào List để bỏ qua vị trí số 0;
//        todoList.add(null);
        todoList = IntStream.range(0, 10)
                .mapToObj(i -> new Todo("title-" + i, "detail-" + i))
                .collect(Collectors.toList());
    }

    @GetMapping("/todo")
    public List<Todo> getTodoList() {
        return todoList;
    }

    /*
    phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
     */
    @GetMapping("todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") Integer todoId) {
        //@PathVariable lấy ra thông tin trong URL
        //Dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /todo/{todoId}
        return todoList.get(todoId);
    }

    /*
    * @RequestBody nói với Spring Boot rằng hãy chuyển JSON trong request body thành đối tượng Todo
    */
    @PutMapping("/todo/{todoId}")
    public Todo editTodo(@PathVariable(name = "todoId") Integer todoId, @RequestBody Todo todo) {
        todoList.set(todoId, todo);
        //Trả về đối tượng sau khi đã edit
        return todo;
    }

    @DeleteMapping("todo/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable(name = "todoId") Integer todoId) {
        todoList.remove(todoId.intValue());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        todoList.add(todo);
        //Trả về response với STATUS CODE = 200 (OK)
        //Body sẽ chứa thông tin về đối tượng todo vừa được tạo
        return ResponseEntity.ok().body(todo);
    }

}
