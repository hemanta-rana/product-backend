package com.Product.backend.products.repository;

import com.Product.backend.products.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username );
}
