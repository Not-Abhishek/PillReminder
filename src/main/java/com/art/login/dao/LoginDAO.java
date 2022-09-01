package com.art.login.dao;

import com.art.login.dto.User;

public interface LoginDAO {
    public Boolean verifyUser(User u);

    public Boolean registerUser(User u);

    public Boolean resetPassword(User u);

    public User getProfile(String email);

}
