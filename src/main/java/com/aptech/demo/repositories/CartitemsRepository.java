package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Cartitems;
import com.aptech.demo.models.Orderitems;
import com.aptech.demo.repositories.OrderItemRepository.OrderItemsRowMapper;

@Repository
public class CartitemsRepository {
	@Autowired
	JdbcTemplate db;
	
	class CartitemsRowMapper implements RowMapper<Cartitems> {
		@Override
		public Cartitems mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cartitems cartItem = new Cartitems();
			cartItem.setCartitem_id(rs.getString("cartitem_id"));
			cartItem.setCartid(rs.getString("cartid"));
			cartItem.setProductid(rs.getString("productid"));
			cartItem.setScaleup(rs.getFloat("scaleup"));
			cartItem.setQtt(rs.getInt("qtt"));
			cartItem.setPrintid(rs.getString("printid"));
			cartItem.setMatid(rs.getString("matid"));
			cartItem.setCartitem_status(rs.getInt("cartite_status"));
									
			return cartItem;
		}
	}

	public List<Cartitems> findAll() {
		return db.query("SELECT * FROM cartitems", new CartitemsRowMapper());
	}	
	
	public Cartitems insert(Cartitems cartitem) {
		 db.update(
				"INSERT INTO cartitems( cartitem_id, cartid, productid, scaleup, qtt, printid, matid, caritem_status, subtotal) values( ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { cartitem.getCartitem_id(), cartitem.getCartid(), cartitem.getProductid(), cartitem.getScaleup(), cartitem.getQtt(), cartitem.getPrintid(), cartitem.getMatid(), cartitem.getCartitem_status(), cartitem.getSubtotal() });
		
		return cartitem;
	}
	
	public Cartitems findById(String id) {
		return db.queryForObject("SELECT * FROM cartitems WHERE cartid IN (?) ", new CartitemsRowMapper(),
				new Object[] { id });
	}
	
	public Cartitems findByProId(String id) {
		return db.queryForObject("SELECT * from cartitems where productid =?", new CartitemsRowMapper(),
				new Object[] { id });
	}
	
	public int deleteById(String id) {
		return db.update("DELETE FROM cartitems WHERE cartitem_id IN (?) ", new Object[] { id });
	}
}
