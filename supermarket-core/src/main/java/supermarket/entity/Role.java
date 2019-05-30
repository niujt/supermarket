package supermarket.entity;

import java.util.Date;

public class Role {
	/**
	 * 主键
	 */
    private Integer id;
    /**
	 * 权限人编码
	 */
    private String roleCode;
    /**
	 * 权限姓名
	 */
    private String roleName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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
}