package com.authentication.service;

import com.authentication.entity.User;

public interface UserService {
    String newUser(User user);
    String login(String email, String password);
    String logout(String email);

    void deleteUser(String email);
    void updateUserDetails(String userId, User user);
    void changePassword(String email, String currPass, String newPass);
}
