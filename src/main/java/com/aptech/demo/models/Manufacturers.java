package com.aptech.demo.models;

public class Manufacturers {
	private String mfger_id;
	private String mfger_name;
	private String mfger_desc;
	private String mfger_website;
	private int mfger_active;

	public Manufacturers() {
		super();
	}

	public Manufacturers(String mfger_id, String mfger_name, String mfger_desc, String mfger_website,
			int mfger_active) {
		super();
		this.mfger_id = mfger_id;
		this.mfger_name = mfger_name;
		this.mfger_desc = mfger_desc;
		this.mfger_website = mfger_website;
		this.mfger_active = mfger_active;
	}

	public String getMfger_id() {
		return mfger_id;
	}

	public void setMfger_id(String mfger_id) {
		this.mfger_id = mfger_id;
	}

	public String getMfger_name() {
		return mfger_name;
	}

	public void setMfger_name(String mfger_name) {
		this.mfger_name = mfger_name;
	}

	public String getMfger_desc() {
		return mfger_desc;
	}

	public void setMfger_desc(String mfger_desc) {
		this.mfger_desc = mfger_desc;
	}

	public String getMfger_website() {
		return mfger_website;
	}

	public void setMfger_website(String mfger_website) {
		this.mfger_website = mfger_website;
	}

	public int getMfger_active() {
		return mfger_active;
	}

	public void setMfger_active(int mfger_active) {
		this.mfger_active = mfger_active;
	}

	@Override
	public String toString() {
		return "Manufacturers [mfger_id=" + mfger_id + ", mfger_name=" + mfger_name + ", mfger_desc=" + mfger_desc
				+ ", mfger_website=" + mfger_website + ", mfger_active=" + mfger_active + "]";
	}

}
