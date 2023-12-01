package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Printers;
import com.aptech.demo.models.Prodgroups;
import com.aptech.demo.models.Subcats;
import com.aptech.demo.repositories.PrintersRepository.PtRowMapper;

@Repository
public class ProdgroupsRepository {
	@Autowired
	JdbcTemplate db;

	class ProdgrRowMapper implements RowMapper<Prodgroups> {
		@Override
		public Prodgroups mapRow(ResultSet rs, int rowNum) throws SQLException {
			Prodgroups pg = new Prodgroups();
			pg.setProdgroup_id(rs.getString("prodgroup_id"));
			pg.setProdgroup_name(rs.getString("prodgroup_name"));
			pg.setProdgroup_desc(rs.getString("prodgroup_desc"));
			pg.setProdgroup_active(rs.getInt("prodgroup_active"));
			pg.setProdgroup_createdat(rs.getDate("prodgroup_createdat"));
			return pg;
		}

	}

	public List<Prodgroups> findAll() {
		return db.query("SELECT * FROM prodgroups ", new ProdgrRowMapper());
	}

	public Prodgroups findById(String id) {
		return db.queryForObject("SELECT * FROM prodgroups WHERE prodgroup_id IN (?) ", new ProdgrRowMapper(),
				new Object[] { id });
	}
	
	public int deleteById(String id) {
		return db.update("DELETE FROM prodgroups WHERE prodgroup_id IN (?) ", new Object[] { id });
	}

	public Prodgroups insert(Prodgroups pg) {
		db.update(
				"INSERT INTO prodgroups( prodgroup_id, prodgroup_name, prodgroup_desc, prodgroup_active, prodgroup_createdat) "
						+ "values( ?, ?, ?, ?, ?)",
				new Object[] { pg.getProdgroup_id(), pg.getProdgroup_name(), pg.getProdgroup_desc(),pg.getProdgroup_active(), pg.getProdgroup_createdat()  });
		return pg;

	}

	public Prodgroups update(Prodgroups pg) {
		db.update("UPDATE prodgroups SET prodgroup_id=?, prodgroup_name=?, prodgroup_desc =? WHERE prodgroup_id IN (?) ",
				new Object[] {  pg.getProdgroup_id(), pg.getProdgroup_name(), pg.getProdgroup_desc(), pg.getProdgroup_id()   });
		return pg;

	}

	public int active(String id) {
		return db.update("UPDATE prodgroups SET prodgroup_active='1' WHERE prodgroup_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE prodgroups SET prodgroup_active='0' WHERE prodgroup_id IN (?) ", new Object[] { id });
	}
	
	public List<Prodgroups> findActive() {
		return db.query("SELECT * FROM prodgroups WHERE prodgroup_active='1' ", new ProdgrRowMapper());
	}

}
