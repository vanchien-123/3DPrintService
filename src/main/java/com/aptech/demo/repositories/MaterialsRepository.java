package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Cat;
import com.aptech.demo.models.Colors;
import com.aptech.demo.models.Materials;
import com.aptech.demo.repositories.CatRepository.CatRowMapper;
import com.aptech.demo.repositories.MaterialsRepository.MaterialsRowMapper;



@Repository
public class MaterialsRepository {
	@Autowired
	JdbcTemplate db;

	class MaterialsRowMapper implements RowMapper<Materials> {
		@Override
		public Materials mapRow(ResultSet rs, int rowNum) throws SQLException {
			Materials ma = new Materials();
			ma.setMaterial_id(rs.getString("material_id"));
			ma.setColorid(rs.getString("colorid"));
			ma.setMfgerid(rs.getString("mfgerid"));
			ma.setMaterial_name(rs.getString("material_name"));
			ma.setMaterial_desc(rs.getString("material_desc"));
			ma.setMaterial_uprice(rs.getFloat("material_uprice"));
			ma.setMaterial_continuity(rs.getInt("material_continuity"));
			ma.setMaterial_active(rs.getInt("material_active"));
			ma.setDensity(rs.getFloat("density"));			
			return ma;
		}

	}

	
	public List<Materials> findAll() {
		return db.query("SELECT * FROM materials ", new MaterialsRowMapper());
	}

	public Materials findById(String id) {
		return db.queryForObject("SELECT * FROM materials WHERE material_id IN (?) ", new MaterialsRowMapper(),
				new Object[] { id });
	}
	
	public Materials findByPrice(Float matPrice) {
		return db.queryForObject("SELECT * FROM materials WHERE material_uprice IN (?) ", new MaterialsRowMapper(),
				new Object[] { matPrice });
	}
	

	public int deleteById(String id) {
		return db.update("DELETE FROM materials WHERE material_id IN (?) ", new Object[] { id });
	}

	public Materials insert(Materials ma) {
		db.update(
				"INSERT INTO materials( material_id, colorid, mfgerid , material_name, material_desc, material_uprice, material_continuity, material_active, density) "
						+ "values( ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { ma.getMaterial_id(), ma.getColorid(), ma.getMfgerid(), ma.getMaterial_name(), ma.getMaterial_desc(), ma.getMaterial_uprice(), ma.getMaterial_continuity(), ma.getMaterial_active(), ma.getDensity()  });
		return ma;

	}

	public Materials update(Materials ma) {
		db.update("UPDATE materials SET material_id=?, colorid=?, mfgerid=?, material_name=?, material_desc=?, material_uprice=?, density=? WHERE material_id IN (?) ",
				new Object[] {  ma.getMaterial_id(),ma.getColorid(), ma.getMfgerid(), ma.getMaterial_name(), ma.getMaterial_desc(), ma.getMaterial_uprice(), ma.getDensity(),ma.getMaterial_id()   });
		return ma;

	}

	public int active(String id) {
		return db.update("UPDATE materials SET material_active='1' WHERE material_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE materials SET material_active='0' WHERE material_id IN (?) ", new Object[] { id });
	}
	
	public int continuity(String id) {
		return db.update("UPDATE materials SET material_continuity='1' WHERE material_id IN (?) ", new Object[] { id });

	}

	public int incontinuity(String id) {
		return db.update("UPDATE materials SET material_continuity='0' WHERE material_id IN (?) ", new Object[] { id });
	}
	
	public List<Materials> findActive() {
		return db.query("SELECT * FROM materials WHERE material_active='1' ", new MaterialsRowMapper());
	}

}
