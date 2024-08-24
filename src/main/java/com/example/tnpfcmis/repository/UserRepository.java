package com.example.tnpfcmis.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tnpfcmis.model.Users;

@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Users findByUsernameAndPassword(String userid,String password) {
		
		String sql = "select userid,password,username,role from userid=? and password=?" ;
		return jdbcTemplate.queryForObject(sql, new Object[]{userid, password}, this::mapRowToUser);
	}
	
	
	private Users mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        Users user = new Users();
        user.setUser_id(rs.getString("userid"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    }

}
