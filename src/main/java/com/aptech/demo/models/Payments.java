package com.aptech.demo.models;

public class Payments {
	private String payment_id;
	private String payment_name;
	private String payment_type;
	private int payment_active;
	public Payments() {
		super();
	}
	
	public Payments(String payment_id, String payment_name, String payment_type, int payment_active) {
		super();
		this.payment_id = payment_id;
		this.payment_name = payment_name;
		this.payment_type = payment_type;
		this.payment_active = payment_active;
	}
	
	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_name() {
		return payment_name;
	}

	public void setPayment_name(String payment_name) {
		this.payment_name = payment_name;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public int getPayment_active() {
		return payment_active;
	}

	public void setPayment_active(int payment_active) {
		this.payment_active = payment_active;
	}

	@Override
	public String toString() {
		return "Payments [payment_id=" + payment_id + ", payment_name=" + payment_name + ", payment_type="
				+ payment_type + ", payment_active=" + payment_active + "]";
	}
	
	
}
