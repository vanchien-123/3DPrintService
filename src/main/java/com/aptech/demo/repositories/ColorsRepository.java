package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Colors;



@Repository
public class ColorsRepository {
	@Autowired
	JdbcTemplate db;

	class ColorsRowMapper implements RowMapper<Colors> {
		@Override
		public Colors mapRow(ResultSet rs, int rowNum) throws SQLException {
			Colors cl = new Colors();
			cl.setColor_id(rs.getString("color_id"));;
			cl.setColor_name(rs.getString("color_name"));
			cl.setColor_active(rs.getInt("color_active"));
			cl.setColor_hex(rs.getString("color_hex"));
			return cl;
		}

	}

	public List<Colors> findAll() {
		return db.query("select * from colors", new ColorsRowMapper());
	}

	public Colors findById(String id) {
		return db.queryForObject("SELECT * FROM colors WHERE color_id IN (?) ", new ColorsRowMapper(), new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM colors WHERE color_id IN (?) ", new Object[] { id });
	}

	public Colors insert(Colors cl) {
		db.update(
				"INSERT INTO colors( color_id, color_name, color_hex, color_active) " + "values( ?, ?, ?, ?)",
				new Object[] { cl.getColor_id(), cl.getColor_name(), cl.getColor_hex(), cl.getColor_active() });
		return cl;

	}

	public Colors update(Colors cl) {
		db.update("UPDATE colors SET color_id=?, color_name=?, color_hex =? WHERE color_id IN (?) ",
				new Object[] { cl.getColor_id(), cl.getColor_name() , cl.getColor_hex(), cl.getColor_id() });
		return cl;
 
	}
	

	public int active(String id) {
		return db.update("UPDATE colors SET color_active='1' WHERE color_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE colors SET color_active='0' WHERE color_id IN (?) ", new Object[] { id });
	}
	
	public List<Colors> findActive() {
		return db.query("SELECT * FROM colors WHERE color_active='1' ", new ColorsRowMapper());
	}
	
}
