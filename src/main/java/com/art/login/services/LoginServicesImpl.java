package com.art.login.services;

import com.art.login.dao.LoginDAOImpl;
import com.art.login.dto.User;

public class LoginServicesImpl implements LoginServices {

    LoginDAOImpl dao = new LoginDAOImpl();

    @Override
    public String checkLogin(User u) {
        Boolean b;
        if (dao.connect()) {
            System.out.println("Connected to DB in Services ");

        }
        b = dao.verifyUser(u);

        if (b == true) {
            return "Login Successful";
        } else {
            return "Invalid password/email";
        }
    }

    @Override
    public String registerUser(User u) {
        Boolean b;
        if (dao.connect()) {
            System.out.println("Connected to DB in Services");
        }
        b = dao.registerUser(u);
        if (b == true) {
            return "New user Registered";
        } else {
            return "Registration Failed";
        }
    }

    @Override
    public String resetPassword(User u) {

        Boolean b;

        LoginDAOImpl dao = new LoginDAOImpl();

        if (dao.connect()) {
            System.out.println("Connected to DB in Services");

        }
        b = dao.resetPassword(u);

        if (b == true) {
            return "Password Reset Successful";
        } else {
            return "Wrong Password";
        }

    }

    @Override
    public User viewProfile(String email) {

        if (dao.connect()) {
            System.out.println("Connected to DB in Services");
        }
        User profile = dao.getProfile(email);
        return profile;
    }
}
