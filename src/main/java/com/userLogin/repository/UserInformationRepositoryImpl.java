package com.userLogin.repository;


import com.userLogin.model.UserInformation;
import com.userLogin.repository.mapper.UserInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserInformationRepositoryImpl implements UserInformationRepository{
    private static final String TABLE_NAME="user_info";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(UserInformation userInformation) {
        String sql="Insert Into "+TABLE_NAME+"(firstname,lastname,email,state,city,phone,address,user_id)" +
                " Values(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                    userInformation.getFirstname(),
                    userInformation.getLastname(),
                    userInformation.getEmail(),
                    userInformation.getState(),
                    userInformation.getCity(),
                    userInformation.getPhone(),
                    userInformation.getAddress(),
                    userInformation.getUserId()
                );
    }

    @Override
    public void update(UserInformation userInformation) {
        String sql="Update "+TABLE_NAME+" Set firstname=?,lastname=?,email=?,state=?,city=?,phone=?,address=? Where user_id=?" ;
        jdbcTemplate.update(sql,
                userInformation.getFirstname(),
                userInformation.getLastname(),
                userInformation.getEmail(),
                userInformation.getState(),
                userInformation.getCity(),
                userInformation.getPhone(),
                userInformation.getAddress(),
                userInformation.getUserId()
        );
    }

    @Override
    public void deleteByUserId(Long id) {
        String sql="Delete From "+TABLE_NAME+" Where user_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public UserInformation getByUserId(Long userId) {
        String sql="Select * From "+TABLE_NAME+" Where user_id=?";
        try{
            return jdbcTemplate.queryForObject(sql,new UserInformationMapper(),userId);
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }
}
