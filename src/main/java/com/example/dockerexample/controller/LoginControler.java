package com.example.dockerexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dockerexample.entity.UserAdmin;

@RestController
public class LoginControler {

    // test 22
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody UserAdmin user) throws Exception {

        Authentication authObject = null;
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUserId(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authObject);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials");
        }

        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @GetMapping("/login_success_handler")
    public String loginSuccessHandler() {
        // perform audit action
        return "home";
    }

    @GetMapping("/login_failure_handler")
    public String loginFailureHandler() {
        // perform audit action
        return "login";
    }
}
