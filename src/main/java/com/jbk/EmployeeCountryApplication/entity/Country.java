package com.jbk.EmployeeCountryApplication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
	
	@Id
	private Integer cid;
	private String cname;
	
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Country(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
}
