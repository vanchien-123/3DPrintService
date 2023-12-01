package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.aptech.demo.models.Technologies;

@Repository
public class TechnologiesRepository {
	@Autowired
	JdbcTemplate db;

	class TnRowMapper implements RowMapper<Technologies> {
		@Override
		public Technologies mapRow(ResultSet rs, int rowNum) throws SQLException {
			Technologies tn = new Technologies();
			tn.setTechnol_id(rs.getString("technol_id"));
			tn.setTechnol_name(rs.getString("technol_name"));
			tn.setTechnol_desc(rs.getString("technol_desc"));
			tn.setTechnol_notes(rs.getString("technol_notes"));
			tn.setTechnol_active(rs.getInt("technol_active"));			
			return tn;
		}

	}

	public List<Technologies> findAll() {
		return db.query("select * from technologies", new TnRowMapper());
	}

	public Technologies findById(String id) {
		return db.queryForObject("SELECT * FROM technologies WHERE technol_id IN (?) ", new TnRowMapper(), new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM technologies WHERE technol_id IN (?) ", new Object[] { id });
	}

	public Technologies insert(Technologies tn) {
		db.update(
				"INSERT INTO technologies( technol_id, technol_name, technol_desc, technol_notes ,technol_active) " + "values( ?, ?, ?, ?, ?)",
				new Object[] { tn.getTechnol_id(), tn.getTechnol_name(), tn.getTechnol_desc(), tn.getTechnol_notes(), tn.getTechnol_active() });
		return tn;

	}

	public Technologies update(Technologies tn) {
		db.update("UPDATE technologies SET  technol_name=?, technol_desc=?, technol_notes=? WHERE technol_id IN (?) ",
				new Object[] { tn.getTechnol_name(), tn.getTechnol_desc(), tn.getTechnol_notes(),tn.getTechnol_id() });
		return tn;
	}
	

	public int active(String id) {
		return db.update("UPDATE technologies SET technol_active='1' WHERE technol_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE technologies SET technol_active='0' WHERE technol_id IN (?) ", new Object[] { id });
	}
	
	public List<Technologies> findActive() {
		return db.query("SELECT * FROM technologies WHERE technol_active='1' ", new TnRowMapper());
	}
}
