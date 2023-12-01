package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.User;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate db;

	class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User user = new User();
			user.setUser_id(rs.getString("user_id"));
			user.setUsertype(rs.getString("usertype"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setTel(rs.getString("tel"));
			user.setAddress(rs.getString("address"));
			user.setRole(rs.getString("role"));
			user.setUser_active(rs.getInt("user_active"));

			return user;
		}
	}

	public List<User> findAll() {
		return db.query("select * from users", new UserRowMapper());
	}

	public User findById(String id) {
		return db.queryForObject("SELECT * FROM users WHERE user_id IN (?) ", new UserRowMapper(), new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM users WHERE user_id IN (?) ", new Object[] { id });
	}

	public User insert(User user) {
		db.update(
				"INSERT INTO users( user_id, usertype, name, password, email, tel, address, role, user_active) "
						+ "values( ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { user.getUser_id(), user.getUsertype(), user.getName(), user.getPassword(), user.getEmail(), user.getTel(),
						user.getAddress(), user.getRole(), user.getUser_active() });
		return user;

	}

	public User update(User user) {
		db.update("UPDATE users SET usertype= ?, name=?, password =?, email=?, tel =?,address=?, role =? WHERE user_id IN (?) ",
				new Object[] { user.getUsertype(), user.getName(), user.getPassword(), user.getEmail(), user.getTel(), user.getAddress(),
						user.getRole(), user.getUser_id() });
		return user;

	}

	public int active(String id) {
		return db.update("UPDATE users SET user_active='1' WHERE user_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE users SET user_active='0' WHERE user_id IN (?) ", new Object[] { id });
	}

	public List<User> findActive() {
		return db.query("SELECT * FROM users WHERE user_active='1' ", new UserRowMapper());
	}
	
	public User findByEmail(String email) {
		return db.queryForObject("SELECT * FROM users WHERE email = ? and user_active = '1'", new UserRowMapper(), new Object[] { email });
	}

	public User checkPassword(String password) {

		return db.queryForObject("SELECT * FROM users WHERE password IN (?) and user_active = '1'", new UserRowMapper(), new Object[] { password });
	}
	
	public User checkUser(String email, String password) {

		return db.queryForObject("SELECT * FROM users WHERE email IN (?) AND password IN (?) AND user_active = '1' ", new UserRowMapper(), new Object[] { email, password });
	}
	
	public String checkEmail(String email) {

		return db.query("SELECT email FROM users WHERE email IN (?)", new UserRowMapper()).toString();
	}

	public String findByRole(String email, String password) {
		return db.queryForObject("SELECT role FROM users WHERE email = (?) and password = (?) and user_active = '1'", new UserRowMapper(), new Object[] { email, password }).toString();
	}

	


}
