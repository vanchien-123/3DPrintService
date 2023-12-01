package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Printers;
import com.aptech.demo.models.Technologies;

@Repository
public class PrintersRepository {
	@Autowired
	JdbcTemplate db;

	class PtRowMapper implements RowMapper<Printers> {
		@Override
		public Printers mapRow(ResultSet rs, int rowNum) throws SQLException {
			Printers pt = new Printers();
			pt.setPrint_id(rs.getString("print_id"));
			pt.setTechnolid(rs.getString("technolid"));
			pt.setMfgerid(rs.getString("mfgerid"));
			pt.setPrint_name(rs.getString("print_name"));
			pt.setPrint_specs(rs.getString("print_specs"));
			pt.setPrint_active(rs.getInt("print_active"));
			return pt;
		}

	}

	public List<Printers> findAll() {
		return db.query("select * from printers", new PtRowMapper());
	}

	public Printers findById(String id) {
		return db.queryForObject("SELECT * FROM printers WHERE print_id IN (?) ", new PtRowMapper(), new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM printers WHERE print_id IN (?) ", new Object[] { id });
	}

	public Printers insert(Printers pt) {
		db.update(
				"INSERT INTO printers( print_id, mfgerid, technolid, print_name, print_specs , print_active) " + "values( ?, ?, ?, ?, ?, ?)",
				new Object[] { pt.getPrint_id(), pt.getMfgerid(), pt.getTechnolid(), pt.getPrint_name(), pt.getPrint_specs(), pt.getPrint_active() });
		return pt;

	}

	public Printers update(Printers pt) {
		db.update("UPDATE printers SET print_id=?, mfgerid=?, technolid=?, print_name =?, print_specs =? WHERE print_id IN (?) ",
				new Object[] {  pt.getPrint_id(), pt.getMfgerid(), pt.getTechnolid(), pt.getPrint_name(), pt.getPrint_specs(), pt.getPrint_id() });
		return pt;
 
	}
	

	public int active(String id) {
		return db.update("UPDATE printers SET print_active='1' WHERE print_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE printers SET print_active='0' WHERE print_id IN (?) ", new Object[] { id });
	}
	
	public List<Printers> findActive() {
		return db.query("SELECT * FROM printers WHERE print_active='1' ", new PtRowMapper());
	}
}
