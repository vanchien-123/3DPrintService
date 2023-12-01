package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Orderitems;
import com.aptech.demo.models.Orders;
import com.aptech.demo.repositories.OrderRepository.OrdersRowMapper;

@Repository
public class OrderItemRepository {
	@Autowired
	JdbcTemplate db;

	class OrderItemsRowMapper implements RowMapper<Orderitems> {
		@Override
		public Orderitems mapRow(ResultSet rs, int rowNum) throws SQLException {
			Orderitems oi = new Orderitems();
			oi.setOrderitem_id(rs.getString("orderitem_id"));
			oi.setOrderid(rs.getString("orderid"));
			oi.setProductid(rs.getString("productid"));
			oi.setCaritemid(rs.getString("caritemid"));
			oi.setSubtotal(rs.getFloat("subtotal"));
			oi.setUrgestt(rs.getInt("urgestt"));
			oi.setOrderitem_notes(rs.getString("orderitem_notes"));
									
			return oi;
		}

	}

	public List<Orderitems> findAll() {
		return db.query("SELECT * FROM orderitems ORDER BY orderid DESC, orderitem_id ASC, urgestt DESC", new OrderItemsRowMapper());
	}	
	
	public Orderitems findById(String id) {
		try {
			return db.queryForObject("SELECT * FROM orderitems WHERE orderitem_id IN (?)", new OrderItemsRowMapper(),new Object[] { id });
			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
						
	}
	
	public Orderitems findByOrderId(String id) {
		try {
			return db.queryForObject("SELECT * FROM orderitems WHERE orderid IN (?) ORDER BY orderitem_id ASC", new OrderItemsRowMapper(),
					new Object[] { id });
			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}


}