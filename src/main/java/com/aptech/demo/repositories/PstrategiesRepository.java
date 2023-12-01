package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.aptech.demo.models.Pstrategies;


@Repository
public class PstrategiesRepository {
	@Autowired
	JdbcTemplate db;

	class PstrategiesRowMapper implements RowMapper<Pstrategies> {
		@Override
		public Pstrategies mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pstrategies ps = new Pstrategies();
			ps.setPstrategy_id(rs.getString("pstrategy_id"));
			ps.setMatid(rs.getString("matid"));
			ps.setPrintid(rs.getString("printid"));
			ps.setLayerfineness(rs.getFloat("layerfineness"));
			ps.setPstrategy_name(rs.getString("pstrategy_name"));
			ps.setPstrategy_specs(rs.getString("pstrategy_specs"));
			ps.setUfabprice(rs.getFloat("ufabprice"));
			ps.setPstrategy_continuity(rs.getInt("pstrategy_continuity"));
			ps.setPstrategy_active(rs.getInt("pstrategy_active"));
			return ps;
		}

	}

	
	public List<Pstrategies> findAll() {
		return db.query("SELECT * FROM pstrategies ", new PstrategiesRowMapper());
	}

	public Pstrategies findById(String id) {
		return db.queryForObject("SELECT * FROM pstrategies WHERE pstrategy_id IN (?) ", new PstrategiesRowMapper(),
				new Object[] { id });
	}
	
	public int deleteById(String id) {
		return db.update("DELETE FROM pstrategies WHERE pstrategy_id IN (?) ", new Object[] { id });
	}

	public Pstrategies insert(Pstrategies ps) {
		db.update(
				"INSERT INTO pstrategies( pstrategy_id, matid, printid , pstrategy_name, ufabprice, pstrategy_specs, layerfineness, pstrategy_continuity, pstrategy_active) "
						+ "values( ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { ps.getPstrategy_id(), ps.getMatid(), ps.getPrintid(), ps.getPstrategy_name(), ps.getUfabprice(), ps.getPstrategy_specs(), ps.getLayerfineness(), ps.getPstrategy_continuity(), ps.getPstrategy_active()  });
		return ps;

	}

	public Pstrategies update(Pstrategies ps) {
		db.update("UPDATE pstrategies SET pstrategy_id=?, matid=?, printid=?, pstrategy_name=?, ufabprice, pstrategy_specs, layerfiness, pstrategy_continuity WHERE pstrategy_id IN (?) ",
				new Object[] {  ps.getPstrategy_id(), ps.getMatid(), ps.getPrintid(), ps.getPstrategy_name(), ps.getUfabprice(), ps.getPstrategy_specs(), ps.getLayerfineness(), ps.getPstrategy_continuity(), ps.getPstrategy_id()   });
		return ps;

	}

	public int active(String id) {
		return db.update("UPDATE pstrategies SET pstrategy_active='1' WHERE pstrategy_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE pstrategies SET pstrategy_active='0' WHERE pstrategy_id IN (?) ", new Object[] { id });
	}
}
