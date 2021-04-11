package com.ruoyi.common.core.domain.entity;

import javax.validation.constraints.*;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 部门表 sys_dept
 * 
 * @author ruoyi
 */
public class SysDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门ID */
    private Long deptId;

    /** 父部门ID */
    private Long parentId;

    /** 企业编码 */
    @Excel(name = "企业编码")
    private String enterpriseCode;

    /** 祖级列表 */
    private String ancestors;

    /** 部门名称 */
    private String deptName;

    /** 行业 */
    @Excel(name = "行业")
    private String industry;

    /** 别名 */
    @Excel(name = "别名")
    private String alias;

    /** 显示顺序 */
    private String orderNum;

    /** 负责人 */
    private String leader;

    /** 联系电话 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 址地 */
    @Excel(name = "址地")
    private String address;

    /** 坐标 */
    @Excel(name = "坐标")
    private String coordinate;

    /** 经度 */
    @Excel(name = "经度")
    private float longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private float latitude;

    /** 部门状态:0正常,1停用 */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 父部门名称 */
    private String parentName;

    /** 备注*/
    private String remark;

    /** 企业信用代码 */
    @Excel(name = "企业信用代码")
    private String enterpriseCreditCode;

    /** 费用结算方式 */
    @Excel(name = "费用结算方式")
    private String costSettlementMethod;

    /** 费用 */
    @Excel(name = "费用")
    private float cost;

    public Long getDeptId()
    {
        return deptId;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setEnterpriseCode(String enterpriseCode)
    {
        this.enterpriseCode = enterpriseCode;
    }

    public String getEnterpriseCode()
    {
        return enterpriseCode;
    }

    public void setIndustry(String industry)
    {
        this.industry = industry;
    }

    public String getIndustry()
    {
        return industry;
    }

    public void setAlias(String alias)
    {
        this.alias = alias;
    }

    public String getAlias()
    {
        return alias;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public String getAncestors()
    {
        return ancestors;
    }

    public void setAncestors(String ancestors)
    {
        this.ancestors = ancestors;
    }

    @NotBlank(message = "部门名称不能为空")
    @Size(min = 0, max = 30, message = "部门名称长度不能超过30个字符")
    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    @NotBlank(message = "显示顺序不能为空")
    public String getOrderNum()
    {
        return orderNum;
    }

    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
    }

    public String getLeader()
    {
        return leader;
    }

    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    @Size(min = 0, max = 11, message = "联系电话长度不能超过11个字符")
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getStatus()
    {
        return status;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setCoordinate(String coordinate)
    {
        this.coordinate= coordinate;
    }

    public String getCoordinate()
    {
        return coordinate;
    }

    public void setLongitude(float longitude)
    {
        this.longitude = longitude;
    }

    public Float getLongitude()
    {
        return longitude;
    }

    public void setLatitude(float latitude)
    {
        this.latitude = latitude;
    }

    public Float getLatitude()
    {
        return latitude;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public void setEnterpriseCreditCode(String enterpriseCreditCode)
    {
        this.enterpriseCreditCode = enterpriseCreditCode;
    }

    public String getEnterpriseCreditCode()
    {
        return enterpriseCreditCode;
    }
    public void setCostSettlementMethod(String costSettlementMethod)
    {
        this.costSettlementMethod = costSettlementMethod;
    }

    public String getCostSettlementMethod()
    {
        return costSettlementMethod;
    }
    public void setCost(float cost)
    {
        this.cost = cost;
    }

    public float getCost()
    {
        return cost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("deptName", getDeptName())
            .append("orderNum", getOrderNum())
            .append("leader", getLeader())
            .append("phone", getPhone())
            .append("email", getEmail())
                .append("address", getAddress())
                .append("coordinate", getCoordinate())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .append("parentname", getParentName())
                .append("remark", getRemark())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
                .append("enterpriseCreditCode", getEnterpriseCreditCode())
                .append("costSettlementMethod", getCostSettlementMethod())
                .append("cost", getCost())
            .toString();
    }
}
