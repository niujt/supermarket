package com.wxthxy.supermarket.entity;

import java.util.Date;
/**
 * 供应商
 * @author limiaoZhou
 *
 */
public class Provider {
	/**
	 * 供应商id（主键）
	 */
	private Integer id;
	/**
	 * 供应商代码
	 */
	private String proCode;
	/**
	 * 供应商名字
	 */
	private String proName;
	/**
	 * 供应商介绍
	 */
	private String proDesc;
	/**
	 * 供应人
	 */
	private String proContact;
	/**
	 * 供应人手机
	 */
	private String proPhone;
	/**
	 * 供应商地址
	 */
	private String proAddress;
	/**
	 * 传真
	 */
	private String proFax;
	/**
	 * 创建者
	 */
	private Long createdBy;
	/**
	 * 创建日期
	 */
	private Date creationDate;
	/**
	 * 修改日期
	 */
	private Date modifyDate;
	/**
	 * 修改者
	 */
	private Long modifyBy;
	/**
	 * 营业执照
	 */
	private String companyLicPicPath;
	/**
	 * 组织机构代码证
	 */
	private String orgCodePicPath;

	public String getCompanyLicPicPath() {
		return companyLicPicPath;
	}

	public void setCompanyLicPicPath(String companyLicPicPath) {
		this.companyLicPicPath = companyLicPicPath;
	}

	public String getOrgCodePicPath() {
		return orgCodePicPath;
	}

	public void setOrgCodePicPath(String orgCodePicPath) {
		this.orgCodePicPath = orgCodePicPath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode == null ? null : proCode.trim();
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName == null ? null : proName.trim();
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc == null ? null : proDesc.trim();
	}

	public String getProContact() {
		return proContact;
	}

	public void setProContact(String proContact) {
		this.proContact = proContact == null ? null : proContact.trim();
	}

	public String getProPhone() {
		return proPhone;
	}

	public void setProPhone(String proPhone) {
		this.proPhone = proPhone == null ? null : proPhone.trim();
	}

	public String getProAddress() {
		return proAddress;
	}

	public void setProAddress(String proAddress) {
		this.proAddress = proAddress == null ? null : proAddress.trim();
	}

	public String getProFax() {
		return proFax;
	}

	public void setProFax(String proFax) {
		this.proFax = proFax == null ? null : proFax.trim();
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}
}