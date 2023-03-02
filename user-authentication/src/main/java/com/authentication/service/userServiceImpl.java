package com.authentication.service;

import com.authentication.entity.User;
import com.authentication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    static String getAlphaNumericString()
    {
        int n = 32;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz" + "!@#$%^&*";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    @Override
    public String newUser(User user) {
        // generate unique user id
        userRepo.save(user);
        return "saved";
    }

    @Override
    public String login(String email, String password) {

        User user = userRepo.findByEmailIgnoreCase(email);
        if(user == null) return "not-found";
        if(!user.getPassword().equals(password)){
            return "incorrect-password";
        }
        return user.getAuthToken();
    }

    @Override
    public String logout(String email) {
        User user = userRepo.findByEmailIgnoreCase(email);
        if(user== null) return "not-found";
        String random = getAlphaNumericString();
        user.setAuthToken(random);
        userRepo.save(user);
        return "success";
    }

    @Override
    public void deleteUser(String email) {
        
        return;

    }

    @Override
    public void updateUserDetails(String userId, User user) {

    }

    @Override
    public void changePassword(String email, String currPass, String newPass) {

    }
}
