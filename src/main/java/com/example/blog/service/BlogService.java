package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.model.Post;
import com.example.blog.model.User;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    //dodawanie użytkownika
        boolean addUser(User user);
    //usuwanie użytkownika
        boolean deleteUser(long userId);
    //zmiana hasla
        boolean updatePassword(long userId, String newPassword);
    //pobranie wszystkich użytkowników
        List<User> getAllUsersOrderByRegistrationDateDesc();
    //pobranie użytkownika po id
    Optional<User> getUserById(long id);

    Post addPostByUser(long userId, String title, String Content, Category category);

    List<Post> getAllPost();


}
