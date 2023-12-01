package com.aptech.demo.models;

import java.util.Date;
import java.util.List;

public class Delivery extends Orders{

	private String delivery_id;
	private String orderid;
	private Date delivery_createdat;
	private String delivery_address;
	private String delivery_notes;
	private Integer delivery_status;
	
	private List<Deliveryitems> deliverydetail;

	public Delivery() {
		super();
	}

	public Delivery(String delivery_id, String orderid, Date delivery_createdat, String delivery_address,
			String delivery_notes, Integer delivery_status, List<Deliveryitems> deliverydetail) {
		super();
		this.delivery_id = delivery_id;
		this.orderid = orderid;
		this.delivery_createdat = delivery_createdat;
		this.delivery_address = delivery_address;
		this.delivery_notes = delivery_notes;
		this.delivery_status = delivery_status;
		this.deliverydetail = deliverydetail;
	}

	public String getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Date getDelivery_createdat() {
		return delivery_createdat;
	}

	public void setDelivery_createdat(Date delivery_createdat) {
		this.delivery_createdat = delivery_createdat;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public String getDelivery_notes() {
		return delivery_notes;
	}

	public void setDelivery_notes(String delivery_notes) {
		this.delivery_notes = delivery_notes;
	}

	public Integer getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(Integer delivery_status) {
		this.delivery_status = delivery_status;
	}

	public List<Deliveryitems> getDeliverydetail() {
		return deliverydetail;
	}

	public void setDeliverydetail(List<Deliveryitems> deliverydetail) {
		this.deliverydetail = deliverydetail;
	}

	@Override
	public String toString() {
		return "Delivery [delivery_id=" + delivery_id + ", orderid=" + orderid + ", delivery_createdat="
				+ delivery_createdat + ", delivery_address=" + delivery_address + ", delivery_notes=" + delivery_notes
				+ ", delivery_status=" + delivery_status + ", deliverydetail=" + deliverydetail + ", getDelivery_id()="
				+ getDelivery_id() + ", getOrderid()=" + getOrderid() + ", getDelivery_createdat()="
				+ getDelivery_createdat() + ", getDelivery_address()=" + getDelivery_address()
				+ ", getDelivery_notes()=" + getDelivery_notes() + ", getDelivery_status()=" + getDelivery_status()
				+ ", getDeliverydetail()=" + getDeliverydetail() + ", getOrder_id()=" + getOrder_id()
				+ ", getBuyerid()=" + getBuyerid() + ", getOrder_createdat()=" + getOrder_createdat()
				+ ", getOrder_notes()=" + getOrder_notes() + ", getTotal()=" + getTotal() + ", getOrder_status()="
				+ getOrder_status() + ", getOrderdetail()=" + getOrderdetail() + ", getOrdercheckout()="
				+ getOrdercheckout() + ", getOrderdelivery()=" + getOrderdelivery() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}	
	
}
