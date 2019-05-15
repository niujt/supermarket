package com.wxthxy.supermarket.entity;

import java.util.Date;
/**
 * 退货
 * @author Dell
 *
 */
public class Refuse {
	/**
	 * 退货id（主键）
	 */
	private Long id;
	/**
	 * 商品代码
	 */
	private String refCode;
	/**
	 * 商品名称
	 */
	private String refName;
	/**
	 * 退货理由
	 */
	private int refnumber;
	private String refReasion;
	/**
	 * 创建者
	 */
	private Long createBy;
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
	private String refunit;
	
	
	public String getRefunit() {
		return refunit;
	}

	public void setRefunit(String refunit) {
		this.refunit = refunit;
	}

	public int getRefnumber() {
		return refnumber;
	}

	public void setRefnumber(int refnumber) {
		this.refnumber = refnumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRefCode() {
		return refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

	public String getRefReasion() {
		return refReasion;
	}

	public void setRefReasion(String refReasion) {
		this.refReasion = refReasion;
	}



	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
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

	@Override
	public String toString() {
		return "Refuse [id=" + id + ", refCode=" + refCode + ", refName=" + refName + ", refnumber=" + refnumber
				+ ", refReasion=" + refReasion + ", createBy=" + createBy + ", creationDate=" + creationDate
				+ ", modifyDate=" + modifyDate + ", modifyBy=" + modifyBy + ", refunit=" + refunit + "]";
	}
	
}