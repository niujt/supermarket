package com.wxthxy.supermarket.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 商品类
 * @author limiaoZhou
 *
 */
public class Bill {
	/**
	 * 商品主键
	 */
    private Long id;
    /**
	 * 商品编码
	 */
    private String billCode;
    /**
	 * 商品名称
	 */
    private String productName;
    /**
	 * 商品类型
	 */
    private String productDesc;
    /**
	 * 商品单位
	 */
    private String productUnit;
    /**
	 * 商品价格
	 */
    private BigDecimal productCount;
    /**
	 * 商品总价
	 */
    private BigDecimal totalPrice;
    private Integer isin;
    /**
	 * 是否付款
	 */
    private Integer isPayment;
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
    /**
	 * 供应商id
	 */
    private Integer providerId;
    /**
	 * 供应商姓名
	 */
    private String providerName;
    
    
	public Integer getIsin() {
		return isin;
	}

	public void setIsin(Integer isin) {
		this.isin = isin;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode == null ? null : billCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    public BigDecimal getProductCount() {
        return productCount;
    }

    public void setProductCount(BigDecimal productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Integer isPayment) {
        this.isPayment = isPayment;
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

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    @Override
	public String toString() {
		return "Bill [id=" + id + ", billCode=" + billCode + ", productName=" + productName + ", productDesc="
				+ productDesc + ", productUnit=" + productUnit + ", productCount=" + productCount + ", totalPrice="
				+ totalPrice + ", isin=" + isin + ", isPayment=" + isPayment + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate
				+ ", providerId=" + providerId + ", providerName=" + providerName + "]";
	}
    
}