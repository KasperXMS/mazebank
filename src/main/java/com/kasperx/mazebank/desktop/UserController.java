package com.kasperx.mazebank.desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author Kasper Sergeievic
 * @version 0.1.0
 * @date 2021-04-16
 * @description Request mapping for user profile operations
 */
@RestController
public class UserController {

    @Autowired
    UserProfileMapper userProfileMapper;

    @PostMapping("/addUser")
    public void addUser(@RequestParam int userProfileId, @RequestParam String forename, @RequestParam String surname,
                        @RequestParam String idNumber, @RequestParam boolean gender, @RequestParam
                        String birthday, @RequestParam String username, @RequestParam String password,
                        @RequestParam String email, @RequestParam String tel,
                        @RequestParam String address1, @RequestParam String address2, @RequestParam String address3){
        userProfileMapper.addNewUser(new UserProfile(userProfileId, forename, surname, idNumber, gender, birthday,
                username, password, email, tel, address1, address2, address3));
    }

    @PostMapping("/authLoginByUsername")
    public int authLoginByUsername(@RequestParam String username, @RequestParam String password){
        UserProfile u = userProfileMapper.authLoginByUsername(username, password);
        return authUser(u);
    }

    @PostMapping("/authLoginByTel")
    public int authLoginByTel(@RequestParam String tel, @RequestParam String password){
        UserProfile u = userProfileMapper.authLoginByTelNumber(tel, password);
        return authUser(u);
    }

    private int authUser(UserProfile u) {
        if(u != null){
            int sessionId = generateSessionId();
            if(userProfileMapper.checkSessionIdGet(u.getUserProfileId()) > 0){
                userProfileMapper.updateSession(sessionId, u.getUserProfileId());
            }
            else {
                userProfileMapper.addNewSession(sessionId, u.getUserProfileId());
            }
            return sessionId;
        }
        return 0;
    }

    public int generateSessionId(){
        return new Random().nextInt(89999999) + 10000000;
    }
}
