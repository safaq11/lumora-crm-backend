package com.customercrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customercrm.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUsername(String username);

}