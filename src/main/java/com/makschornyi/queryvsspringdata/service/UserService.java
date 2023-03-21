package com.makschornyi.queryvsspringdata.service;

import com.makschornyi.queryvsspringdata.model.Post;
import com.makschornyi.queryvsspringdata.model.User;
import com.makschornyi.queryvsspringdata.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    public User saveUser(User user) {
        Post post1 = new Post();
        post1.setText("maks1");
        Post post2 = new Post();
        post2.setText("maks2");
        post1.setUser(user);
        post2.setUser(user);
        return userRepo.save(user);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public Long initUsers(Long count) {
        for (int i = 0; i < count; i++) {
            User u = new User();
            u.setName("Maks");
            userRepo.save(u);
        }
        return userRepo.count();
    }

    public List<User> findAllBySpringJPA(String name) {
        return userRepo.findAllByNameContains(name);
    }

    public List<User> findAllNativeQuery(String name) {
        return userRepo.findAllWeNeed(name);
    }
}
