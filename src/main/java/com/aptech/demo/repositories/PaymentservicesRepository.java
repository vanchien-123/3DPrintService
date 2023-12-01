package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Paymentservices;


@Repository
public class PaymentservicesRepository {
	@Autowired
	JdbcTemplate db;

	class PaysersRowMapper implements RowMapper<Paymentservices> {
		@Override
		public Paymentservices mapRow(ResultSet rs, int rowNum) throws SQLException {
			Paymentservices paysers = new Paymentservices();
			paysers.setPaymentservice_id(rs.getString("paymentservice_id"));
			paysers.setPaymentid(rs.getString("paymentid"));
			paysers.setPaymentservice_name(rs.getString("paymentservice_name"));
			paysers.setPayment_desc(rs.getString("payment_desc"));
			paysers.setPayment_active(rs.getInt("payment_active"));
			return paysers;
		}

	}

	public List<Paymentservices> findAll() {
		return db.query("select * from paymentservices", new PaysersRowMapper());
	}

	public Paymentservices findById(String id) {
		return db.queryForObject("SELECT * FROM paymentservices WHERE paymentservice_id IN (?) ", new PaysersRowMapper(), new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM paymentservices WHERE paymentservice_id IN (?) ", new Object[] { id });
	}

	public Paymentservices insert(Paymentservices paysers) {
		db.update(
				"INSERT INTO paymentservices( paymentservice_id, paymentservice_name, paymentid, payment_desc, payment_active )" + "values( ?, ?, ?, ?, ?)",
				new Object[] { paysers.getPaymentservice_id(), paysers.getPaymentservice_name(), paysers.getPaymentid(), paysers.getPayment_desc() , paysers.getPayment_active() });
		return paysers;

	}

	public Paymentservices update(Paymentservices paysers) {
		db.update("UPDATE paymentservices SET paymentservice_id=?, paymentservice_name=?, paymentid=?, payment_desc =? WHERE paymentservice_id IN (?) ",
				new Object[] { paysers.getPaymentservice_id(), paysers.getPaymentservice_name(), paysers.getPaymentid(), paysers.getPayment_desc(), paysers.getPaymentservice_id()});
		return paysers;

	}

	public int active(String id) {
		return db.update("UPDATE paymentservices SET payment_active='1' WHERE paymentservice_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {

		return db.update("UPDATE paymentservices SET paymentservice_active='0' WHERE paymentservice_id IN (?) ", new Object[] { id });
	}

	public List<Paymentservices> findActive() {
		return db.query("SELECT * FROM paymentservices WHERE payment_active='1' ", new PaysersRowMapper());
	}

}
