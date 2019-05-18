package com.wxthxy.supermarket.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 人事管理类
 * @author limiaoZhou
 *
 */
public class People {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 姓名
	 */
	private String peopleName;
	/**
	 * 年龄
	 */
	private int peopleAge;
	/**
	 * 职位
	 */
	private Long deptid;
	private String dname;
	/**
	 * 薪水
	 */
	private BigDecimal salary;
	/**
	 * 性别
	 */
	private int gender;
	/**
	 * 创建者
	 */
	private Long createdBy;
	/**
	 * 创建时间
	 */
	private Date creationDate;
	/**
	 * 修改者
	 */
	private Long modifyBy;
	/**
	 * 修改时间
	 */
	private Date modifyDate;

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPeopleName() {
		return peopleName;
	}
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
	public int getPeopleAge() {
		return peopleAge;
	}
	public void setPeopleAge(int peopleAge) {
		this.peopleAge = peopleAge;
	}
	
	public Long getDeptid() {
		return deptid;
	}
	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", peopleName=" + peopleName + ", peopleAge=" + peopleAge + ", deptid=" + deptid
				+ ", salary=" + salary + ", gender=" + gender + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}
	
	
	
}
