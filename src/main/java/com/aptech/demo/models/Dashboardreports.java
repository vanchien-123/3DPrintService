package com.aptech.demo.models;

import java.util.List;

public class Dashboardreports {
	private Integer user_number;
	private Integer user_number_active;
	private Integer admin_number;
	private Integer customer_number;
	private Integer customer_number_active;
	
	private Integer cat_number;
	private Integer cat_number_active;
	
	private Integer subcat_number;
	private Integer subcat_number_active;
	
	private Integer prodgroup_number;
	private Integer prodgroup_number_active;
	
	private Integer product_number;
	private Integer product_number_active;
	private Integer product_number_continuity;
	
	private Integer mfger_number;
	private Integer mfger_number_active;
	private Integer mfger_number_continuity;
	
	private Integer technol_number;
	private Integer technol_number_active;
	private Integer technol_number_continuity;
	
	private Integer printer_number;
	private Integer printer_number_active;
	private Integer printer_number_continuity;
	
	private Integer material_number;
	private Integer material_number_active;
	private Integer material_number_continuity;
	
	private Integer pstrategy_number;
	private Integer pstrategy_number_active;
	private Integer pstrategy_number_continuity;
		
	private Integer orderitem_number;
	private Integer orderitem_number_done;
	
	private Integer order_number;
	private Integer order_number_checkout;
	private Integer order_number_delivered;
	private Integer order_number_total;
	
	private List<User> listUsersDB;
	private List<Cat> listCatsDB;
	private List<Subcats> listSubcatsDB;
	private List<Prodgroups> listProdgroupsDB;
	private List<Technologies> listTechnolDB;
	private List<Manufacturers> listMfgersDB;
	private List<Printers> listPrintersDB;
	private List<Materials> listMaterialsDB;
	private List<Pstrategies> listPStrategiesDB;
	private List<Colors> listColorsDB;
	private List<Products> listProductsDB;
	private List<Orders> listOrdersDB;
	private List<Delivery> listDeliveryDB;
	private List<Inventory> listInventoryDB;
	private List<News> listNewsDB;
	
	public Dashboardreports() {
		super();
	}

	public Dashboardreports(Integer user_number, Integer user_number_active, Integer admin_number,
			Integer customer_number, Integer customer_number_active, Integer cat_number, Integer cat_number_active,
			Integer subcat_number, Integer subcat_number_active, Integer prodgroup_number,
			Integer prodgroup_number_active, Integer product_number, Integer product_number_active,
			Integer product_number_continuity, Integer mfger_number, Integer mfger_number_active,
			Integer mfger_number_continuity, Integer technol_number, Integer technol_number_active,
			Integer technol_number_continuity, Integer printer_number, Integer printer_number_active,
			Integer printer_number_continuity, Integer material_number, Integer material_number_active,
			Integer material_number_continuity, Integer pstrategy_number, Integer pstrategy_number_active,
			Integer pstrategy_number_continuity, Integer orderitem_number, Integer orderitem_number_done,
			Integer order_number, Integer order_number_checkout, Integer order_number_delivered,
			Integer order_number_total, List<User> listUsersDB, List<Cat> listCatsDB, List<Subcats> listSubcatsDB,
			List<Prodgroups> listProdgroupsDB, List<Technologies> listTechnolDB, List<Manufacturers> listMfgersDB,
			List<Printers> listPrintersDB, List<Materials> listMaterialsDB, List<Pstrategies> listPStrategiesDB,
			List<Colors> listColorsDB, List<Products> listProductsDB, List<Orders> listOrdersDB,
			List<Delivery> listDeliveryDB, List<Inventory> listInventoryDB, List<News> listNewsDB) {
		super();
		this.user_number = user_number;
		this.user_number_active = user_number_active;
		this.admin_number = admin_number;
		this.customer_number = customer_number;
		this.customer_number_active = customer_number_active;
		this.cat_number = cat_number;
		this.cat_number_active = cat_number_active;
		this.subcat_number = subcat_number;
		this.subcat_number_active = subcat_number_active;
		this.prodgroup_number = prodgroup_number;
		this.prodgroup_number_active = prodgroup_number_active;
		this.product_number = product_number;
		this.product_number_active = product_number_active;
		this.product_number_continuity = product_number_continuity;
		this.mfger_number = mfger_number;
		this.mfger_number_active = mfger_number_active;
		this.mfger_number_continuity = mfger_number_continuity;
		this.technol_number = technol_number;
		this.technol_number_active = technol_number_active;
		this.technol_number_continuity = technol_number_continuity;
		this.printer_number = printer_number;
		this.printer_number_active = printer_number_active;
		this.printer_number_continuity = printer_number_continuity;
		this.material_number = material_number;
		this.material_number_active = material_number_active;
		this.material_number_continuity = material_number_continuity;
		this.pstrategy_number = pstrategy_number;
		this.pstrategy_number_active = pstrategy_number_active;
		this.pstrategy_number_continuity = pstrategy_number_continuity;
		this.orderitem_number = orderitem_number;
		this.orderitem_number_done = orderitem_number_done;
		this.order_number = order_number;
		this.order_number_checkout = order_number_checkout;
		this.order_number_delivered = order_number_delivered;
		this.order_number_total = order_number_total;
		this.listUsersDB = listUsersDB;
		this.listCatsDB = listCatsDB;
		this.listSubcatsDB = listSubcatsDB;
		this.listProdgroupsDB = listProdgroupsDB;
		this.listTechnolDB = listTechnolDB;
		this.listMfgersDB = listMfgersDB;
		this.listPrintersDB = listPrintersDB;
		this.listMaterialsDB = listMaterialsDB;
		this.listPStrategiesDB = listPStrategiesDB;
		this.listColorsDB = listColorsDB;
		this.listProductsDB = listProductsDB;
		this.listOrdersDB = listOrdersDB;
		this.listDeliveryDB = listDeliveryDB;
		this.listInventoryDB = listInventoryDB;
		this.listNewsDB = listNewsDB;
	}

