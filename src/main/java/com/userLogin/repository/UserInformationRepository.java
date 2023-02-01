package com.userLogin.repository;


import com.userLogin.model.UserInformation;

public interface UserInformationRepository {
    void create(UserInformation userInformation);
    void update(UserInformation userInformation);
    void deleteByUserId(Long id);
    UserInformation getByUserId(Long userId);
}
