package com.imooc.todosservice.web;

import com.imooc.todosservice.domain.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodosController {

    @GetMapping("/todos")
    public List<Todo> getMessages() {
        return List.of(
            Todo.builder()
                .id(1L)
                .title("洗漱")
                .desc("明早六点起床洗漱")
                .createdBy("张三")
                .build(),
            Todo.builder()
                .id(2L)
                .title("点外卖")
                .desc("明早7点叫外卖")
                .createdBy("李四")
                .build());
    }
}
