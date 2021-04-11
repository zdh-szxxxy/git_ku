package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 招聘信息对象 sys_recruit
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
public class SysRecruit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 招聘ID */
    private Long recruitId;

    /** 招聘编码 */

    private String recruitCode;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String postName;

    /** 负责人 */

    private String fzr;

    /** 福利特色 */

    private String welfareCharacteristic;

    /** 综合薪资 */

    private String multipleSalary;

    /** 资薪标准 */

    private String salaryStandard;

    /** 发薪周期 */

    private String payPeriod;

    /** 发薪日 */

    private String Payday;

    /** 资薪结构 */

    private String payStructure;

    /** 伙食情况 */

    private String foodSituation;

    /** 住宿情况 */

    private String accommodationSituation;

    /** 社保情况 */

    private String insuranceSituation;

    /** 其他福利 */

    private String otherSituation;

    /** 工作内容 */
    @Excel(name = "工作内容")
    private String workContent;

    /** 工作时间 */

    private String workTime;

    /** 工作方式 */

    private String workMothed;

    /** 年龄要求 */
    @Excel(name = "年龄要求")
    private String ageDemand;

    /** 性别要求 */
    @Excel(name = "性别要求")
    private String genderDemand;

    /** 学历要求 */
    @Excel(name = "学历要求")
    private Integer educationDemand;

    /** 其他要求 */

    private String otherDemand;

    /** 状态（0正常 1停用） */


    /** 部门名称 */
    private String deptName;

    /** 行业 */
    @Excel(name = "行业",type = Excel.Type.EXPORT)
    private String industry;

    /** 负责人 */
    private String leader;

    /** 址地 */
    @Excel(name = "址地")
    private String address;

    /** 经度 */
    @Excel(name = "经度",type = Excel.Type.EXPORT)
    private float longitude;

    /** 纬度 */
    @Excel(name = "纬度",type = Excel.Type.EXPORT)
    private float latitude;

    /** 经度x */
    @Excel(name = "经度x",type = Excel.Type.EXPORT)
    private String x;

    /** 纬度y */
    @Excel(name = "纬度y",type = Excel.Type.EXPORT)
    private String y;

    /** 距离 */
    @Excel(name = "距离",type = Excel.Type.EXPORT)
    private float distance;

    /** 父部门名称 */
    private String parentName;

    private String status;

    /** 聘招人数 */
    @Excel(name = "聘招人数")
    private Long recruitPopleNumber;

    /** 终止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "终止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date terminationTime;

    /** 是否有厂车 */
    @Excel(name = "是否有厂车")
    private String haveCar;

    /** 厂车路线 */
    @Excel(name = "厂车路线")
    private String carRoute;

    /** 食宿情况 */
    @Excel(name = "食宿情况")
    private String shisuSituation;

    /** 食宿说明 */
    @Excel(name = "食宿说明")
    private String shisuExplain;

    /** 民族限制 */
    @Excel(name = "民族限制")
    private String nationLimit;

    /** 案底限制 */
    @Excel(name = "案底限制")
    private String andiLimit;

    /** 体检要求 */
    @Excel(name = "体检要求")
    private String testDemand;

    /** 纹身要求 */
    @Excel(name = "纹身要求")
    private String tattoDemand;

    /** 无尘衣要求 */
    @Excel(name = "无尘衣要求")
    private String noChenyiDemand;

    /** 工资说明 */
    @Excel(name = "工资说明")
    private String moneyExplain;

    /** 需在职天数 */
    @Excel(name = "需在职天数")
    private Integer workDays;

    /** 工期要求 */
    @Excel(name = "工期要求")
    private String gongqiDemand;

    /** 算结费用 */
    @Excel(name = "算结费用")
    private float jiesuanCost;

    public void setRecruitId(Long recruitId)
    {
        this.recruitId = recruitId;
    }

    public Long getRecruitId()
    {
        return recruitId;
    }
    public void setRecruitCode(String recruitCode)
    {
        this.recruitCode = recruitCode;
    }

    public String getRecruitCode()
    {
        return recruitCode;
    }
    public void setPostName(String postName)
    {
        this.postName = postName;
    }

    public String getPostName()
    {
        return postName;
    }

    public void setFzr(String fzr)
    {
        this.fzr = fzr;
    }

    public String getFzr()
    {
        return fzr;
    }

    public void setWelfareCharacteristic(String welfareCharacteristic)
    {
        this.welfareCharacteristic = welfareCharacteristic;
    }

    public String getWelfareCharacteristic()
    {
        return welfareCharacteristic;
    }
    public void setMultipleSalary(String multipleSalary)
    {
        this.multipleSalary = multipleSalary;
    }

    public String getMultipleSalary()
    {
        return multipleSalary;
    }
    public void setSalaryStandard(String salaryStandard)
    {
        this.salaryStandard = salaryStandard;
    }

    public String getSalaryStandard()
    {
        return salaryStandard;
    }
    public void setPayPeriod(String payPeriod)
    {
        this.payPeriod = payPeriod;
    }

    public String getPayPeriod()
    {
        return payPeriod;
    }
    public void setPayday(String Payday)
    {
        this.Payday = Payday;
    }

    public String getPayday()
    {
        return Payday;
    }
    public void setPayStructure(String payStructure)
    {
        this.payStructure = payStructure;
    }

    public String getPayStructure()
    {
        return payStructure;
    }
    public void setFoodSituation(String foodSituation)
    {
        this.foodSituation = foodSituation;
    }

    public String getFoodSituation()
    {
        return foodSituation;
    }
    public void setAccommodationSituation(String accommodationSituation)
    {
        this.accommodationSituation = accommodationSituation;
    }

    public String getAccommodationSituation()
    {
        return accommodationSituation;
    }
    public void setInsuranceSituation(String insuranceSituation)
    {
        this.insuranceSituation = insuranceSituation;
    }

    public String getInsuranceSituation()
    {
        return insuranceSituation;
    }
    public void setOtherSituation(String otherSituation)
    {
        this.otherSituation = otherSituation;
    }

    public String getOtherSituation()
    {
        return otherSituation;
    }
    public void setWorkContent(String workContent)
    {
        this.workContent = workContent;
    }

    public String getWorkContent()
    {
        return workContent;
    }
    public void setWorkTime(String workTime)
    {
        this.workTime = workTime;
    }

    public String getWorkTime()
    {
        return workTime;
    }
    public void setWorkMothed(String workMothed)
    {
        this.workMothed = workMothed;
    }

    public String getWorkMothed()
    {
        return workMothed;
    }

    public void setAgeDemand(String ageDemand)
    {
        this.ageDemand = ageDemand;
    }

    public String getAgeDemand()
    {
        return ageDemand;
    }
    public void setGenderDemand(String genderDemand)
    {
        this.genderDemand = genderDemand;
    }

    public String getGenderDemand()
    {
        return genderDemand;
    }
    public void setEducationDemand(Integer educationDemand)
    {
        this.educationDemand = educationDemand;
    }

    public Integer getEducationDemand()
    {
        return educationDemand;
    }
    public void setOtherDemand(String otherDemand)
    {
        this.otherDemand = otherDemand;
    }


    public String getOtherDemand()
    {
        return otherDemand;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setIndustry(String industry)
    {
        this.industry = industry;
    }

    public String getIndustry()
    {
        return industry;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getLeader()
    {
        return leader;
    }

    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
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

    public void setX(String x)
    {
        this.x = x;
    }

    public String getX()
    {
        return x;
    }

    public void setY(String y)
{
    this.y = y;
}

    public String getY()
    {
        return y;
    }

    public void setDistance(float distance)
    {
        this.distance = distance;
    }

    public Float getDistance()
    {
        return distance;
    }

    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

    public void setRecruitPopleNumber(Long recruitPopleNumber)
    {
        this.recruitPopleNumber = recruitPopleNumber;
    }

    public Long getRecruitPopleNumber()
    {
        return recruitPopleNumber;
    }
    public void setTerminationTime(Date terminationTime)
    {
        this.terminationTime = terminationTime;
    }

    public Date getTerminationTime()
    {
        return terminationTime;
    }

    public void setHaveCar(String haveCar)
    {
        this.haveCar = haveCar;
    }

    public String getHaveCar()
    {
        return haveCar;
    }
    public void setCarRoute(String carRoute)
    {
        this.carRoute = carRoute;
    }

    public String getCarRoute()
    {
        return carRoute;
    }
    public void setShisuSituation(String shisuSituation)
    {
        this.shisuSituation = shisuSituation;
    }

    public String getShisuSituation()
    {
        return shisuSituation;
    }
    public void setShisuExplain(String shisuExplain)
    {
        this.shisuExplain = shisuExplain;
    }

    public String getShisuExplain()
    {
        return shisuExplain;
    }
    public void setNationLimit(String nationLimit)
    {
        this.nationLimit = nationLimit;
    }

    public String getNationLimit()
    {
        return nationLimit;
    }
    public void setAndiLimit(String andiLimit)
    {
        this.andiLimit = andiLimit;
    }

    public String getAndiLimit()
    {
        return andiLimit;
    }
    public void setTestDemand(String testDemand)
    {
        this.testDemand = testDemand;
    }

    public String getTestDemand()
    {
        return testDemand;
    }
    public void setTattoDemand(String tattoDemand)
    {
        this.tattoDemand = tattoDemand;
    }

    public String getTattoDemand()
    {
        return tattoDemand;
    }
    public void setNoChenyiDemand(String noChenyiDemand)
    {
        this.noChenyiDemand = noChenyiDemand;
    }

    public String getNoChenyiDemand()
    {
        return noChenyiDemand;
    }
    public void setMoneyExplain(String moneyExplain)
    {
        this.moneyExplain = moneyExplain;
    }

    public String getMoneyExplain()
    {
        return moneyExplain;
    }
    public void setWorkDays(Integer workDays)
    {
        this.workDays = workDays;
    }

    public Integer getWorkDays()
    {
        return workDays;
    }
    public void setGongqiDemand(String gongqiDemand)
    {
        this.gongqiDemand = gongqiDemand;
    }

    public String getGongqiDemand()
    {
        return gongqiDemand;
    }

    public void setJiesuanCost(float jiesuanCost)
    {
        this.jiesuanCost = jiesuanCost;
    }

    public float getJiesuanCost()
    {
        return jiesuanCost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recruitId", getRecruitId())
            .append("recruitCode", getRecruitCode())
            .append("postName", getPostName())
                .append("fzr", getFzr())
            .append("welfareCharacteristic", getWelfareCharacteristic())
            .append("multipleSalary", getMultipleSalary())
            .append("salaryStandard", getSalaryStandard())
            .append("payPeriod", getPayPeriod())
            .append("Payday", getPayday())
            .append("payStructure", getPayStructure())
            .append("foodSituation", getFoodSituation())
            .append("accommodationSituation", getAccommodationSituation())
            .append("insuranceSituation", getInsuranceSituation())
            .append("otherSituation", getOtherSituation())
            .append("workContent", getWorkContent())
            .append("workTime", getWorkTime())
            .append("workMothed", getWorkMothed())
            .append("ageDemand", getAgeDemand())
            .append("genderDemand", getGenderDemand())
            .append("educationDemand", getEducationDemand())
            .append("otherDemand", getOtherDemand())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
                .append("parentname", getParentName())
                .append("X", getX())
                .append("Y", getY())
                .append("distance", getDistance())
                .append("deptname", getDeptName())
                .append("recruitPopleNumber", getRecruitPopleNumber())
                .append("terminationTime", getTerminationTime())
                .append("haveCar", getHaveCar())
                .append("carRoute", getCarRoute())
                .append("shisuSituation", getShisuSituation())
                .append("shisuExplain", getShisuExplain())
                .append("nationLimit", getNationLimit())
                .append("andiLimit", getAndiLimit())
                .append("testDemand", getTestDemand())
                .append("tattoDemand", getTattoDemand())
                .append("noChenyiDemand", getNoChenyiDemand())
                .append("moneyExplain", getMoneyExplain())
                .append("workDays", getWorkDays())
                .append("gongqiDemand", getGongqiDemand())
                .append("jiesuanCost", getJiesuanCost())
                .toString();
    }
}
