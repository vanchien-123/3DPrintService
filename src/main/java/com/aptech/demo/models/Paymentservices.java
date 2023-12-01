package com.aptech.demo.models;

public class Paymentservices {
	private String paymentservice_id;
	private String paymentid;
	private String paymentservice_name;
	private String payment_desc;
	private int payment_active;
	
	
	public Paymentservices() {
		super();
	}
	
	public Paymentservices(String paymentservice_id, String paymentid, String paymentservice_name, String payment_desc,
			int payment_active) {
		super();
		this.paymentservice_id = paymentservice_id;
		this.paymentid = paymentid;
		this.paymentservice_name = paymentservice_name;
		this.payment_desc = payment_desc;
		this.payment_active = payment_active;
	}

	public String getPaymentservice_id() {
		return paymentservice_id;
	}
	public void setPaymentservice_id(String paymentservice_id) {
		this.paymentservice_id = paymentservice_id;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	public String getPaymentservice_name() {
		return paymentservice_name;
	}
	public void setPaymentservice_name(String paymentservice_name) {
		this.paymentservice_name = paymentservice_name;
	}
	public String getPayment_desc() {
		return payment_desc;
	}
	public void setPayment_desc(String payment_desc) {
		this.payment_desc = payment_desc;
	}
	public int getPayment_active() {
		return payment_active;
	}
	public void setPayment_active(int payment_active) {
		this.payment_active = payment_active;
	}
	@Override
	public String toString() {
		return "Paymentservices [paymentservice_id=" + paymentservice_id + ", paymentid=" + paymentid
				+ ", paymentservice_name=" + paymentservice_name + ", payment_desc=" + payment_desc
				+ ", payment_active=" + payment_active + "]";
	}
	
	
}
