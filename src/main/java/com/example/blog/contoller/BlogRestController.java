package com.example.blog.contoller;

import com.example.blog.model.Category;
import com.example.blog.model.Post;
import com.example.blog.model.User;
import com.example.blog.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/rest")
@RestController  //kontroler generujacy wyniki w postaci REST API
@Controller     //kontroler komunikujacy sie z warstwa front-end
public class BlogRestController {

    private BlogServiceImpl blogService;

    @Autowired
    public BlogRestController(BlogServiceImpl blogService) {
        this.blogService = blogService;
    }


    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/hello/{name}")        //var - zmienna osadzona w sciezce
    public String helloMe(@PathVariable("name") String name) {
        return "hello " + name.toLowerCase();
    }

    //żądanie dodania nowego użytkownika do tabeli
    @PostMapping("/addUser")
    public boolean addUser(
            @RequestParam("name") String name, @RequestParam("lastName") String lastName,
            @RequestParam("email") String email, @RequestParam("password") String password) {
        return blogService.addUser(new User(name, lastName, email, password));
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return blogService.getAllUsersOrderByRegistrationDateDesc();
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestParam("userId") long userId) {
        return blogService.deleteUser(userId);
    }

    @GetMapping(value = "/user/{userId}")
    public String getUserById(@RequestParam("userId") long userId) {
        Optional<User> userOptional = blogService.getUserById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get().toString();
        }
        return "brak uzytkownika o id " + userId;

    }

    @PutMapping("/updateUserPassword")
    public boolean updateUserPassword(@RequestParam("userId") long userId,
                                      @RequestParam("newPassword") String newPassword){
        return blogService.updatePassword(userId, newPassword);

    }

    @PostMapping("/addPost")
    public Post addPostByUser( @RequestParam("title") String title,
                               @RequestParam("content") String content,
                               @RequestParam("category") Category category,
                               @RequestParam("userId") long userId
    ){
    return blogService.addPostByUser(userId, title, content, category);

    }
    @GetMapping(value = "/posts")
    public List<Post> getAllPosts(){
        return blogService.getAllPost();
    }
}