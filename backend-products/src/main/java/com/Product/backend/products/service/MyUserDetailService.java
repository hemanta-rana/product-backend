package com.Product.backend.products.service;

import com.Product.backend.products.dto.UserPrincipal;
import com.Product.backend.products.entity.User;
import com.Product.backend.products.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
       return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()) throw new UsernameNotFoundException("User not found!");
        return new UserPrincipal(user.get());
    }
}
