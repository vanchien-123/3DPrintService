package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Cat;
import com.aptech.demo.models.Printers;
//import com.aptech.demo.models.Cat;
import com.aptech.demo.models.Subcats;
//import com.aptech.demo.repositories.CatRepository.CatRowMapper;
import com.aptech.demo.repositories.PrintersRepository.PtRowMapper;

@Repository
public class SubcatsRepository {
	@Autowired
	JdbcTemplate db;

	class SCatRowMapper implements RowMapper<Subcats> {
		@Override
		public Subcats mapRow(ResultSet rs, int rowNum) throws SQLException {
			Subcats scat = new Subcats();
			Cat cat = new Cat();
			scat.setSubcat_id(rs.getString("subcat_id"));
			scat.setSubcat_name(rs.getString("subcat_name"));
			scat.setSubcat_desc(rs.getString("subcat_desc"));
			scat.setSubcat_active(rs.getInt("subcat_active"));
			scat.setSubcat_createdat(rs.getDate("subcat_createdat"));
			scat.setCatid(rs.getString("catid"));
			return scat;
		}

	}

	public List<Subcats> findAll() {
		return db.query("SELECT * FROM subcats ", new SCatRowMapper());
	}

	public Subcats findById(String id) {
		return db.queryForObject("SELECT * FROM subcats WHERE subcat_id IN (?) ", new SCatRowMapper(),
				new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM subcats WHERE subcat_id IN (?) ", new Object[] { id });
	}

	public Subcats insert(Subcats scat) {
		db.update(
				"INSERT INTO subcats( subcat_id, subcat_name, subcat_desc, subcat_active, subcat_createdat, catid) "
						+ "values( ?, ?, ?, ?, ?, ?)",
				new Object[] { scat.getSubcat_id(), scat.getSubcat_name(), scat.getSubcat_desc(),
						scat.getSubcat_active(), scat.getSubcat_createdat(), scat.getCatid() });
		return scat;

	}

	public Subcats update(Subcats scat) {
		db.update("UPDATE subcats SET subcat_id=?, subcat_name=?, subcat_desc =?, catid =? WHERE subcat_id IN (?) ",
				new Object[] { scat.getSubcat_id(), scat.getSubcat_name(), scat.getSubcat_desc(), scat.getCatid(),
						scat.getSubcat_id() });
		return scat;

	}

	public int active(String id) {
		return db.update("UPDATE subcats SET subcat_active='1' WHERE subcat_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE subcats SET subcat_active='0' WHERE subcat_id IN (?) ", new Object[] { id });
	}
	
	public List<Subcats> findActive() {
		return db.query("SELECT * FROM subcats WHERE subcat_active='1' ", new SCatRowMapper());
	}

}
