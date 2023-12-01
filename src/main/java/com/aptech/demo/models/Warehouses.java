package com.aptech.demo.models;

import java.util.List;

public class Warehouses {
	private String warehouse_id;
	private String warehouse_name;
	private Integer warehouse_active;
	
	private List<Inventory> warehouseDetail;

	public Warehouses() {
		super();
	}

	public Warehouses(String warehouse_id, String warehouse_name, Integer warehouse_active,
			List<Inventory> warehouseDetail) {
		super();
		this.warehouse_id = warehouse_id;
		this.warehouse_name = warehouse_name;
		this.warehouse_active = warehouse_active;
		this.warehouseDetail = warehouseDetail;
	}

	public String getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(String warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public String getWarehouse_name() {
		return warehouse_name;
	}

	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
	}

	public Integer getWarehouse_active() {
		return warehouse_active;
	}

	public void setWarehouse_active(Integer warehouse_active) {
		this.warehouse_active = warehouse_active;
	}

	public List<Inventory> getWarehouseDetail() {
		return warehouseDetail;
	}

	public void setWarehouseDetail(List<Inventory> warehouseDetail) {
		this.warehouseDetail = warehouseDetail;
	}

	@Override
	public String toString() {
		return "Warehouses [warehouse_id=" + warehouse_id + ", warehouse_name=" + warehouse_name + ", warehouse_active="
				+ warehouse_active + ", warehouseDetail=" + warehouseDetail + ", getWarehouse_id()=" + getWarehouse_id()
				+ ", getWarehouse_name()=" + getWarehouse_name() + ", getWarehouse_active()=" + getWarehouse_active()
				+ ", getWarehouseDetail()=" + getWarehouseDetail() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
