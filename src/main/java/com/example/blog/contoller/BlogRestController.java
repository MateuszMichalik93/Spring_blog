package com.example.blog.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController  //kontroler generujacy wyniki w postaci REST API
@Controller     //kontroler komunikujacy sie z warstwa front-end
public class BlogRestController {


    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping(value = "/hello/{name}")        //var - zmienna osadzona w sciezce
    public String helloMe(@PathVariable("name") String name){
        return "hello " + name.toLowerCase();
    }
}
