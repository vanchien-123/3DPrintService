package com.aptech.demo.models;

import java.util.Date;

public class Prodgroups {
	private String prodgroup_id;
	private String prodgroup_name;
	private String prodgroup_desc;
	private int prodgroup_active;
	private Date prodgroup_createdat;

	public Prodgroups() {
		super();
	}

	public Prodgroups(String prodgroup_id, String prodgroup_name, String prodgroup_desc, int prodgroup_active,
			Date prodgroup_createdat) {
		super();
		this.prodgroup_id = prodgroup_id;
		this.prodgroup_name = prodgroup_name;
		this.prodgroup_desc = prodgroup_desc;
		this.prodgroup_active = prodgroup_active;
		this.prodgroup_createdat = prodgroup_createdat;
	}

	public String getProdgroup_id() {
		return prodgroup_id;
	}

	public void setProdgroup_id(String prodgroup_id) {
		this.prodgroup_id = prodgroup_id;
	}

	public String getProdgroup_name() {
		return prodgroup_name;
	}

	public void setProdgroup_name(String prodgroup_name) {
		this.prodgroup_name = prodgroup_name;
	}

	public String getProdgroup_desc() {
		return prodgroup_desc;
	}

	public void setProdgroup_desc(String prodgroup_desc) {
		this.prodgroup_desc = prodgroup_desc;
	}

	public int getProdgroup_active() {
		return prodgroup_active;
	}

	public void setProdgroup_active(int prodgroup_active) {
		this.prodgroup_active = prodgroup_active;
	}

	public Date getProdgroup_createdat() {
		return prodgroup_createdat;
	}

	public void setProdgroup_createdat(Date prodgroup_createdat) {
		this.prodgroup_createdat = prodgroup_createdat;
	}

	@Override
	public String toString() {
		return "Prodgroups [prodgroup_id=" + prodgroup_id + ", prodgroup_name=" + prodgroup_name + ", prodgroup_desc="
				+ prodgroup_desc + ", prodgroup_active=" + prodgroup_active + ", prodgroup_createdat="
				+ prodgroup_createdat + "]";
	}

}
