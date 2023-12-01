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
import com.aptech.demo.models.Deliveryitems;
import com.aptech.demo.repositories.DeliveryRepository.DeliveryRowMapper;

@Repository
public class DeliveryItemRepository {
	@Autowired
	JdbcTemplate db;

	class DeliveryItemRowMapper implements RowMapper<Deliveryitems> {
		@Override
		public Deliveryitems mapRow(ResultSet rs, int rowNum) throws SQLException {
			Deliveryitems di = new Deliveryitems();
			di.setDeliveryitem_id(rs.getString("deliveryitem_id"));
			di.setDeliveryid(rs.getString("deliveryid"));
			di.setOrderitem_id(rs.getString("orderitem_id"));
			di.setInventoryid(rs.getString("inventoyid"));
			di.setDeliveryitem_notes(rs.getString("deliveryitem_notes"));
			di.setInventoryitem_status(rs.getInt("inventoryitem_status"));

			return di;
		}

	}

	public List<Deliveryitems> findAll() {
		return db.query("SELECT * FROM deliveryitems ORDER BY deliveryitem_id ASC", new DeliveryItemRowMapper());
	}

	public Deliveryitems findById(String id) {
		try {
		return db.queryForObject("SELECT * FROM deliveryitems WHERE deliveryitem_id IN (?) ",
				new DeliveryItemRowMapper(), new Object[] { id });
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Deliveryitems findByDeliveryId(String id) {
		try {
		return db.queryForObject("SELECT * FROM deliveryitems WHERE deliveryid IN (?) ORDER BY deliveryitem_id ASC ",
				new DeliveryItemRowMapper(), new Object[] { id });
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Deliveryitems findByOrderId(String id) {
		try {
		return db.queryForObject("SELECT * FROM deliveryitems WHERE orderid IN (?) ORDER BY deliveryitem_id ASC ",
				new DeliveryItemRowMapper(), new Object[] { id });
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Deliveryitems insert(Deliveryitems di) {
		db.update(
				"INSERT INTO Deliveryitems( deliveryitem_id, deliveryid, orderitem_id, inventoryid, deliveryitem_notes, inventory_status) "
						+ "values( ?, ?, ?, ?, ?, ?)",
				new Object[] { di.getDeliveryitem_id(), di.getDeliveryid(), di.getOrderitem_id(),
						di.getDeliveryitem_notes(), di.getInventoryitem_status() });
		return di;

	}

	public Deliveryitems update(Deliveryitems di) {
		db.update(
				"UPDATE delivery SET deliveryitem_id, deliveryid, orderitem_id, inventoryid, deliveryitem_notes = ?, inventory_status = ?"
						+ " WHERE delivery_id IN (?) ",
				new Object[] { di.getDeliveryitem_id(), di.getDeliveryid(), di.getOrderitem_id(),
						di.getDeliveryitem_notes(), di.getInventoryitem_status() });
		return di;

	}
//
//	public List<Delivery> findPended() {
//		return db.query("SELECT * FROM delivery WHERE delivery_status='1' ", new DeliveryRowMapper());
//	}
//	
//	public List<Delivery> findPacked() {
//		return db.query("SELECT * FROM orders WHERE delivery_status='2' ", new DeliveryRowMapper());
//	}
//	
//	public List<Delivery> findOnDelivery() {
//		return db.query("SELECT * FROM orders WHERE delivery_status='3' ", new DeliveryRowMapper());
//	}
//	
//	public List<Delivery> findReceived() {
//		return db.query("SELECT * FROM orders WHERE delivery_status='4' ", new DeliveryRowMapper());
//	}
//	
//	public List<Delivery> findReturned() {
//		return db.query("SELECT * FROM delivery WHERE delivery_status='5' ", new DeliveryRowMapper());
//	}
//	
//	public List<Delivery> findDuration(Date startdate, Date enddate) {
//		return db.query("SELECT * FROM delivery WHERE delivery_createdat BETWEEN ='"+startdate+"' AND'"+enddate+"' ORDER BY  ", new DeliveryRowMapper());
//	}	

}
