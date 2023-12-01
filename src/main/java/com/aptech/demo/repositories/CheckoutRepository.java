package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Checkouts;

@Repository
public class CheckoutRepository {
	@Autowired
	JdbcTemplate db;

	class CheckoutsRowMapper implements RowMapper<Checkouts> {
		@Override
		public Checkouts mapRow(ResultSet rs, int rowNum) throws SQLException {
			Checkouts co = new Checkouts();
			co.setCheckout_id(rs.getString("checkout_id"));
			co.setOrderid(rs.getString("orderid"));
			co.setPaymentid(rs.getString("paymentid"));
			co.setPaymentserviceid(rs.getString("paymentserviceid"));
			co.setTransactid(rs.getString("transactid"));
			co.setCheckout_createdat(rs.getDate("checkout_createdat"));
			co.setCheckout_status(rs.getInt("checkout_status"));
			co.setTransactid1(rs.getString("transactid1"));
			return co;
		}

	}

	public List<Checkouts> findAll() {
		return db.query("select * from checkouts", new CheckoutsRowMapper());
	}

	public Checkouts findById(String id) {
		return db.queryForObject("SELECT * FROM checkouts WHERE checkout_id IN (?) ", new CheckoutsRowMapper(), new Object[] { id });
	}

	public Checkouts insert(Checkouts co) {
		db.update(
				"INSERT INTO checkouts( checkout_id, orderid, paymentid, paymentserviceid, transactid, checkout_createdat, checkout_status, transactid1) " + "values( ?, ?, ?, ?, ?, ?, 0, ?)",
				new Object[] { co.getCheckout_id(), co.getOrderid(), co.getPaymentid(), co.getPaymentserviceid(), co.getTransactid(), co.getCheckout_createdat(), co.getCheckout_status(), co.getTransactid1() });
		return co;

	}

	public Checkouts update(Checkouts co) {
		db.update("UPDATE checkouts SET checkout_id= ?, orderid= ?, paymentid= ?, paymentserviceid= ?, transactid= ?, checkout_createdat= ?, checkout_status= ?, transactid1= ? WHERE checkout_id IN (?) ",
				new Object[] { co.getCheckout_id(), co.getOrderid(), co.getPaymentid(), co.getPaymentserviceid(), co.getTransactid(), co.getCheckout_createdat(), co.getCheckout_status(), co.getTransactid1() });
		return co;
 
	}
	
	public int paidStatus(String id) {
		return db.update("UPDATE checkouts SET checkout_status='1' WHERE checkout_id IN (?) ", new Object[] { id });

	}
	
	public int codStatus(String id) {
		return db.update("UPDATE checkouts SET checkout_status='2' WHERE checkout_id IN (?) ", new Object[] { id });

	}

	public int pendingStatus(String id) {
		return db.update("UPDATE checkouts SET checkout_status='0' WHERE checkout_id IN (?) ", new Object[] { id });
	}
	
	public List<Checkouts> findAllPaid() {
		return db.query("SELECT * FROM checkouts WHERE checkout_status='1' ", new CheckoutsRowMapper());
	}
	

	public List<Checkouts> findAllCOD() {
		return db.query("SELECT * FROM checkouts WHERE checkout_status='2' ", new CheckoutsRowMapper());
	}
	

	public List<Checkouts> findAllPending() {
		return db.query("SELECT * FROM checkouts WHERE checkout_status='0' ", new CheckoutsRowMapper());
	}
}
