package com.aptech.demo.models;

import java.util.Date;
import java.util.List;

public class Orders {
	private String order_id;
	private String buyerid;
	private Date order_createdat;
	private String order_notes;
	private Float total;
	private Integer order_status;
	
	private List<User> buyerdetail;
	private List<Orderitems> orderdetail;
	private List<Checkouts> ordercheckout;
	private List<Delivery> orderdelivery;
	
	public Orders() {
		super();
	}

	public Orders(String order_id, String buyerid, Date order_createdat, String order_notes, Float total,
			Integer order_status, List<User> buyerdetail, List<Orderitems> orderdetail, List<Checkouts> ordercheckout,
			List<Delivery> orderdelivery) {
		super();
		this.order_id = order_id;
		this.buyerid = buyerid;
		this.order_createdat = order_createdat;
		this.order_notes = order_notes;
		this.total = total;
		this.order_status = order_status;
		this.buyerdetail = buyerdetail;
		this.orderdetail = orderdetail;
		this.ordercheckout = ordercheckout;
		this.orderdelivery = orderdelivery;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}

	public Date getOrder_createdat() {
		return order_createdat;
	}

	public void setOrder_createdat(Date order_createdat) {
		this.order_createdat = order_createdat;
	}
	
	public String getOrder_notes() {
		return order_notes;
	}

	public void setOrder_notes(String order_notes) {
		this.order_notes = order_notes;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	
	public List<User> getBuyerdetail() {
		return buyerdetail;
	}

	public void setBuyerdetail(List<User> buyerdetail) {
		this.buyerdetail = buyerdetail;
	}

	public List<Orderitems> getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(List<Orderitems> orderdetail) {
		this.orderdetail = orderdetail;
	}

	public List<Checkouts> getOrdercheckout() {
		return ordercheckout;
	}

	public void setOrdercheckout(List<Checkouts> ordercheckout) {
		this.ordercheckout = ordercheckout;
	}

	public List<Delivery> getOrderdelivery() {
		return orderdelivery;
	}

	public void setOrderdelivery(List<Delivery> orderdelivery) {
		this.orderdelivery = orderdelivery;
	}

	

}
