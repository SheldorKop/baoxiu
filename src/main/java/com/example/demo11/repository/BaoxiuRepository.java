package com.example.demo11.repository;

import com.example.demo11.entity.Baoxiu;
import com.example.demo11.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaoxiuRepository extends JpaRepository<Baoxiu, Integer> {

    public List<Baoxiu> findByUserIdOrderByIdDesc(Integer userId);

}
