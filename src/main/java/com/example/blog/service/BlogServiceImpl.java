package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.model.Post;
import com.example.blog.model.User;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{

    private PostRepository postRepository;
    private UserRepository userRepository;


    @Autowired
    public BlogServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }






    @Override
    public boolean addUser(User user) {
        if(userRepository.findFirstByEmail(user.getEmail()) == null){
            userRepository.save(user);  //INSERT INTO user VALUES
            return true;
        }
        return false;
    }


    @Override
    public boolean deleteUser(long userId) {
        boolean isDeleted = userRepository.existsById(userId);
        userRepository.deleteById(userId);
        return isDeleted;
    }

    @Override

    public boolean updatePassword(long userId, String newPassword) {
        if(userRepository.findById(userId).isPresent()){
            User userToUpdate = userRepository.findById(userId).get();
            userToUpdate.setPassword(newPassword);
            userRepository.save(userToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsersOrderByRegistrationDateDesc() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Post addPostByUser(long userId, String title, String content, Category category) {
        if(userRepository.existsById(userId)){
         User user = userRepository.findById(userId).get();
         postRepository.save(new Post(title, content, category, user));
        }

        return null;
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "dateAdded"));
        }

    }

