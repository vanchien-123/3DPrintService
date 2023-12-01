package com.aptech.demo.models;

import java.util.Date;

public class Checkouts {
	private String checkout_id;
	private String orderid;
	private String paymentid;
	private String paymentserviceid;
	private String transactid;
	private Date checkout_createdat;
	private Integer checkout_status;
	private String transactid1;
	
	public Checkouts() {
		super();
	}

	public Checkouts(String checkout_id, String orderid, String paymentid, String paymentserviceid, String transactid,
			Date checkout_createdat, Integer checkout_status, String transactid1) {
		super();
		this.checkout_id = checkout_id;
		this.orderid = orderid;
		this.paymentid = paymentid;
		this.paymentserviceid = paymentserviceid;
		this.transactid = transactid;
		this.checkout_createdat = checkout_createdat;
		this.checkout_status = checkout_status;
		this.transactid1 = transactid1;
	}

	public String getCheckout_id() {
		return checkout_id;
	}

	public void setCheckout_id(String checkout_id) {
		this.checkout_id = checkout_id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getPaymentserviceid() {
		return paymentserviceid;
	}

	public void setPaymentserviceid(String paymentserviceid) {
		this.paymentserviceid = paymentserviceid;
	}

	public String getTransactid() {
		return transactid;
	}

	public void setTransactid(String transactid) {
		this.transactid = transactid;
	}

	public Date getCheckout_createdat() {
		return checkout_createdat;
	}

	public void setCheckout_createdat(Date checkout_createdat) {
		this.checkout_createdat = checkout_createdat;
	}

	public Integer getCheckout_status() {
		return checkout_status;
	}

	public void setCheckout_status(Integer checkout_status) {
		this.checkout_status = checkout_status;
	}

	public String getTransactid1() {
		return transactid1;
	}

	public void setTransactid1(String transactid1) {
		this.transactid1 = transactid1;
	}

	@Override
	public String toString() {
		return "Checkouts [checkout_id=" + checkout_id + ", orderid=" + orderid + ", paymentid=" + paymentid
				+ ", paymentserviceid=" + paymentserviceid + ", transactid=" + transactid + ", checkout_createdat="
				+ checkout_createdat + ", checkout_status=" + checkout_status + ", transactid1=" + transactid1
				+ ", getCheckout_id()=" + getCheckout_id() + ", getOrderid()=" + getOrderid() + ", getPaymentid()="
				+ getPaymentid() + ", getPaymentserviceid()=" + getPaymentserviceid() + ", getTransactid()="
				+ getTransactid() + ", getCheckout_createdat()=" + getCheckout_createdat() + ", getCheckout_status()="
				+ getCheckout_status() + ", getTransactid1()=" + getTransactid1() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
			

}
