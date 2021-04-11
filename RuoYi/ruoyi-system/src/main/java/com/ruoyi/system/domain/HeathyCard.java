package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 健康卡对象 heathy_card
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public class HeathyCard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 健康卡ID */
    private Long healthCardId;

    /** 登记人 */
    @Excel(name = "登记人")
    private String registrant;

    /** 登记时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "登记时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date registerTime;

    /** 登记编号 */
    @Excel(name = "登记编号")
    private String registerNo;

    /** 问题1 */
    @Excel(name = "问题1")
    private String questionOne;

    /** 问题2 */
    @Excel(name = "问题2")
    private String questionTwo;

    /** 问题3 */
    @Excel(name = "问题3")
    private String questionThree;

    /** 问题4 */
    @Excel(name = "问题4")
    private String questionFor;

    /** 问题5 */
    @Excel(name = "问题5")
    private String questionFive;

    /** 问题6 */
    @Excel(name = "问题6")
    private String questionSix;

    /** 问题7 */
    @Excel(name = "问题7")
    private String questionSeven;

    /** 问题8 */
    @Excel(name = "问题8")
    private String questionEight;

    /** 问题9 */
    @Excel(name = "问题9")
    private String questionNine;

    /** 问题10 */
    @Excel(name = "问题10")
    private String questionTen;

    /** 温度1 */
    @Excel(name = "温度1")
    private float temperatureOne;

    /** 温度2 */
    @Excel(name = "温度2")
    private float temperatureTwo;

    /** 温度3 */
    @Excel(name = "温度3")
    private float temperatureThree;

    public void setHealthCardId(Long healthCardId) 
    {
        this.healthCardId = healthCardId;
    }

    public Long getHealthCardId() 
    {
        return healthCardId;
    }
    public void setRegistrant(String registrant) 
    {
        this.registrant = registrant;
    }

    public String getRegistrant() 
    {
        return registrant;
    }
    public void setRegisterTime(Date registerTime) 
    {
        this.registerTime = registerTime;
    }

    public Date getRegisterTime() 
    {
        return registerTime;
    }
    public void setRegisterNo(String registerNo) 
    {
        this.registerNo = registerNo;
    }

    public String getRegisterNo() 
    {
        return registerNo;
    }
    public void setQuestionOne(String questionOne) 
    {
        this.questionOne = questionOne;
    }

    public String getQuestionOne() 
    {
        return questionOne;
    }
    public void setQuestionTwo(String questionTwo) 
    {
        this.questionTwo = questionTwo;
    }

    public String getQuestionTwo() 
    {
        return questionTwo;
    }
    public void setQuestionThree(String questionThree) 
    {
        this.questionThree = questionThree;
    }

    public String getQuestionThree() 
    {
        return questionThree;
    }
    public void setQuestionFor(String questionFor) 
    {
        this.questionFor = questionFor;
    }

    public String getQuestionFor() 
    {
        return questionFor;
    }
    public void setQuestionFive(String questionFive) 
    {
        this.questionFive = questionFive;
    }

    public String getQuestionFive() 
    {
        return questionFive;
    }
    public void setQuestionSix(String questionSix) 
    {
        this.questionSix = questionSix;
    }

    public String getQuestionSix() 
    {
        return questionSix;
    }
    public void setQuestionSeven(String questionSeven) 
    {
        this.questionSeven = questionSeven;
    }

    public String getQuestionSeven() 
    {
        return questionSeven;
    }
    public void setQuestionEight(String questionEight) 
    {
        this.questionEight = questionEight;
    }

    public String getQuestionEight() 
    {
        return questionEight;
    }
    public void setQuestionNine(String questionNine) 
    {
        this.questionNine = questionNine;
    }

    public String getQuestionNine() 
    {
        return questionNine;
    }
    public void setQuestionTen(String questionTen) 
    {
        this.questionTen = questionTen;
    }

    public String getQuestionTen() 
    {
        return questionTen;
    }
    public void setTemperatureOne(float temperatureOne)
    {
        this.temperatureOne = temperatureOne;
    }

    public float getTemperatureOne()
    {
        return temperatureOne;
    }
    public void setTemperatureTwo(float temperatureTwo)
    {
        this.temperatureTwo = temperatureTwo;
    }

    public float getTemperatureTwo()
    {
        return temperatureTwo;
    }
    public void setTemperatureThree(float temperatureThree)
    {
        this.temperatureThree = temperatureThree;
    }

    public float getTemperatureThree()
    {
        return temperatureThree;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("healthCardId", getHealthCardId())
            .append("registrant", getRegistrant())
            .append("registerTime", getRegisterTime())
            .append("registerNo", getRegisterNo())
            .append("questionOne", getQuestionOne())
            .append("questionTwo", getQuestionTwo())
            .append("questionThree", getQuestionThree())
            .append("questionFor", getQuestionFor())
            .append("questionFive", getQuestionFive())
            .append("questionSix", getQuestionSix())
            .append("questionSeven", getQuestionSeven())
            .append("questionEight", getQuestionEight())
            .append("questionNine", getQuestionNine())
            .append("questionTen", getQuestionTen())
            .append("temperatureOne", getTemperatureOne())
            .append("temperatureTwo", getTemperatureTwo())
            .append("temperatureThree", getTemperatureThree())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
