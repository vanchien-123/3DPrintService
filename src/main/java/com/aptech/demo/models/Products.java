package com.aptech.demo.models;

import java.util.Date;

public class Products {
	private String product_id;
	private String prodgroupid;
	private String subcatid;
	private String mfgerid;
	private String product_name;
	private String product_desc;
	private Float sizeX;
	private Float sizeY;
	private Float sizeZ;
	private Float vol;
	private Float weight;
	private String img1;
	private String img2;
	private String img3;
	private String stl;
	private int product_continuity;
	private Date product_createdat;
	private int product_active;
	
	public Products() {
		super();
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProdgroupid() {
		return prodgroupid;
	}

	public void setProdgroupid(String prodgroupid) {
		this.prodgroupid = prodgroupid;
	}

	public String getSubcatid() {
		return subcatid;
	}

	public void setSubcatid(String subcatid) {
		this.subcatid = subcatid;
	}

	public String getMfgerid() {
		return mfgerid;
	}

	public void setMfgerid(String mfgerid) {
		this.mfgerid = mfgerid;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public Float getSizeX() {
		return sizeX;
	}

	public void setSizeX(Float sizeX) {
		this.sizeX = sizeX;
	}

	public Float getSizeY() {
		return sizeY;
	}

	public void setSizeY(Float sizeY) {
		this.sizeY = sizeY;
	}

	public Float getSizeZ() {
		return sizeZ;
	}

	public void setSizeZ(Float sizeZ) {
		this.sizeZ = sizeZ;
	}

	public Float getVol() {
		return vol;
	}

	public void setVol(Float vol) {
		this.vol = vol;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getStl() {
		return stl;
	}

	public void setStl(String stl) {
		this.stl = stl;
	}

	public int getProduct_continuity() {
		return product_continuity;
	}

	public void setProduct_continuity(int product_continuity) {
		this.product_continuity = product_continuity;
	}

	public Date getProduct_createdat() {
		return product_createdat;
	}

	public void setProduct_createdat(Date product_createdat) {
		this.product_createdat = product_createdat;
	}

	public int getProduct_active() {
		return product_active;
	}

	public void setProduct_active(int product_active) {
		this.product_active = product_active;
	}

	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", prodgroupid=" + prodgroupid + ", subcatid=" + subcatid
				+ ", mfgerid=" + mfgerid + ", product_name=" + product_name + ", product_desc=" + product_desc
				+ ", sizeX=" + sizeX + ", sizeY=" + sizeY + ", sizeZ=" + sizeZ + ", vol=" + vol + ", weight=" + weight
				+ ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", stl=" + stl + ", product_continuity="
				+ product_continuity + ", product_createdat=" + product_createdat + ", product_active=" + product_active
				+ "]";
	}
	
	
	
}
