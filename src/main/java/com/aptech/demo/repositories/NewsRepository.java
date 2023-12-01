package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.News;
import com.aptech.demo.models.Subcats;
import com.aptech.demo.repositories.SubcatsRepository.SCatRowMapper;

@Repository
public class NewsRepository {

	@Autowired
	JdbcTemplate db;

	class NewRowMapper implements RowMapper<News> {
		@Override
		public News mapRow(ResultSet rs, int rowNum) throws SQLException {
			News news = new News();
			news.setNew_id(rs.getString("new_id"));
			news.setNew_title(rs.getString("new_title"));
			news.setNew_content(rs.getString("new_content"));
			news.setUserid(rs.getString("userid"));
			news.setNew_type(rs.getString("new_type"));
			news.setNew_poststt(rs.getString("new_poststt"));
			news.setObjectid(rs.getString("objectid"));
			news.setNew_createdat(rs.getDate("new_createdat"));
			news.setNew_active(rs.getInt("new_active"));
			
			return news;
		}
	}
	
	public List<News> findAll() {
		return db.query("SELECT * FROM news ORDER BY new_createdat DESC", new NewRowMapper());
	}
	
	public List<News> findReview() {
		return db.query("SELECT * FROM news Where new_type = 'reviews' ORDER BY new_createdat DESC", new NewRowMapper());
	}
	
	public List<News> findBlog() {
		return db.query("SELECT * FROM news Where new_type = 'blogs' ORDER BY new_createdat DESC", new NewRowMapper());
	}
	
	public List<News> findEvent() {
		return db.query("SELECT * FROM news Where new_type = 'events' ORDER BY new_createdat DESC", new NewRowMapper());
	}
	
	public List<News> findTestimonials() {
		return db.query("SELECT * FROM news Where new_type = 'thanks' ORDER BY new_createdat DESC", new NewRowMapper());
	}
	
	public List<News> findGuides() {
		return db.query("SELECT * FROM news Where new_type = 'guides' ORDER BY new_createdat DESC", new NewRowMapper());
	}
	
	public News findById(String id) {
		return db.queryForObject("SELECT * FROM news WHERE new_id IN (?) ", new NewRowMapper(),
				new Object[] { id });
	}

	public int deleteById(String id) {
		return db.update("DELETE FROM news WHERE new_id IN (?) ", new Object[] { id });
	}
	
	public News insert(News news) {
		db.update(
				"INSERT INTO news( new_id, new_title, new_content, userid, new_type, new_poststt, objectid, new_createdat, new_active) "
						+ "values( ?, ?, ?, ?, ?, ?,?, ?, ?)",
				new Object[] { news.getNew_id(), news.getNew_title(), news.getNew_content(),
						news.getUserid(),news.getNew_type(),news.getNew_poststt(),  news.getObjectid(),news.getNew_createdat(),news.getNew_active() });
		return news;

	}

	public News update(News news) {
		db.update("UPDATE news SET  new_title=?, new_content =?, userid =?, new_type=?, new_poststt=?, objectid=?, new_createdat=? WHERE new_id IN (?) ",
				new Object[] { news.getNew_title(), news.getNew_content(),
						news.getUserid(),news.getNew_type(),news.getNew_poststt(),  news.getObjectid(),news.getNew_createdat(),news.getNew_id()});
		return news;
	}
	
	public int active(String id) {
		return db.update("UPDATE news SET new_active='1' WHERE new_id IN (?) ", new Object[] { id });
	}

	public int inactive(String id) {

		return db.update("UPDATE news SET new_active='0' WHERE new_id IN (?) ", new Object[] { id });
	}
	
	
	
	
}
