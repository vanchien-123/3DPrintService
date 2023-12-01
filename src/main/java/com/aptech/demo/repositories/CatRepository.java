package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Cat;

@Repository
public class CatRepository {
	@Autowired
	JdbcTemplate db;

	class CatRowMapper implements RowMapper<Cat> {
		@Override
		public Cat mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cat cat = new Cat();
			cat.setId(rs.getString("cat_id"));
			cat.setName(rs.getString("cat_name"));
			cat.setDesc(rs.getString("cat_desc"));
			cat.setActive(rs.getInt("cat_active"));
			cat.setCreatedat(rs.getDate("cat_createdat"));
			return cat;
		}

	}

	public List<Cat> findAll() {
		return db.query("select * from cats", new CatRowMapper());
	}

	public Cat findById(String id) {
		return db.queryForObject("SELECT * FROM cats WHERE cat_id IN (?) ", new CatRowMapper(), new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM cats WHERE cat_id IN (?) ", new Object[] { id });
	}

	public Cat insert(Cat cat) {
		db.update(
				"INSERT INTO cats( cat_id, cat_name, cat_desc, cat_active, cat_createdat) " + "values( ?, ?, ?, ?, ?)",
				new Object[] { cat.getId(), cat.getName(), cat.getDesc(), cat.getActive(), cat.getCreatedat() });
		return cat;

	}

	public Cat update(Cat cat) {
		db.update("UPDATE cats SET cat_id=?, cat_name=?, cat_desc =? WHERE cat_id IN (?) ",
				new Object[] { cat.getId(),cat.getName() ,cat.getDesc(), cat.getId() });
		return cat;
 
	}
	

	public int active(String id) {
		return db.update("UPDATE cats SET cat_active='1' WHERE cat_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE cats SET cat_active='0' WHERE cat_id IN (?) ", new Object[] { id });
	}
	
	public List<Cat> findActive() {
		return db.query("SELECT * FROM cats WHERE cat_active='1' ", new CatRowMapper());
	}
	
	
	
}
