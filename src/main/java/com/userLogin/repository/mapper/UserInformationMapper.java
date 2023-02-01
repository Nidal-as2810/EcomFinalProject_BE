package com.userLogin.repository.mapper;


import com.userLogin.model.UserInformation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInformationMapper implements RowMapper<UserInformation> {

    @Override
    public UserInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserInformation(
                rs.getLong("id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("email"),
                rs.getString("state"),
                rs.getString("city"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getLong("user_id")
        );
    }
}
