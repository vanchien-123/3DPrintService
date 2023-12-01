package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Printers;
import com.aptech.demo.models.Products;
import com.aptech.demo.repositories.PrintersRepository.PtRowMapper;

@Repository
public class ProductsRepository {
	@Autowired
	JdbcTemplate db;

	class ProductsRowMapper implements RowMapper<Products> {
		@Override
		public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
			Products p = new Products();
			p.setProduct_id(rs.getString("product_id"));
			p.setProdgroupid(rs.getString("prodgroupid"));
			p.setSubcatid(rs.getString("subcatid"));
			p.setMfgerid(rs.getString("mfgerid"));
			p.setProduct_name(rs.getString("product_name"));
			p.setProduct_desc(rs.getString("product_desc"));
			p.setSizeX(rs.getFloat("sizeX"));
			p.setSizeY(rs.getFloat("sizeY"));
			p.setSizeZ(rs.getFloat("sizeZ"));
			p.setVol(rs.getFloat("vol"));
			p.setWeight(rs.getFloat("weight"));
			p.setImg1(rs.getString("img1"));
			p.setImg2(rs.getString("img2"));
			p.setImg3(rs.getString("img3"));
			p.setStl(rs.getString("stl"));
			p.setProduct_continuity(rs.getInt("product_continuity"));
			p.setProduct_createdat(rs.getDate("product_createdat"));
			p.setProduct_active(rs.getInt("product_active"));
			
			return p;
		}

	}

	public List<Products> findAll() {
		return db.query("select * from products", new ProductsRowMapper());
	}

	public Products findById(String id) {
		return db.queryForObject("SELECT * FROM products WHERE product_id IN (?) ", new ProductsRowMapper(),
				new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM products WHERE product_id IN (?) ", new Object[] { id });
	}

	public Products insert(Products pro) {
		db.update(
				"INSERT INTO products( product_id, prodgroupid, subcatid, mfgerid, product_name, product_desc, sizeX, sizeY, sizeZ, vol, weight, img1, img2, img3, stl, product_continuity, product_createdat, product_active) "
						+ "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { pro.getProduct_id(), pro.getProdgroupid(), pro.getSubcatid(), pro.getMfgerid(),
						pro.getProduct_name(), pro.getProduct_desc(), pro.getSizeX(), pro.getSizeY(), pro.getSizeZ(),
						pro.getVol(), pro.getWeight(), pro.getImg1(), pro.getImg2(), pro.getImg3(),
						pro.getStl(), pro.getProduct_continuity(), pro.getProduct_createdat(),
						pro.getProduct_active() });
		return pro;

	}

	public Products update(Products pro) {
		db.update("UPDATE products SET product_id= ?, prodgroupid= ?, subcatid= ?, mfgerid= ?, product_name= ?, product_desc= ?, sizeX= ?, sizeY= ?, sizeZ= ?, vol= ?, weight= ?, img1= ?, img2= ?, img3= ?, stl= ? WHERE product_id IN (?) ",
				new Object[] {  pro.getProduct_id(), pro.getProdgroupid(), pro.getSubcatid(), pro.getMfgerid(),
						pro.getProduct_name(), pro.getProduct_desc(), pro.getSizeX(), pro.getSizeY(), pro.getSizeZ(),
						pro.getVol(), pro.getWeight(), pro.getImg1(), pro.getImg2(), pro.getImg3(),
						pro.getStl(),pro.getProduct_id() });
		return pro;

	}

	public int active(String id) {
		return db.update("UPDATE products SET product_active='1' WHERE product_id IN (?) ", new Object[] { id });

	}

	public int inactive(String id) {
		return db.update("UPDATE products SET product_active='0' WHERE product_id IN (?) ", new Object[] { id });
	}
	
	public int continuity(String id) {
		return db.update("UPDATE products SET product_continuity='1' WHERE product_id IN (?) ", new Object[] { id });

	}

	public int incontinuity(String id) {
		return db.update("UPDATE products SET product_continuity='0' WHERE product_id IN (?) ", new Object[] { id });
	}

	
	
	public List<Products> findActive() {
		return db.query("SELECT * FROM products WHERE product_active='1' ", new ProductsRowMapper());
	}

}
