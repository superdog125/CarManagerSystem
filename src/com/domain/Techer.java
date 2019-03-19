package com.domain;

import java.util.Date;

public class Techer {
	private Integer tid;
	private String tname;
	private Integer tphone;
	private String tpassword;
	private String tworkyear;
	private Integer tsex;
	private Integer tage;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getTphone() {
		return tphone;
	}
	public void setTphone(Integer tphone) {
		this.tphone = tphone;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	public String getTworkyear() {
		return tworkyear;
	}
	public void setTworkyear(String tworkyear) {
		this.tworkyear = tworkyear;
	}
	public Integer getTsex() {
		return tsex;
	}
	public void setTsex(Integer tsex) {
		this.tsex = tsex;
	}
	public Integer getTage() {
		return tage;
	}
	public void setTage(Integer tage) {
		this.tage = tage;
	}
	@Override
	public String toString() {
		return "Techer [tid=" + tid + ", tname=" + tname + ", tphone=" + tphone
				+ ", tpassword=" + tpassword + ", tworkyear=" + tworkyear
				+ ", tsex=" + tsex + ", tage=" + tage + "]";
	}
	
}
