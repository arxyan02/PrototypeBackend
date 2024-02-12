package com.example.prototypebackend.Controller;

import com.example.prototypebackend.Models.User;
import com.example.prototypebackend.Repository.UserRepository;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
public class PrototypeController {
    private final UserRepository userRepository;

    public PrototypeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/Signin")
    public String getUserSignin(@RequestBody @Valid final User newUser) {
//        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        User foundUser = userRepository.findByUsername(newUser.getUsername());
        if (foundUser != null && passwordEncoder.matches(newUser.getPassword(), foundUser.getPassword())) {
            return "Logged in";
        } else {
            return "Unauthorized user";
        }
    }

    @PostMapping("/Signup")
    public String getUserSignup(@RequestBody final User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "user added";
    }

}
