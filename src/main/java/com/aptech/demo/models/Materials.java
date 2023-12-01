package com.aptech.demo.models;

public class Materials {
	private String material_id;
	private String material_name;
	private String colorid;
	private Float density;
	private Float material_uprice;
	private String mfgerid;
	private String material_desc;
	private int material_continuity;
	private int material_active;
	
	
	public Materials() {
		super();
	}
	public Materials(String material_id, String material_name, String colorid, Float density, Float material_uprice,
			String mfgerid, String material_desc, int material_continuity, int material_active) {
		super();
		this.material_id = material_id;
		this.material_name = material_name;
		this.colorid = colorid;
		this.density = density;
		this.material_uprice = material_uprice;
		this.mfgerid = mfgerid;
		this.material_desc = material_desc;
		this.material_continuity = material_continuity;
		this.material_active = material_active;
	}
	public String getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(String material_id) {
		this.material_id = material_id;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}
	public String getColorid() {
		return colorid;
	}
	public void setColorid(String colorid) {
		this.colorid = colorid;
	}
	public Float getDensity() {
		return density;
	}
	public void setDensity(Float density) {
		this.density = density;
	}
	public Float getMaterial_uprice() {
		return material_uprice;
	}
	public void setMaterial_uprice(Float material_uprice) {
		this.material_uprice = material_uprice;
	}
	public String getMfgerid() {
		return mfgerid;
	}
	public void setMfgerid(String mfgerid) {
		this.mfgerid = mfgerid;
	}
	public String getMaterial_desc() {
		return material_desc;
	}
	public void setMaterial_desc(String material_desc) {
		this.material_desc = material_desc;
	}
	public int getMaterial_continuity() {
		return material_continuity;
	}
	public void setMaterial_continuity(int material_continuity) {
		this.material_continuity = material_continuity;
	}
	public int getMaterial_active() {
		return material_active;
	}
	public void setMaterial_active(int material_active) {
		this.material_active = material_active;
	}
	@Override
	public String toString() {
		return "Materials [material_id=" + material_id + ", material_name=" + material_name + ", colorid=" + colorid
				+ ", density=" + density + ", material_uprice=" + material_uprice + ", mfgerid=" + mfgerid
				+ ", material_desc=" + material_desc + ", material_continuity=" + material_continuity
				+ ", material_active=" + material_active + "]";
	}
	
	
}
