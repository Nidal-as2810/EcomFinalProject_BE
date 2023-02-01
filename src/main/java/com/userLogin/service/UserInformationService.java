package com.userLogin.service;


import com.userLogin.model.UserInformation;
import com.userLogin.model.UserInformationResponse;

public interface UserInformationService {
    void create(UserInformation userInformation, String username);
    void update(UserInformation userInformation, String username);
    void deleteByUserId(Long userId);
    UserInformationResponse getByUsername(String username);


}
