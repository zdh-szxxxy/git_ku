package com.ruoyi.jmlg.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 企业信息对象 jmlg_qiye
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
public class JmlgQiye extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录id */
    private Long id;

    /** 企业信用代码 */
    @Excel(name = "企业信用代码")
    private String qiyeXinyongDaima;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String qiyeMingcheng;

    /** 行业 */
    @Excel(name = "行业")
    private String hangye;

    /** 别名 */
    @Excel(name = "别名")
    private String bieming;

    /** 电话 */
    @Excel(name = "电话")
    private String dianhua;

    /** 地址 */
    @Excel(name = "地址")
    private String dizhi;

    /** 维度 */
    @Excel(name = "维度")
    private BigDecimal weidu;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal jingdu;

    /** 企业坐标 */
    @Excel(name = "企业坐标")
    private String qiyeZuobiao;

    /** 结算方式 */
    @Excel(name = "结算方式")
    private String jiesuanFangshi;

    /** 费用 */
    @Excel(name = "费用")
    private Long feiyong;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long chuangjianrenId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date chuangjianShijian;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setQiyeXinyongDaima(String qiyeXinyongDaima) 
    {
        this.qiyeXinyongDaima = qiyeXinyongDaima;
    }

    public String getQiyeXinyongDaima() 
    {
        return qiyeXinyongDaima;
    }
    public void setQiyeMingcheng(String qiyeMingcheng) 
    {
        this.qiyeMingcheng = qiyeMingcheng;
    }

    public String getQiyeMingcheng() 
    {
        return qiyeMingcheng;
    }
    public void setHangye(String hangye) 
    {
        this.hangye = hangye;
    }

    public String getHangye() 
    {
        return hangye;
    }
    public void setBieming(String bieming) 
    {
        this.bieming = bieming;
    }

    public String getBieming() 
    {
        return bieming;
    }
    public void setDianhua(String dianhua) 
    {
        this.dianhua = dianhua;
    }

    public String getDianhua() 
    {
        return dianhua;
    }
    public void setDizhi(String dizhi) 
    {
        this.dizhi = dizhi;
    }

    public String getDizhi() 
    {
        return dizhi;
    }
    public void setWeidu(BigDecimal weidu) 
    {
        this.weidu = weidu;
    }

    public BigDecimal getWeidu() 
    {
        return weidu;
    }
    public void setJingdu(BigDecimal jingdu) 
    {
        this.jingdu = jingdu;
    }

    public BigDecimal getJingdu() 
    {
        return jingdu;
    }
    public void setQiyeZuobiao(String qiyeZuobiao) 
    {
        this.qiyeZuobiao = qiyeZuobiao;
    }

    public String getQiyeZuobiao() 
    {
        return qiyeZuobiao;
    }
    public void setJiesuanFangshi(String jiesuanFangshi) 
    {
        this.jiesuanFangshi = jiesuanFangshi;
    }

    public String getJiesuanFangshi() 
    {
        return jiesuanFangshi;
    }
    public void setFeiyong(Long feiyong) 
    {
        this.feiyong = feiyong;
    }

    public Long getFeiyong() 
    {
        return feiyong;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setChuangjianrenId(Long chuangjianrenId) 
    {
        this.chuangjianrenId = chuangjianrenId;
    }

    public Long getChuangjianrenId() 
    {
        return chuangjianrenId;
    }
    public void setChuangjianShijian(Date chuangjianShijian) 
    {
        this.chuangjianShijian = chuangjianShijian;
    }

    public Date getChuangjianShijian() 
    {
        return chuangjianShijian;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("qiyeXinyongDaima", getQiyeXinyongDaima())
            .append("qiyeMingcheng", getQiyeMingcheng())
            .append("hangye", getHangye())
            .append("bieming", getBieming())
            .append("dianhua", getDianhua())
            .append("dizhi", getDizhi())
            .append("weidu", getWeidu())
            .append("jingdu", getJingdu())
            .append("qiyeZuobiao", getQiyeZuobiao())
            .append("jiesuanFangshi", getJiesuanFangshi())
            .append("feiyong", getFeiyong())
            .append("status", getStatus())
            .append("chuangjianrenId", getChuangjianrenId())
            .append("chuangjianShijian", getChuangjianShijian())
            .append("remark", getRemark())
            .toString();
    }
}
