package com.lichkham.qllk.repository;

import com.lichkham.qllk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByTaiKhoan(String username);

    Boolean existsByTaiKhoan(String username);

    Boolean existsByEmail(String email);
}

