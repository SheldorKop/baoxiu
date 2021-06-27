package com.example.demo11.repository;

import com.example.demo11.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findById(Integer id);

    Optional<User> findByUsernameAndPassword(String username,String password);

    Optional<User> findByUsername(String username);
}
