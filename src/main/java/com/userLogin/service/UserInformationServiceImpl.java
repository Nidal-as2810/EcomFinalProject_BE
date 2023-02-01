package com.userLogin.service;


import com.userLogin.model.CustomUser;
import com.userLogin.model.UserInformation;
import com.userLogin.model.UserInformationResponse;
import com.userLogin.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInformationServiceImpl implements UserInformationService{
    @Autowired
    private UserService userService;

    @Autowired
    private UserInformationRepository userInformationRepository;

    @Override
    public void create(UserInformation userInformation, String username) {
        CustomUser user=userService.findUserByUsername(username);
        if(user !=null){
            UserInformation userExist=userInformationRepository.getByUserId(user.getId());
            if(userExist == null){
                userInformation.setUserId(user.getId());
                userInformationRepository.create(userInformation);
            }else {
                update(userInformation,username);
            }
        }
    }

    @Override
    public void update(UserInformation userInformation, String username) {
        CustomUser user=userService.findUserByUsername(username);
        if(user!=null){
            userInformation.setUserId(user.getId());
            userInformationRepository.update(userInformation);
        }
    }

    @Override
    public void deleteByUserId(Long userId) {
        userInformationRepository.deleteByUserId(userId);
    }

    @Override
    public UserInformationResponse getByUsername(String username) {
        CustomUser user=userService.findUserByUsername(username);
        if(user!=null)
        {
            return userInformationRepository.getByUserId(user.getId()).toUserResponse();
        }
        return null;
    }

}
