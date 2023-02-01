package com.userLogin.controller;


import com.userLogin.model.UserInformationRequest;
import com.userLogin.model.UserInformationResponse;
import com.userLogin.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/information")
@CrossOrigin
public class UserInformationController {
    @Autowired
    private UserInformationService userInformationService;

    @PostMapping("/create")
    public void create(@RequestBody UserInformationRequest userInformationRequest){
        userInformationService.create(userInformationRequest.toUserInformation(),userInformationRequest.getUsername());
    }

    @PutMapping("/update")
    public void update(@RequestBody UserInformationRequest userInformationRequest){
        userInformationService.update(userInformationRequest.toUserInformation(),userInformationRequest.getUsername());
    }

    @GetMapping("/get/{username}")
    public UserInformationResponse getByUserName(@PathVariable String username){
        return userInformationService.getByUsername(username);
    }
}
