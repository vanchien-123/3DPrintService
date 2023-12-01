package com.aptech.demo.models;

import java.sql.Date;

public class Cat {
	private String id;
	private String name;
	private String desc;
	private int active;
	private Date createdat;

	public Cat() {
		super();
	}

	public Cat(String id, String name, String desc, int active, Date createdat) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.active = active;
		this.createdat = createdat;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", desc=" + desc + ", active=" + active + ", createdat=" + createdat
				+ "]";
	}

}
