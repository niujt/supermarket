package com.wxthxy.market.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 销售
 * @author Dell
 *
 */
public class Sale {
	/**
	 * 销售主键
	 */
    private Long id;
    /**
	 * 销售编码
	 */
    private String scode;
    /**
	 * 销售商品名称
	 */
    private String sname;
    /**
	 * 销售数量
	 */
    private int snumber;
    private String sunit;
    /**
	 * 进价
	 */
    private BigDecimal pprice;
    /**
	 * 售价
	 */
    private BigDecimal sprice;
    /**
     * 创建者
     */
    private Long createdBy;
    /**
	 * 创建日期
	 */
    private Date creationDate;
    /**
	 * 修改者
	 */
    private Long modifyBy;
    /**
	 * 修改日期
	 */
    private Date modifyDate;
    
	
	public String getSunit() {
		return sunit;
	}
	public void setSunit(String sunit) {
		this.sunit = sunit;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	public int getSnumber() {
		return snumber;
	}
	public void setSnumber(int snumber) {
		this.snumber = snumber;
	}
	public BigDecimal getPprice() {
		return pprice;
	}
	public void setPprice(BigDecimal pprice) {
		this.pprice = pprice;
	}
	public BigDecimal getSprice() {
		return sprice;
	}
	public void setSprice(BigDecimal sprice) {
		this.sprice = sprice;
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
		return "Sale [id=" + id + ", scode=" + scode + ", sname=" + sname + ", snumber=" + snumber + ", sunit=" + sunit
				+ ", pprice=" + pprice + ", sprice=" + sprice + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}
    
}