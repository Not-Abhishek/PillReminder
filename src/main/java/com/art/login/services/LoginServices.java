package com.art.login.services;

import com.art.login.dto.User;

public interface LoginServices {

    public String checkLogin(User u);

    public String registerUser(User u);

    public String resetPassword(User u);

    public User viewProfile(String email);


}
