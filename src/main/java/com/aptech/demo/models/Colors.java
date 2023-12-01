package com.aptech.demo.models;

public class Colors {
	private String color_id;
	private String color_name;
	private String color_hex;
	private String color_img;
	private int color_active;
	
	public Colors() {
		super();
	}
	
	public Colors(String color_id, String color_name, String color_hex, String color_img, int color_active) {
		super();
		this.color_id = color_id;
		this.color_name = color_name;
		this.color_hex = color_hex;
		this.color_img = color_img;
		this.color_active = color_active;
	}
	public String getColor_id() {
		return color_id;
	}
	public void setColor_id(String color_id) {
		this.color_id = color_id;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	public String getColor_hex() {
		return color_hex;
	}
	public void setColor_hex(String color_hex) {
		this.color_hex = color_hex;
	}
	public String getColor_img() {
		return color_img;
	}
	public void setColor_img(String color_img) {
		this.color_img = color_img;
	}
	public int getColor_active() {
		return color_active;
	}
	public void setColor_active(int color_active) {
		this.color_active = color_active;
	}
	@Override
	public String toString() {
		return "Colors [color_id=" + color_id + ", color_name=" + color_name + ", color_hex=" + color_hex
				+ ", color_img=" + color_img + ", color_active=" + color_active + "]";
	}
	
	
}
