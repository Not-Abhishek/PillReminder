package com.art.login.controller;

import com.art.login.dto.User;
import com.art.login.services.LoginServicesImpl;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class LoginController {

    LoginServicesImpl ls = new LoginServicesImpl();


    @CrossOrigin
    @PostMapping("/loginpage")
    public String checkLogin(@RequestBody User u) {
        return ls.checkLogin(u);

    }

    @CrossOrigin
    @PostMapping("/register")
    public String register(@RequestBody User u) {
        return ls.registerUser(u);
    }

    @CrossOrigin
    @PostMapping("/resetpassword")
    public String resetPassword(@RequestBody User u) {
        return ls.resetPassword(u);
    }

    @CrossOrigin
    @GetMapping("/profile/{email}")
    public User viewProfile(@PathVariable String email) {
        return ls.viewProfile(email);
    }


}
