package com.wxthxy.supermarket.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 库存
 *
 * @author limiaoZhou
 */
public class Goods {
    /**
     * 库存主键
     */
    private Long id;
    /**
     *
     */
    private String gcode;

    private String gname;
    private int gnumber;
    private String gunit;
    private BigDecimal pprice;

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

    public String getGunit() {
        return gunit;
    }

    public void setGunit(String gunit) {
        this.gunit = gunit;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGnumber() {
        return gnumber;
    }

    public void setGnumber(int gnumber) {
        this.gnumber = gnumber;
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
        return "Goods{" +
                "id=" + id +
                ", gcode='" + gcode + '\'' +
                ", gname='" + gname + '\'' +
                ", gnumber=" + gnumber +
                ", gunit='" + gunit + '\'' +
                ", pprice=" + pprice +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                '}';
    }
}