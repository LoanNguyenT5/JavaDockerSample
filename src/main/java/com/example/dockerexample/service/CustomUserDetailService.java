package com.example.dockerexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dockerexample.config.CustomUserDetails;
import com.example.dockerexample.entity.UserAdmin;
import com.example.dockerexample.repository.UserAdminRepository;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserAdminRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserAdmin user =  repo.findByUserId(username);
       if(user == null) {
           throw new UsernameNotFoundException("User not found!");
       }
        return new CustomUserDetails(user);
    }

}
