package com.example.dockerexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dockerexample.entity.UserAdmin;
import com.example.dockerexample.service.UserAdminService;

@RestController
@RequestMapping(path = "user")
public class UserAdminController {
    @Autowired
    private UserAdminService userAdminService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        List<UserAdmin> listUser = userAdminService.findAllUsers();
        if(!listUser.isEmpty()) {
            return "Welcome";
        }
        return "Login fail";
    }
}
