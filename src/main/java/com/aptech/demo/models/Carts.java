package com.aptech.demo.models;

//import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carts {
	private String cart_id;
	private String buyerid;
	private Date cart_createdat;
	private String cart_notes;
	private Integer cart_status;
	
	private List<Cartitems> cartDetails;

	public Carts() {
		super();
	}

	public Carts(String cart_id, String buyerid, Date cart_createdat, String cart_notes, Integer cart_status,
			List<Cartitems> cartDetails) {
		super();
		this.cart_id = cart_id;
		this.buyerid = buyerid;
		this.cart_createdat = cart_createdat;
		this.cart_notes = cart_notes;
		this.cart_status = cart_status;
		this.cartDetails = cartDetails;
	}

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}

	public Date getCart_createdat() {
		return cart_createdat;
	}

	public void setCart_createdat(Date cart_createdat) {
		this.cart_createdat = cart_createdat;
	}

	public String getCart_notes() {
		return cart_notes;
	}

	public void setCart_notes(String cart_notes) {
		this.cart_notes = cart_notes;
	}

	public Integer getCart_status() {
		return cart_status;
	}

	public void setCart_status(Integer cart_status) {
		this.cart_status = cart_status;
	}

	public List<Cartitems> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<Cartitems> cartDetails) {
		this.cartDetails = cartDetails;
	}
	
	@Override
	public String toString() {
		return "Carts [cart_id=" + cart_id + ", buyerid=" + buyerid + ", cart_createdat=" + cart_createdat
				+ ", cart_notes=" + cart_notes + ", cart_status=" + cart_status + ", cartDetails=" + cartDetails
				+ ", getCart_id()=" + getCart_id() + ", getBuyerid()=" + getBuyerid() + ", getCart_createdat()="
				+ getCart_createdat() + ", getCart_notes()=" + getCart_notes() + ", getCart_status()="
				+ getCart_status() + ", getCartDetails()=" + getCartDetails() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
