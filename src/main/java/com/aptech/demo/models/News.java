package com.aptech.demo.models;

import java.sql.Date;

public class News {

	private String new_id;
	private String new_title;
	private String new_content;
	private String userid;
	private String new_type;
	private String new_poststt;
	private String objectid;
	private Date new_createdat;
	private int new_active;
	
	public News() {
		super();
	}

	public News(String new_id, String new_title, String new_content, String userid, String new_type, String new_poststt, String objectid,
			Date new_createdat, int new_active) {
		super();
		this.new_id = new_id;
		this.new_title = new_title;
		this.new_content = new_content;
		this.userid = userid;
		this.new_type = new_type;
		this.new_poststt = new_poststt;
		this.objectid = objectid;
		this.new_createdat = new_createdat;
		this.new_active = new_active;
	}

	public String getNew_id() {
		return new_id;
	}

	public void setNew_id(String new_id) {
		this.new_id = new_id;
	}

	public String getNew_title() {
		return new_title;
	}

	public void setNew_title(String new_title) {
		this.new_title = new_title;
	}

	public String getNew_content() {
		return new_content;
	}

	public void setNew_content(String new_content) {
		this.new_content = new_content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNew_type() {
		return new_type;
	}

	public void setNew_type(String new_type) {
		this.new_type = new_type;
	}
	
	public String getNew_poststt() {
		return new_poststt;
	}

	public void setNew_poststt(String new_poststt) {
		this.new_poststt = new_poststt;
	}

	public String getObjectid() {
		return objectid;
	}

	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	public Date getNew_createdat() {
		return new_createdat;
	}

	public void setNew_createdat(Date new_createdat) {
		this.new_createdat = new_createdat;
	}

	public int getNew_active() {
		return new_active;
	}

	public void setNew_active(int new_active) {
		this.new_active = new_active;
	}

	@Override
	public String toString() {
		return "News [new_id=" + new_id + ", new_title=" + new_title + ", new_content=" + new_content + ", userid="
				+ userid + ", new_type=" + new_type + ", objectid=" + objectid + ", new_createdat=" + new_createdat
				+ ", new_active=" + new_active + "]";
	}
	
	
	
}
