package com.Product.backend.products.controller;

import com.Product.backend.products.entity.User;
import com.Product.backend.products.service.MyUserDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final MyUserDetailService service;

    public UserController(MyUserDetailService service) {
        this.service = service;
    }


    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.createUser(user);

    }
}
