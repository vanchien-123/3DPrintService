package com.aptech.demo.models;

public class Orderitems {
	private String orderitem_id;
	private String orderid;
	private String productid;
	private String caritemid;
	private Float subtotal;
	private Integer urgestt;
	private String orderitem_notes;
	
	public Orderitems() {
		super();
	}

	public Orderitems(String orderitem_id, String orderid, String productid, String caritemid, Float subtotal,
			Integer urgestt, String orderitem_notes) {
		super();
		this.orderitem_id = orderitem_id;
		this.orderid = orderid;
		this.productid = productid;
		this.caritemid = caritemid;
		this.subtotal = subtotal;
		this.urgestt = urgestt;
		this.orderitem_notes = orderitem_notes;
	}

	public String getOrderitem_id() {
		return orderitem_id;
	}

	public void setOrderitem_id(String orderitem_id) {
		this.orderitem_id = orderitem_id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getCaritemid() {
		return caritemid;
	}

	public void setCaritemid(String caritemid) {
		this.caritemid = caritemid;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getUrgestt() {
		return urgestt;
	}

	public void setUrgestt(Integer urgestt) {
		this.urgestt = urgestt;
	}

	public String getOrderitem_notes() {
		return orderitem_notes;
	}

	public void setOrderitem_notes(String orderitem_notes) {
		this.orderitem_notes = orderitem_notes;
	}

	@Override
	public String toString() {
		return "Orderitems [orderitem_id=" + orderitem_id + ", orderid=" + orderid + ", productid=" + productid
				+ ", caritemid=" + caritemid + ", subtotal=" + subtotal + ", urgestt=" + urgestt + ", orderitem_notes="
				+ orderitem_notes + ", getOrderitem_id()=" + getOrderitem_id() + ", getOrderid()=" + getOrderid()
				+ ", getProductid()=" + getProductid() + ", getCaritemid()=" + getCaritemid() + ", getSubtotal()="
				+ getSubtotal() + ", getUrgestt()=" + getUrgestt() + ", getOrderitem_notes()=" + getOrderitem_notes()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
