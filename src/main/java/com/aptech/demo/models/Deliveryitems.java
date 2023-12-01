package com.aptech.demo.models;

import java.util.List;

public class Deliveryitems {
	private String deliveryitem_id;
	private String deliveryid;
	private String orderitem_id;
	private String inventoryid;
	private String deliveryitem_notes;
	private Integer inventoryitem_status;
	
	private List<Inventory> inventoryBOM;

	public Deliveryitems() {
		super();
	}

	public Deliveryitems(String deliveryitem_id, String deliveryid, String orderitem_id, String inventoryid,
			String deliveryitem_notes, Integer inventoryitem_status, List<Inventory> inventoryBOM) {
		super();
		this.deliveryitem_id = deliveryitem_id;
		this.deliveryid = deliveryid;
		this.orderitem_id = orderitem_id;
		this.inventoryid = inventoryid;
		this.deliveryitem_notes = deliveryitem_notes;
		this.inventoryitem_status = inventoryitem_status;
		this.inventoryBOM = inventoryBOM;
	}

	public String getDeliveryitem_id() {
		return deliveryitem_id;
	}

	public void setDeliveryitem_id(String deliveryitem_id) {
		this.deliveryitem_id = deliveryitem_id;
	}

	public String getDeliveryid() {
		return deliveryid;
	}

	public void setDeliveryid(String deliveryid) {
		this.deliveryid = deliveryid;
	}

	public String getOrderitem_id() {
		return orderitem_id;
	}

	public void setOrderitem_id(String orderitem_id) {
		this.orderitem_id = orderitem_id;
	}

	public String getInventoryid() {
		return inventoryid;
	}

	public void setInventoryid(String inventoryid) {
		this.inventoryid = inventoryid;
	}

	public String getDeliveryitem_notes() {
		return deliveryitem_notes;
	}

	public void setDeliveryitem_notes(String deliveryitem_notes) {
		this.deliveryitem_notes = deliveryitem_notes;
	}

	public Integer getInventoryitem_status() {
		return inventoryitem_status;
	}

	public void setInventoryitem_status(Integer inventoryitem_status) {
		this.inventoryitem_status = inventoryitem_status;
	}

	public List<Inventory> getInventoryBOM() {
		return inventoryBOM;
	}

	public void setInventoryBOM(List<Inventory> inventoryBOM) {
		this.inventoryBOM = inventoryBOM;
	}

	@Override
	public String toString() {
		return "Deliveryitems [deliveryitem_id=" + deliveryitem_id + ", deliveryid=" + deliveryid + ", orderitem_id="
				+ orderitem_id + ", inventoryid=" + inventoryid + ", deliveryitem_notes=" + deliveryitem_notes
				+ ", inventoryitem_status=" + inventoryitem_status + ", inventoryBOM=" + inventoryBOM
				+ ", getDeliveryitem_id()=" + getDeliveryitem_id() + ", getDeliveryid()=" + getDeliveryid()
				+ ", getOrderitem_id()=" + getOrderitem_id() + ", getInventoryid()=" + getInventoryid()
				+ ", getDeliveryitem_notes()=" + getDeliveryitem_notes() + ", getInventoryitem_status()="
				+ getInventoryitem_status() + ", getInventoryBOM()=" + getInventoryBOM() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}	

}