	public Integer getUser_number() {
		return user_number;
	}

	public void setUser_number(Integer user_number) {
		this.user_number = user_number;
	}

	public Integer getUser_number_active() {
		return user_number_active;
	}

	public void setUser_number_active(Integer user_number_active) {
		this.user_number_active = user_number_active;
	}

	public Integer getAdmin_number() {
		return admin_number;
	}

	public void setAdmin_number(Integer admin_number) {
		this.admin_number = admin_number;
	}

	public Integer getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(Integer customer_number) {
		this.customer_number = customer_number;
	}

	public Integer getCustomer_number_active() {
		return customer_number_active;
	}

	public void setCustomer_number_active(Integer customer_number_active) {
		this.customer_number_active = customer_number_active;
	}

	public Integer getCat_number() {
		return cat_number;
	}

	public void setCat_number(Integer cat_number) {
		this.cat_number = cat_number;
	}

	public Integer getCat_number_active() {
		return cat_number_active;
	}

	public void setCat_number_active(Integer cat_number_active) {
		this.cat_number_active = cat_number_active;
	}

	public Integer getSubcat_number() {
		return subcat_number;
	}

	public void setSubcat_number(Integer subcat_number) {
		this.subcat_number = subcat_number;
	}

	public Integer getSubcat_number_active() {
		return subcat_number_active;
	}

	public void setSubcat_number_active(Integer subcat_number_active) {
		this.subcat_number_active = subcat_number_active;
	}

	public Integer getProdgroup_number() {
		return prodgroup_number;
	}

	public void setProdgroup_number(Integer prodgroup_number) {
		this.prodgroup_number = prodgroup_number;
	}

	public Integer getProdgroup_number_active() {
		return prodgroup_number_active;
	}

	public void setProdgroup_number_active(Integer prodgroup_number_active) {
		this.prodgroup_number_active = prodgroup_number_active;
	}

	public Integer getProduct_number() {
		return product_number;
	}

	public void setProduct_number(Integer product_number) {
		this.product_number = product_number;
	}

	public Integer getProduct_number_active() {
		return product_number_active;
	}

	public void setProduct_number_active(Integer product_number_active) {
		this.product_number_active = product_number_active;
	}

	public Integer getProduct_number_continuity() {
		return product_number_continuity;
	}

	public void setProduct_number_continuity(Integer product_number_continuity) {
		this.product_number_continuity = product_number_continuity;
	}

	public Integer getMfger_number() {
		return mfger_number;
	}

	public void setMfger_number(Integer mfger_number) {
		this.mfger_number = mfger_number;
	}

	public Integer getMfger_number_active() {
		return mfger_number_active;
	}

