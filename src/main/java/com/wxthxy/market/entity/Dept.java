package com.wxthxy.market.entity;

import java.util.Date;
/**
 * 职位
 * @author Dell
 *
 */
public class Dept {
	/**
	 * 职位主键
	 */
    private Long id;
    private String dcode;
    private String dname;
    private String dnumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDcode() {
		return dcode;
	}
	public void setDcode(String dcode) {
		this.dcode = dcode;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDnumber() {
		return dnumber;
	}
	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", dcode=" + dcode + ", dname=" + dname + ", dnumber=" + dnumber + "]";
	}
    
}