package com.aptech.demo.models;

import java.util.List;

public class Cartitems {
	private String cartitem_id;
	private String cartid;
	private String productid;
	private Float scaleup;
	private Integer qtt;
	private String printid;	//pstrategies in meaning
	private String matid;
	private Integer cartitem_status;
	private Float subtotal;
	
	private List<Pstrategies> optPstrategies;
	private List<Pstrategies> optMaterials;
	
	public Cartitems() {
		super();
	}

	public Cartitems(String cartitem_id, String cartid, String productid, Float scaleup, Integer qtt, String printid,
			String matid, Integer cartitem_status, List<Pstrategies> optPstrategies, List<Pstrategies> optMaterials, Float subtotal) {
		super();
		this.cartitem_id = cartitem_id;
		this.cartid = cartid;
		this.productid = productid;
		this.scaleup = scaleup;
		this.qtt = qtt;
		this.printid = printid;
		this.matid = matid;
		this.cartitem_status = cartitem_status;
		this.optPstrategies = optPstrategies;
		this.optMaterials = optMaterials;
		this.subtotal = subtotal;
	}

	public String getCartitem_id() {
		return cartitem_id;
	}

	public void setCartitem_id(String cartitem_id) {
		this.cartitem_id = cartitem_id;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public Float getScaleup() {
		return scaleup;
	}

	public void setScaleup(Float scaleup) {
		this.scaleup = scaleup;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = scaleup;
	}

	public Integer getQtt() {
		return qtt;
	}

	public void setQtt(Integer qtt) {
		this.qtt = qtt;
	}

	public String getPrintid() {
		return printid;
	}

	public void setPrintid(String printid) {
		this.printid = printid;
	}

	public String getMatid() {
		return matid;
	}

	public void setMatid(String matid) {
		this.matid = matid;
	}

	public Integer getCartitem_status() {
		return cartitem_status;
	}

	public void setCartitem_status(Integer cartitem_status) {
		this.cartitem_status = cartitem_status;
	}

	public List<Pstrategies> getOptPstrategies() {
		return optPstrategies;
	}

	public void setOptPstrategies(List<Pstrategies> optPstrategies) {
		this.optPstrategies = optPstrategies;
	}

	public List<Pstrategies> getOptMaterials() {
		return optMaterials;
	}

	public void setOptMaterials(List<Pstrategies> optMaterials) {
		this.optMaterials = optMaterials;
	}

	@Override
	public String toString() {
		return "Cartitems [cartitem_id=" + cartitem_id + ", cartid=" + cartid + ", productid=" + productid
				+ ", scaleup=" + scaleup + ", qtt=" + qtt + ", printid=" + printid + ", matid=" + matid
				+ ", cartitem_status=" + cartitem_status + ", optPstrategies=" + optPstrategies + ", optMaterials="
				+ optMaterials + ", getCartitem_id()=" + getCartitem_id() + ", getCartid()=" + getCartid()
				+ ", getProductid()=" + getProductid() + ", getScaleup()=" + getScaleup() + ", getQtt()=" + getQtt()
				+ ", getPrintid()=" + getPrintid() + ", getMatid()=" + getMatid() + ", getCartitem_status()="
				+ getCartitem_status() + ", getOptPstrategies()=" + getOptPstrategies() + ", getOptMaterials()="
				+ getOptMaterials() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
