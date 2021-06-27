package com.example.demo11.service;


import com.example.demo11.entity.Baoxiu;
import com.example.demo11.entity.User;
import com.example.demo11.repository.BaoxiuRepository;
import com.example.demo11.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaoxiuService {

    @Autowired
    BaoxiuRepository baoxiuRepository;

    @Autowired
    UserRepository userRepository;


    public Baoxiu findById(Integer id) {
        if (null == id)
            return new Baoxiu();
        return baoxiuRepository.findById(id).orElse(new Baoxiu());
    }

    public List<Baoxiu> query(User user) {
        if (user.getRole().equals("admin"))
            return baoxiuRepository.findAll(Sort.by("id").descending());
        return baoxiuRepository.findByUserIdOrderByIdDesc(user.getId());
    }

    public void edit(Baoxiu baoxiu) {
        if (baoxiu.getId() == -1)
            baoxiu.setId(null);
        baoxiuRepository.save(baoxiu);
    }

    public void delete(Integer id) {
        baoxiuRepository.deleteById(id);
    }


}
