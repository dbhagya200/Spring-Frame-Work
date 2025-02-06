package lk.ijse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {
    public HelloController() {
        System.out.println("Hello Controller");
    }
    @GetMapping
    public String hello(){
        return "Hello World";

    }
    @PostMapping
    public String post(){
        return "Post Mapping";
    }

    @PutMapping
    public String put(){
        return "Put Mapping";
    }

    @DeleteMapping
    public String delete(){
        return "Delete Mapping";
    }
}
