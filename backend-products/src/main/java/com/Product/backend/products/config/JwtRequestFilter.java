package com.Product.backend.products.config;

import com.Product.backend.products.service.MyUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailService userDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

     String authHeader =   request.getHeader("Authorization");
     String username  =null;
     String token = null;
     if (authHeader != null && authHeader.startsWith("Bearer")){
         token = authHeader.substring(7);
         username = jwtUtil.extractUsername(token);

     }
     if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
         UserDetails userDetails = userDetailService.loadUserByUsername(username);

         

     }
    }
}
