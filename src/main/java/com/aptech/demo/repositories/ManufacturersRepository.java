package com.aptech.demo.repositories;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aptech.demo.models.Cat;
import com.aptech.demo.models.Manufacturers;
import com.aptech.demo.models.Prodgroups;
import com.aptech.demo.repositories.CatRepository.CatRowMapper;
import com.aptech.demo.repositories.ProdgroupsRepository.ProdgrRowMapper;


@Repository
public class ManufacturersRepository {
	@Autowired
	JdbcTemplate db;

	class MnfaturersRowMapper implements RowMapper<Manufacturers> {
		@Override
		public Manufacturers mapRow(ResultSet rs, int rowNum) throws SQLException {
			Manufacturers mn = new Manufacturers();
			mn.setMfger_id(rs.getString("mfger_id"));
			mn.setMfger_name(rs.getString("mfger_name"));
			mn.setMfger_desc(rs.getString("mfger_desc"));
			mn.setMfger_website(rs.getString("mfger_website"));
			mn.setMfger_active(rs.getInt("mfger_active"));
			return mn;
		}

	}

	public List<Manufacturers> findAll() {
		return db.query("SELECT * FROM manufacturers ", new MnfaturersRowMapper());
	}

	public Manufacturers findById(String id) {
		return db.queryForObject("SELECT * FROM manufacturers WHERE mfger_id IN (?) ", new MnfaturersRowMapper(),
				new Object[] { id });
	}
	
	public int deleteById(String id) {
		return db.update("DELETE FROM manufacturers WHERE mfger_id IN (?) ", new Object[] { id });
	}

	public Manufacturers insert(Manufacturers mn) {
		db.update(
				"INSERT INTO manufacturers( mfger_id, mfger_name, mfger_desc, mfger_website, mfger_active) "
						+ "values( ?, ?, ?, ?, ?)",
				new Object[] { mn.getMfger_id(), mn.getMfger_name(), mn.getMfger_desc(), mn.getMfger_website(), mn.getMfger_active()  });
		return mn;

	}

	public Manufacturers update(Manufacturers mn) {
		db.update("UPDATE manufacturers SET mfger_id=?, mfger_name=?, mfger_desc =?, mfger_website=? WHERE mfger_id IN (?) ",
				new Object[] {  mn.getMfger_id(), mn.getMfger_name(), mn.getMfger_desc(), mn.getMfger_website(), mn.getMfger_id()   });
		return mn;

	}

	public int active(String id) {
		return db.update("UPDATE manufacturers SET mfger_active='1' WHERE mfger_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE manufacturers SET mfger_active='0' WHERE mfger_id IN (?) ", new Object[] { id });
	}

	public List<Manufacturers> findActive() {
		return db.query("SELECT * FROM manufacturers WHERE mfger_active='1' ", new MnfaturersRowMapper());
	}
	
}