	public void setMfger_number_active(Integer mfger_number_active) {
		this.mfger_number_active = mfger_number_active;
	}

	public Integer getMfger_number_continuity() {
		return mfger_number_continuity;
	}

	public void setMfger_number_continuity(Integer mfger_number_continuity) {
		this.mfger_number_continuity = mfger_number_continuity;
	}

	public Integer getTechnol_number() {
		return technol_number;
	}

	public void setTechnol_number(Integer technol_number) {
		this.technol_number = technol_number;
	}

	public Integer getTechnol_number_active() {
		return technol_number_active;
	}

	public void setTechnol_number_active(Integer technol_number_active) {
		this.technol_number_active = technol_number_active;
	}

	public Integer getTechnol_number_continuity() {
		return technol_number_continuity;
	}

	public void setTechnol_number_continuity(Integer technol_number_continuity) {
		this.technol_number_continuity = technol_number_continuity;
	}

	public Integer getPrinter_number() {
		return printer_number;
	}

	public void setPrinter_number(Integer printer_number) {
		this.printer_number = printer_number;
	}

	public Integer getPrinter_number_active() {
		return printer_number_active;
	}

	public void setPrinter_number_active(Integer printer_number_active) {
		this.printer_number_active = printer_number_active;
	}

	public Integer getPrinter_number_continuity() {
		return printer_number_continuity;
	}

	public void setPrinter_number_continuity(Integer printer_number_continuity) {
		this.printer_number_continuity = printer_number_continuity;
	}

	public Integer getMaterial_number() {
		return material_number;
	}

	public void setMaterial_number(Integer material_number) {
		this.material_number = material_number;
	}

	public Integer getMaterial_number_active() {
		return material_number_active;
	}

	public void setMaterial_number_active(Integer material_number_active) {
		this.material_number_active = material_number_active;
	}

	public Integer getMaterial_number_continuity() {
		return material_number_continuity;
	}

	public void setMaterial_number_continuity(Integer material_number_continuity) {
		this.material_number_continuity = material_number_continuity;
	}

	public Integer getPstrategy_number() {
		return pstrategy_number;
	}

	public void setPstrategy_number(Integer pstrategy_number) {
		this.pstrategy_number = pstrategy_number;
	}

	public Integer getPstrategy_number_active() {
		return pstrategy_number_active;
	}

	public void setPstrategy_number_active(Integer pstrategy_number_active) {
		this.pstrategy_number_active = pstrategy_number_active;
	}

	public Integer getPstrategy_number_continuity() {
		return pstrategy_number_continuity;
	}

	public void setPstrategy_number_continuity(Integer pstrategy_number_continuity) {
		this.pstrategy_number_continuity = pstrategy_number_continuity;
	}

	public Integer getOrderitem_number() {
		return orderitem_number;
	}

	public void setOrderitem_number(Integer orderitem_number) {
		this.orderitem_number = orderitem_number;
	}

	public Integer getOrderitem_number_done() {
		return orderitem_number_done;
	}

	public void setOrderitem_number_done(Integer orderitem_number_done) {
		this.orderitem_number_done = orderitem_number_done;
	}

	public Integer getOrder_number() {
		return order_number;
	}

	public void setOrder_number(Integer order_number) {
		this.order_number = order_number;
	}

	public Integer getOrder_number_checkout() {
		return order_number_checkout;
	}

	public void setOrder_number_checkout(Integer order_number_checkout) {
		this.order_number_checkout = order_number_checkout;
	}

	public Integer getOrder_number_delivered() {
		return order_number_delivered;
	}

	public void setOrder_number_delivered(Integer order_number_delivered) {
		this.order_number_delivered = order_number_delivered;
	}

	public Integer getOrder_number_total() {
		return order_number_total;
	}

	public void setOrder_number_total(Integer order_number_total) {
		this.order_number_total = order_number_total;
	}

	public List<User> getListUsersDB() {
		return listUsersDB;
	}

	public void setListUsersDB(List<User> listUsersDB) {
		this.listUsersDB = listUsersDB;
	}

	public List<Cat> getListCatsDB() {
		return listCatsDB;
	}

	public void setListCatsDB(List<Cat> listCatsDB) {
		this.listCatsDB = listCatsDB;
	}

	public List<Subcats> getListSubcatsDB() {
		return listSubcatsDB;
	}

