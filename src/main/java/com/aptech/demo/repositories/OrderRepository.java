package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Orders;

@Repository
public class OrderRepository {
	@Autowired
	JdbcTemplate db;

	class OrdersRowMapper implements RowMapper<Orders> {
		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
			Orders o = new Orders();
			o.setOrder_id(rs.getString("order_id"));
			o.setBuyerid(rs.getString("buyerid"));
			o.setOrder_createdat(rs.getDate("order_createdat"));
			o.setOrder_notes(rs.getString("order_notes"));
			o.setTotal(rs.getFloat("total"));
			o.setOrder_status(rs.getInt("order_status"));
						
			return o;
		}

	}

	public List<Orders> findAll() {
		return db.query("SELECT * FROM orders ORDER BY order_createdat DESC", new OrdersRowMapper());
	}

	public Orders findById(String id) {
		return db.queryForObject("SELECT * FROM orders WHERE order_id IN (?) ", new OrdersRowMapper(),
				new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM orders WHERE order_id IN (?) ", new Object[] { id });
	}

	public Orders insert(Orders ord) {
		db.update(
				"INSERT INTO orders( order_id, buyerid, order_createdat, order_notes, total, order_active) "
						+ "values( ?, ?, ?, ?, ?, ?)",
				new Object[] { ord.getOrder_id(), ord.getBuyerid(), ord.getOrder_createdat(),
						ord.getOrder_notes(), ord.getTotal(), ord.getOrder_status() });
		return ord;

	}

	public Orders update(Orders ord) {
		db.update("UPDATE orders SET order_id= ?, buyerid= ?, order_createdat= ?, order_notes= ?, total= ?, order_active= ? WHERE order_id IN (?) ",
				new Object[] { ord.getOrder_id(), ord.getBuyerid(), ord.getOrder_createdat(),
						ord.getOrder_notes(), ord.getTotal(), ord.getOrder_status() });
		return ord;

	}

	public int updatestt(String id) {
		return db.update("UPDATE orders SET order_status= ? WHERE order_id IN (?) ", new Object[] { id });

	}

	public List<Orders> findOrdered() {
		return db.query("SELECT * FROM orders WHERE order_status='1'  ORDER BY order_createdat DESC", new OrdersRowMapper());
	}
	
	public List<Orders> findPaid() {
		return db.query("SELECT * FROM orders WHERE order_status='2'  ORDER BY order_createdat DESC", new OrdersRowMapper());
	}
	
	public List<Orders> findPrinted() {
		return db.query("SELECT * FROM orders WHERE order_status='3'  ORDER BY order_createdat DESC", new OrdersRowMapper());
	}
	
	public List<Orders> findDelivered() {
		return db.query("SELECT * FROM orders WHERE order_status='4'  ORDER BY order_createdat DESC", new OrdersRowMapper());
	}
	
	public List<Orders> findReturned() {
		return db.query("SELECT * FROM orders WHERE order_status='5'  ORDER BY order_createdat DESC", new OrdersRowMapper());
	}
	
	public List<Orders> findDuration(Date startdate, Date enddate) {
		return db.query("SELECT * FROM orders WHERE order_createdat BETWEEN ='"+startdate+"' AND'"+enddate+"'  ORDER BY order_createdat DESC  ", new OrdersRowMapper());
	}
	
	public List<Orders> findTotalRange(Float startval, Float endval) {
		return db.query("SELECT * FROM orders WHERE total BETWEEN ='"+startval+"' AND'"+endval+"'  ORDER BY total DESC, order_createdat DESC  ", new OrdersRowMapper());
	}	

}