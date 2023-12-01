package com.aptech.demo.models;

import java.util.Date;

public class Subcats {
	private String subcat_id;
	private String subcat_name;
	private String catid;
	private String subcat_desc;
	private Date subcat_createdat;
	private int subcat_active;

	public Subcats() {
		super();
	}

	public Subcats(String subcat_id, String subcat_name, String catid, String subcat_desc, Date subcat_createdat,
			int subcat_active) {
		super();
		this.subcat_id = subcat_id;
		this.subcat_name = subcat_name;
		this.catid = catid;
		this.subcat_desc = subcat_desc;
		this.subcat_createdat = subcat_createdat;
		this.subcat_active = subcat_active;
	}

	public String getSubcat_id() {
		return subcat_id;
	}

	public void setSubcat_id(String subcat_id) {
		this.subcat_id = subcat_id;
	}

	public String getSubcat_name() {
		return subcat_name;
	}

	public void setSubcat_name(String subcat_name) {
		this.subcat_name = subcat_name;
	}

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getSubcat_desc() {
		return subcat_desc;
	}

	public void setSubcat_desc(String subcat_desc) {
		this.subcat_desc = subcat_desc;
	}

	public Date getSubcat_createdat() {
		return subcat_createdat;
	}

	public void setSubcat_createdat(Date subcat_createdat) {
		this.subcat_createdat = subcat_createdat;
	}

	public int getSubcat_active() {
		return subcat_active;
	}

	public void setSubcat_active(int subcat_active) {
		this.subcat_active = subcat_active;
	}

	@Override
	public String toString() {  
		return "Subcats [subcat_id=" + subcat_id + ", subcat_name=" + subcat_name + ", catid=" + catid
				+ ", subcat_desc=" + subcat_desc + ", subcat_createdat=" + subcat_createdat + ", subcat_active="
				+ subcat_active + "]";
	}

}
