package com.example.blog.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller // klasa mapujaca zadania protokolu http
public class BlogController {

@GetMapping("/")    //na adresie URL localhost:8080/
    public String home(Model model){  //wywolywana jest metoda zwracajaca String
    //Model - klasa do przekazywania paramatrow pomiedzy warstwami front i back
//    model.addAttribute("nazwa obiektu front end", "nazwa obiektu przekazana z back end")
    model.addAttribute("header_title", "BLOG IT");
    model.addAttribute("header_author", "mati");

    //miejsce na implementacje

    return "blog";   //wartoscia zwracana jest nazwa szablony Thymeleaf-> domyslna lokalizacja to resource/templates
                        //-> nie dopisujemy rozszerzenia .html lub jakiegokolwiek innego
}
}
