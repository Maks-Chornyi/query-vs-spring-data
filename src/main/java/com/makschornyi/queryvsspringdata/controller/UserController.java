package com.makschornyi.queryvsspringdata.controller;

import com.makschornyi.queryvsspringdata.model.User;
import com.makschornyi.queryvsspringdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/init/{count}")
    public ResponseEntity<Long> initUsers(@PathVariable Long count) {
        return new ResponseEntity<>(userService.initUsers(count), HttpStatus.CREATED);
    }

    @GetMapping("/spring-jpa")
    public ResponseEntity<List<User>> findAllBySpringJPA(@RequestParam String name) {
        return new ResponseEntity<>(userService.findAllBySpringJPA(name), HttpStatus.OK);
    }

    @GetMapping("/query")
    public ResponseEntity<List<User>> findAllNativeQuery(@RequestParam String name) {
        return new ResponseEntity<>(userService.findAllNativeQuery(name), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping ResponseEntity<User> add(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
