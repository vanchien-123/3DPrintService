package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Payments;


@Repository
public class PaymentsRepository {
	@Autowired
	JdbcTemplate db;

	class PaysRowMapper implements RowMapper<Payments> {
		@Override
		public Payments mapRow(ResultSet rs, int rowNum) throws SQLException {
			Payments pays = new Payments();
			pays.setPayment_id(rs.getString("payment_id"));
			pays.setPayment_name(rs.getString("payment_name"));
			pays.setPayment_type(rs.getString("payment_type"));
			pays.setPayment_active(rs.getInt("payment_active"));
			return pays;
		}

	}

	public List<Payments> findAll() {
		return db.query("select * from payments", new PaysRowMapper());
	}

	public Payments findById(String id) {
		return db.queryForObject("SELECT * FROM payments WHERE payment_id IN (?) ", new PaysRowMapper(), new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM payments WHERE payment_id IN (?) ", new Object[] { id });
	}

	public Payments insert(Payments paym) {
		db.update(
				"INSERT INTO payments( payment_id, payment_name, payment_type, payment_active) " + "values( ?, ?, ?, ?)",
				new Object[] { paym.getPayment_id(), paym.getPayment_name(), paym.getPayment_type(), paym.getPayment_active() });
		return paym;

	}

	public Payments update(Payments paym) {
		db.update("UPDATE payments SET payment_id=?, payment_name=?, payment_type =? WHERE payment_id IN (?) ",
				new Object[] { paym.getPayment_id(), paym.getPayment_name(), paym.getPayment_type(), paym.getPayment_id()});
		return paym;

	}

	public int active(String id) {
		return db.update("UPDATE payments SET payment_active='1' WHERE payment_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE payments SET payment_active='0' WHERE payment_id IN (?) ", new Object[] { id });
	}

	public List<Payments> findActive() {
		return db.query("SELECT * FROM payments WHERE payment_active='1' ", new PaysRowMapper());
	}

}
