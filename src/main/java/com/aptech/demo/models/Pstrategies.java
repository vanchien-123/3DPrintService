package com.aptech.demo.models;

public class Pstrategies {
	private String pstrategy_id;
	private String pstrategy_name;
	private String matid;
	private String printid;
	private Float ufabprice;
	private String pstrategy_specs;
	private Float layerfineness;
	private int pstrategy_continuity;
	private int pstrategy_active;
	public Pstrategies() {
		super();
	}
	public Pstrategies(String pstrategy_id, String pstrategy_name, String matid, String printid, Float ufabprice,
			String pstrategy_specs, Float layerfineness, int pstrategy_continuity, int pstrategy_active) {
		super();
		this.pstrategy_id = pstrategy_id;
		this.pstrategy_name = pstrategy_name;
		this.matid = matid;
		this.printid = printid;
		this.ufabprice = ufabprice;
		this.pstrategy_specs = pstrategy_specs;
		this.layerfineness = layerfineness;
		this.pstrategy_continuity = pstrategy_continuity;
		this.pstrategy_active = pstrategy_active;
	}
	public String getPstrategy_id() {
		return pstrategy_id;
	}
	public void setPstrategy_id(String pstrategy_id) {
		this.pstrategy_id = pstrategy_id;
	}
	public String getPstrategy_name() {
		return pstrategy_name;
	}
	public void setPstrategy_name(String pstrategy_name) {
		this.pstrategy_name = pstrategy_name;
	}
	public String getMatid() {
		return matid;
	}
	public void setMatid(String matid) {
		this.matid = matid;
	}
	public String getPrintid() {
		return printid;
	}
	public void setPrintid(String printid) {
		this.printid = printid;
	}
	public Float getUfabprice() {
		return ufabprice;
	}
	public void setUfabprice(Float ufabprice) {
		this.ufabprice = ufabprice;
	}
	public String getPstrategy_specs() {
		return pstrategy_specs;
	}
	public void setPstrategy_specs(String pstrategy_specs) {
		this.pstrategy_specs = pstrategy_specs;
	}
	public Float getLayerfineness() {
		return layerfineness;
	}
	public void setLayerfineness(Float layerfineness) {
		this.layerfineness = layerfineness;
	}
	public int getPstrategy_continuity() {
		return pstrategy_continuity;
	}
	public void setPstrategy_continuity(int pstrategy_continuity) {
		this.pstrategy_continuity = pstrategy_continuity;
	}
	public int getPstrategy_active() {
		return pstrategy_active;
	}
	public void setPstrategy_active(int pstrategy_active) {
		this.pstrategy_active = pstrategy_active;
	}
	@Override
	public String toString() {
		return "Pstrategies [pstrategy_id=" + pstrategy_id + ", pstrategy_name=" + pstrategy_name + ", matid=" + matid
				+ ", printid=" + printid + ", ufabprice=" + ufabprice + ", pstrategy_specs=" + pstrategy_specs
				+ ", layerfineness=" + layerfineness + ", pstrategy_continuity=" + pstrategy_continuity
				+ ", pstrategy_active=" + pstrategy_active + "]";
	}
	
	
}
