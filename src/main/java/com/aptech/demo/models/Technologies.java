package com.aptech.demo.models;

public class Technologies {
	private String technol_id;
	private String technol_name;
	private String technol_desc;
	private String technol_notes;
	private int  technol_active;
	
	
	public Technologies() {
		super();
	}
	public Technologies(String technol_id, String technol_name, String technol_desc, String technol_notes,
			int technol_active) {
		super();
		this.technol_id = technol_id;
		this.technol_name = technol_name;
		this.technol_desc = technol_desc;
		this.technol_notes = technol_notes;
		this.technol_active = technol_active;
	}
	public String getTechnol_id() {
		return technol_id;
	}
	public void setTechnol_id(String technol_id) {
		this.technol_id = technol_id;
	}
	public String getTechnol_name() {
		return technol_name;
	}
	public void setTechnol_name(String technol_name) {
		this.technol_name = technol_name;
	}
	public String getTechnol_desc() {
		return technol_desc;
	}
	public void setTechnol_desc(String technol_desc) {
		this.technol_desc = technol_desc;
	}
	public String getTechnol_notes() {
		return technol_notes;
	}
	public void setTechnol_notes(String technol_notes) {
		this.technol_notes = technol_notes;
	}
	public int getTechnol_active() {
		return technol_active;
	}
	public void setTechnol_active(int technol_active) {
		this.technol_active = technol_active;
	}
	@Override
	public String toString() {
		return "Technologies [technol_id=" + technol_id + ", technol_name=" + technol_name + ", technol_desc="
				+ technol_desc + ", technol_notes=" + technol_notes + ", technol_active=" + technol_active + "]";
	}
	
}
