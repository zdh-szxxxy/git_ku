package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 求职信息对象 sys_job_wanted
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
public class SysJobWanted extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 求职ID */
    private Long jobWantedId;

    /** 求职编码 */
    @Excel(name = "求职编码")
    private String jobWantedCode;

    /** 岗位要求 */
    @Excel(name = "岗位要求")
    private String postDemand;

    /** 薪水要求 */
    @Excel(name = "薪水要求")
    private String salaryDemand;

    /** 工作时间要求 */
    @Excel(name = "工作时间要求")
    private String timeDemand;

    /** 工作地点要求 */
    @Excel(name = "工作地点要求")
    private String addressDemand;

    /** 求职者 */
    @Excel(name = "求职者")
    private String jobSeekers;

    /** 电话 */
    @Excel(name = "电话")
    private String phoneNumber;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setJobWantedId(Long jobWantedId) 
    {
        this.jobWantedId = jobWantedId;
    }

    public Long getJobWantedId() 
    {
        return jobWantedId;
    }
    public void setJobWantedCode(String jobWantedCode) 
    {
        this.jobWantedCode = jobWantedCode;
    }

    public String getJobWantedCode() 
    {
        return jobWantedCode;
    }
    public void setPostDemand(String postDemand) 
    {
        this.postDemand = postDemand;
    }

    public String getPostDemand() 
    {
        return postDemand;
    }
    public void setSalaryDemand(String salaryDemand) 
    {
        this.salaryDemand = salaryDemand;
    }

    public String getSalaryDemand() 
    {
        return salaryDemand;
    }
    public void setTimeDemand(String timeDemand) 
    {
        this.timeDemand = timeDemand;
    }

    public String getTimeDemand() 
    {
        return timeDemand;
    }

    public void setAddressDemand(String addressDemand)
    {
        this.addressDemand = addressDemand;
    }

    public String getAddressDemand()
    {
        return addressDemand;
    }

    public void setJobSeekers(String jobSeekers)
    {
        this.jobSeekers = jobSeekers;
    }

    public String getJobSeekers()
    {
        return jobSeekers;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }


    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("jobWantedId", getJobWantedId())
            .append("jobWantedCode", getJobWantedCode())
            .append("postDemand", getPostDemand())
            .append("salaryDemand", getSalaryDemand())
            .append("timeDemand", getTimeDemand())
            .append("addressDemand", getAddressDemand())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
