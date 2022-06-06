package com.example.dockerexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dockerexample.entity.UserAdmin;
import com.example.dockerexample.repository.UserAdminRepository;

@Service
public class UserAdminService {
    @Autowired
    private UserAdminRepository userAdminRepository;
    public List<UserAdmin> findAllUsers() {
        return (List<UserAdmin>) userAdminRepository.findAll();
    }
}
