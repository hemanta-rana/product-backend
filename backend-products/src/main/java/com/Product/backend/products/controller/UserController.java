package com.Product.backend.products.controller;

import com.Product.backend.products.config.JwtUtil;
import com.Product.backend.products.dto.UserDTO;
import com.Product.backend.products.entity.User;
import com.Product.backend.products.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private  JwtUtil jwtUtil;

    private final MyUserDetailService service;

    public UserController(MyUserDetailService service) {
        this.service = service;
    }


    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.createUser(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
       Authentication auth =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
       List<String> roles =  auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .toList();
      UserDetails userDetails=  service.loadUserByUsername(userDTO.getUsername());
       return jwtUtil.generateToken(userDetails.getUsername(),roles);
    }

}