	public void setListSubcatsDB(List<Subcats> listSubcatsDB) {
		this.listSubcatsDB = listSubcatsDB;
	}

	public List<Prodgroups> getListProdgroupsDB() {
		return listProdgroupsDB;
	}

	public void setListProdgroupsDB(List<Prodgroups> listProdgroupsDB) {
		this.listProdgroupsDB = listProdgroupsDB;
	}

	public List<Technologies> getListTechnolDB() {
		return listTechnolDB;
	}

	public void setListTechnolDB(List<Technologies> listTechnolDB) {
		this.listTechnolDB = listTechnolDB;
	}

	public List<Manufacturers> getListMfgersDB() {
		return listMfgersDB;
	}

	public void setListMfgersDB(List<Manufacturers> listMfgersDB) {
		this.listMfgersDB = listMfgersDB;
	}

	public List<Printers> getListPrintersDB() {
		return listPrintersDB;
	}

	public void setListPrintersDB(List<Printers> listPrintersDB) {
		this.listPrintersDB = listPrintersDB;
	}

	public List<Materials> getListMaterialsDB() {
		return listMaterialsDB;
	}

	public void setListMaterialsDB(List<Materials> listMaterialsDB) {
		this.listMaterialsDB = listMaterialsDB;
	}

	public List<Pstrategies> getListPStrategiesDB() {
		return listPStrategiesDB;
	}

	public void setListPStrategiesDB(List<Pstrategies> listPStrategiesDB) {
		this.listPStrategiesDB = listPStrategiesDB;
	}

	public List<Colors> getListColorsDB() {
		return listColorsDB;
	}

	public void setListColorsDB(List<Colors> listColorsDB) {
		this.listColorsDB = listColorsDB;
	}

	public List<Products> getListProductsDB() {
		return listProductsDB;
	}

	public void setListProductsDB(List<Products> listProductsDB) {
		this.listProductsDB = listProductsDB;
	}

	public List<Orders> getListOrdersDB() {
		return listOrdersDB;
	}

	public void setListOrdersDB(List<Orders> listOrdersDB) {
		this.listOrdersDB = listOrdersDB;
	}

	public List<Delivery> getListDeliveryDB() {
		return listDeliveryDB;
	}

	public void setListDeliveryDB(List<Delivery> listDeliveryDB) {
		this.listDeliveryDB = listDeliveryDB;
	}

	public List<Inventory> getListInventoryDB() {
		return listInventoryDB;
	}

	public void setListInventoryDB(List<Inventory> listInventoryDB) {
		this.listInventoryDB = listInventoryDB;
	}

	public List<News> getListNewsDB() {
		return listNewsDB;
	}

	public void setListNewsDB(List<News> listNewsDB) {
		this.listNewsDB = listNewsDB;
	}

