package com.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Driver {
	private Integer did;
	private String dname;
	private Integer dphone;
	private String dpassword;
	private String dworkyear;
	private Integer dsex;
	private Integer dage;
	private Set<CarInfo> carinfo = new HashSet<CarInfo>();
	public Set<CarInfo> getCarinfo() {
		return carinfo;
	}
	public void setCarinfo(Set<CarInfo> carinfo) {
		this.carinfo = carinfo;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getDphone() {
		return dphone;
	}
	public void setDphone(Integer dphone) {
		this.dphone = dphone;
	}
	public String getDpassword() {
		return dpassword;
	}
	public void setDpassword(String dpassword) {
		this.dpassword = dpassword;
	}
	public String getDworkyear() {
		return dworkyear;
	}
	public void setDworkyear(String dworkyear) {
		this.dworkyear = dworkyear;
	}
	public Integer getDsex() {
		return dsex;
	}
	public void setDsex(Integer dsex) {
		this.dsex = dsex;
	}
	public Integer getDage() {
		return dage;
	}
	public void setDage(Integer dage) {
		this.dage = dage;
	}
	@Override
	public String toString() {
		return "Driver [did=" + did + ", dname=" + dname + ", dphone=" + dphone
				+ ", dpassword=" + dpassword + ", dworkyear=" + dworkyear
				+ ", dsex=" + dsex + ", dage=" + dage + "]";
	}

	
}
