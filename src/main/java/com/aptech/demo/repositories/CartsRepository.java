package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Carts;



@Repository
public class CartsRepository {
	@Autowired
	JdbcTemplate db;
		
	class CartsRowMapper implements RowMapper<Carts> {
		@Override
		public Carts mapRow(ResultSet rs, int rowNum) throws SQLException {
			Carts c = new Carts();
			c.setCart_id(rs.getString("cart_id"));
			c.setBuyerid(rs.getString("buyerid"));
			c.setCart_createdat(rs.getDate("cart_createdat"));
			c.setCart_notes(rs.getString("cart_notes"));
			c.setCart_status(rs.getInt("cart_status"));
									
			return c;
		}
		
		

	}
	
	public List<Carts> findAll() {
		return db.query("SELECT * FROM carts", new CartsRowMapper());
	}	
	
	public int insert(Carts carts) {
		try {
			return db.update(
					"INSERT INTO carts( cartid, buyerid, cart_createdat, cart_notes, cart_status) values( ?, ?, ?, ?, ?)",
					new Object[] { carts.getCart_id(), carts.getBuyerid(), carts.getCart_createdat(), carts.getCart_notes(), carts.getCart_status()});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


}