	@Override
	public String toString() {
		return "Dashboardreports [user_number=" + user_number + ", user_number_active=" + user_number_active
				+ ", admin_number=" + admin_number + ", customer_number=" + customer_number
				+ ", customer_number_active=" + customer_number_active + ", cat_number=" + cat_number
				+ ", cat_number_active=" + cat_number_active + ", subcat_number=" + subcat_number
				+ ", subcat_number_active=" + subcat_number_active + ", prodgroup_number=" + prodgroup_number
				+ ", prodgroup_number_active=" + prodgroup_number_active + ", product_number=" + product_number
				+ ", product_number_active=" + product_number_active + ", product_number_continuity="
				+ product_number_continuity + ", mfger_number=" + mfger_number + ", mfger_number_active="
				+ mfger_number_active + ", mfger_number_continuity=" + mfger_number_continuity + ", technol_number="
				+ technol_number + ", technol_number_active=" + technol_number_active + ", technol_number_continuity="
				+ technol_number_continuity + ", printer_number=" + printer_number + ", printer_number_active="
				+ printer_number_active + ", printer_number_continuity=" + printer_number_continuity
				+ ", material_number=" + material_number + ", material_number_active=" + material_number_active
				+ ", material_number_continuity=" + material_number_continuity + ", pstrategy_number="
				+ pstrategy_number + ", pstrategy_number_active=" + pstrategy_number_active
				+ ", pstrategy_number_continuity=" + pstrategy_number_continuity + ", orderitem_number="
				+ orderitem_number + ", orderitem_number_done=" + orderitem_number_done + ", order_number="
				+ order_number + ", order_number_checkout=" + order_number_checkout + ", order_number_delivered="
				+ order_number_delivered + ", order_number_total=" + order_number_total + ", listUsersDB=" + listUsersDB
				+ ", listCatsDB=" + listCatsDB + ", listSubcatsDB=" + listSubcatsDB + ", listProdgroupsDB="
				+ listProdgroupsDB + ", listTechnolDB=" + listTechnolDB + ", listMfgersDB=" + listMfgersDB
				+ ", listPrintersDB=" + listPrintersDB + ", listMaterialsDB=" + listMaterialsDB + ", listPStrategiesDB="
				+ listPStrategiesDB + ", listColorsDB=" + listColorsDB + ", listProductsDB=" + listProductsDB
				+ ", listOrdersDB=" + listOrdersDB + ", listDeliveryDB=" + listDeliveryDB + ", listInventoryDB="
				+ listInventoryDB + ", listNewsDB=" + listNewsDB + ", getUser_number()=" + getUser_number()
				+ ", getUser_number_active()=" + getUser_number_active() + ", getAdmin_number()=" + getAdmin_number()
				+ ", getCustomer_number()=" + getCustomer_number() + ", getCustomer_number_active()="
				+ getCustomer_number_active() + ", getCat_number()=" + getCat_number() + ", getCat_number_active()="
				+ getCat_number_active() + ", getSubcat_number()=" + getSubcat_number() + ", getSubcat_number_active()="
				+ getSubcat_number_active() + ", getProdgroup_number()=" + getProdgroup_number()
				+ ", getProdgroup_number_active()=" + getProdgroup_number_active() + ", getProduct_number()="
				+ getProduct_number() + ", getProduct_number_active()=" + getProduct_number_active()
				+ ", getProduct_number_continuity()=" + getProduct_number_continuity() + ", getMfger_number()="
				+ getMfger_number() + ", getMfger_number_active()=" + getMfger_number_active()
				+ ", getMfger_number_continuity()=" + getMfger_number_continuity() + ", getTechnol_number()="
				+ getTechnol_number() + ", getTechnol_number_active()=" + getTechnol_number_active()
				+ ", getTechnol_number_continuity()=" + getTechnol_number_continuity() + ", getPrinter_number()="
				+ getPrinter_number() + ", getPrinter_number_active()=" + getPrinter_number_active()
				+ ", getPrinter_number_continuity()=" + getPrinter_number_continuity() + ", getMaterial_number()="
				+ getMaterial_number() + ", getMaterial_number_active()=" + getMaterial_number_active()
				+ ", getMaterial_number_continuity()=" + getMaterial_number_continuity() + ", getPstrategy_number()="
				+ getPstrategy_number() + ", getPstrategy_number_active()=" + getPstrategy_number_active()
				+ ", getPstrategy_number_continuity()=" + getPstrategy_number_continuity() + ", getOrderitem_number()="
				+ getOrderitem_number() + ", getOrderitem_number_done()=" + getOrderitem_number_done()
				+ ", getOrder_number()=" + getOrder_number() + ", getOrder_number_checkout()="
				+ getOrder_number_checkout() + ", getOrder_number_delivered()=" + getOrder_number_delivered()
				+ ", getOrder_number_total()=" + getOrder_number_total() + ", getListUsersDB()=" + getListUsersDB()
				+ ", getListCatsDB()=" + getListCatsDB() + ", getListSubcatsDB()=" + getListSubcatsDB()
				+ ", getListProdgroupsDB()=" + getListProdgroupsDB() + ", getListTechnolDB()=" + getListTechnolDB()
				+ ", getListMfgersDB()=" + getListMfgersDB() + ", getListPrintersDB()=" + getListPrintersDB()
				+ ", getListMaterialsDB()=" + getListMaterialsDB() + ", getListPStrategiesDB()="
				+ getListPStrategiesDB() + ", getListColorsDB()=" + getListColorsDB() + ", getListProductsDB()="
				+ getListProductsDB() + ", getListOrdersDB()=" + getListOrdersDB() + ", getListDeliveryDB()="
				+ getListDeliveryDB() + ", getListInventoryDB()=" + getListInventoryDB() + ", getListNewsDB()="
				+ getListNewsDB() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
