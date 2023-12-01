package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Delivery;
import com.aptech.demo.models.Orders;
import com.aptech.demo.repositories.OrderRepository.OrdersRowMapper;

@Repository
public class DeliveryRepository {
	@Autowired
	JdbcTemplate db;

	class DeliveryRowMapper implements RowMapper<Delivery> {
		@Override
		public Delivery mapRow(ResultSet rs, int rowNum) throws SQLException {
			Delivery d = new Delivery();
			d.setDelivery_id(rs.getString("delivery_id"));
			d.setOrderid(rs.getString("orderid"));
			d.setDelivery_createdat(rs.getDate("delivery_createdat"));
			d.setDelivery_address(rs.getString("delivery_address"));
			d.setDelivery_notes(rs.getString("delivery_notes"));
			d.setDelivery_status(rs.getInt("delivery_status"));

			return d;
		}

	}

	public List<Delivery> findAll() {
		return db.query("SELECT * FROM deliveries ORDER BY delivery_createdat DESC", new DeliveryRowMapper());
	}

	public Delivery findById(String id) {
		try {
			return db.queryForObject(
					"SELECT * FROM delivery WHERE delivery_id IN (?)  ORDER BY delivery_createdat DESC",
					new DeliveryRowMapper(), new Object[] { id });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public Delivery findByOrderId(String id) {
		try {
			return db.queryForObject("SELECT * FROM delivery WHERE orderid IN (?)  ORDER BY delivery_createdat DESC",
					new DeliveryRowMapper(), new Object[] { id });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public Delivery insert(Delivery deli) {
		db.update(
				"INSERT INTO Delivery( delivery_id, orderid, delivery_createdat, delivery_notes, delivery_status) "
						+ "values( ?, ?, ?, ?, ?)",
				new Object[] { deli.getDelivery_id(), deli.getOrderid(), deli.getDelivery_createdat(),
						deli.getDelivery_notes(), deli.getDelivery_status() });
		return deli;

	}

	public Delivery update(Delivery deli) {
		db.update(
				"UPDATE delivery SET delivery_id, orderid, delivery_createdat, delivery_notes= ?, delivery_status= ? WHERE delivery_id IN (?) ",
				new Object[] { deli.getDelivery_id(), deli.getOrderid(), deli.getDelivery_createdat(),
						deli.getDelivery_notes(), deli.getDelivery_status() });
		return deli;
	}

	/*
	 * public List<Delivery> findPended() { try { return db.
	 * query("SELECT * FROM delivery WHERE delivery_status='1' ORDER BY delivery_createdat DESC"
	 * , new DeliveryRowMapper()); } catch (EmptyResultDataAccessException e) {
	 * return null; } }
	 * 
	 * public List<Delivery> findPacked() { try { return db.
	 * query("SELECT * FROM orders WHERE delivery_status='2' ORDER BY delivery_createdat DESC"
	 * , new DeliveryRowMapper()); } catch (EmptyResultDataAccessException e) {
	 * return null; }
	 * 
	 * }
	 * 
	 * public List<Delivery> findOnDelivery() { try { return db.
	 * query("SELECT * FROM orders WHERE delivery_status='3' ORDER BY delivery_createdat DESC"
	 * , new DeliveryRowMapper()); } catch (EmptyResultDataAccessException e) {
	 * return null; } }
	 * 
	 * public List<Delivery> findReceived() { try { return db.
	 * query("SELECT * FROM orders WHERE delivery_status='4' ORDER BY delivery_createdat DESC"
	 * , new DeliveryRowMapper()); } catch (EmptyResultDataAccessException e) {
	 * return null; } }
	 * 
	 * public List<Delivery> findReturned() { try { return db.
	 * query("SELECT * FROM delivery WHERE delivery_status='5' ORDER BY delivery_createdat DESC"
	 * , new DeliveryRowMapper()); } catch (EmptyResultDataAccessException e) {
	 * return null; } }
	 */

	/*
	 * public List<Delivery> findDuration(Date startdate, Date enddate) { try {
	 * return db.query("SELECT * FROM delivery WHERE delivery_createdat BETWEEN ='"
	 * + startdate + "' AND'" + enddate + "' ORDER BY delivery_createdat DESC", new
	 * DeliveryRowMapper()); } catch (EmptyResultDataAccessException e) { return
	 * null; } }
	 */
}
