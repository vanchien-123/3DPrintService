package com.aptech.demo.models;

public class Printers {
	private String print_id;
	private String technolid;
	private String print_name;
	private String mfgerid;
	private String print_specs;
	private int print_active;
	
	
	public Printers() {
		super();
	}
	public Printers(String print_id, String technolid, String print_name, String mfgerid, String print_specs,
			int print_active) {
		super();
		this.print_id = print_id;
		this.technolid = technolid;
		this.print_name = print_name;
		this.mfgerid = mfgerid;
		this.print_specs = print_specs;
		this.print_active = print_active;
	}
	public String getPrint_id() {
		return print_id;
	}
	public void setPrint_id(String print_id) {
		this.print_id = print_id;
	}
	public String getTechnolid() {
		return technolid;
	}
	public void setTechnolid(String technolid) {
		this.technolid = technolid;
	}
	public String getPrint_name() {
		return print_name;
	}
	public void setPrint_name(String print_name) {
		this.print_name = print_name;
	}
	public String getMfgerid() {
		return mfgerid;
	}
	public void setMfgerid(String mfgerid) {
		this.mfgerid = mfgerid;
	}
	public String getPrint_specs() {
		return print_specs;
	}
	public void setPrint_specs(String print_specs) {
		this.print_specs = print_specs;
	}
	public int getPrint_active() {
		return print_active;
	}
	public void setPrint_active(int print_active) {
		this.print_active = print_active;
	}
	@Override
	public String toString() {
		return "Printers [print_id=" + print_id + ", technolid=" + technolid + ", print_name=" + print_name
				+ ", mfgerid=" + mfgerid + ", print_specs=" + print_specs + ", print_active=" + print_active + "]";
	}
	
	
	
}
