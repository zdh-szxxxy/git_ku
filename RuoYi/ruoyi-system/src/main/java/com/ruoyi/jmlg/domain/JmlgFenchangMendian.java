package com.ruoyi.jmlg.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * gongchengmendian对象 jmlg_fenchang_mendian
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public class JmlgFenchangMendian extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录id */
    private Long id;

    /** 企业id */
    @Excel(name = "企业id")
    private Long qiyeId;

    /** 类别 */
    @Excel(name = "类别")
    private String leibie;

    /** 名称 */
    @Excel(name = "名称")
    private String mingcheng;

    /** 名称 */
    @Excel(name = "企业名称")
    private String qiyeMingcheng;

    /** 负责人 */
    @Excel(name = "负责人")
    private String fuzeren;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String lianxiDianhua;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String youxiang;

    /** 地址 */
    @Excel(name = "地址")
    private String dizhi;

    /** 经度 */
    @Excel(name = "经度")
    private float jingdu;

    /** 纬度 */
    @Excel(name = "纬度")
    private float weidu;

    /** 坐标 */
    @Excel(name = "坐标")
    private String zuobiao;

    /** 状态 */
    @Excel(name = "状态")
    private String zhuangtai;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long chuangjianrenId;

    /** 创建人i */
    @Excel(name = "创建人i")
    private String chuangjianren;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date changjianShijian;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setQiyeId(Long qiyeId) 
    {
        this.qiyeId = qiyeId;
    }

    public Long getQiyeId() 
    {
        return qiyeId;
    }
    public void setQiyeMingcheng(String qiyemingcheng)
    {
        this.qiyeMingcheng = qiyemingcheng;
    }

    public String getQiyeMingcheng()
    {
        return qiyeMingcheng;
    }
    public void setMingcheng(String mingcheng) 
    {
        this.mingcheng = mingcheng;
    }

    public String getMingcheng() 
    {
        return mingcheng;
    }

    public void setLeibie(String leibie)
    {
        this.leibie = leibie;
    }

    public String getLeibie()
    {
        return leibie;
    }

    public void setFuzeren(String fuzeren) 
    {
        this.fuzeren = fuzeren;
    }

    public String getFuzeren() 
    {
        return fuzeren;
    }
    public void setLianxiDianhua(String lianxiDianhua) 
    {
        this.lianxiDianhua = lianxiDianhua;
    }

    public String getLianxiDianhua() 
    {
        return lianxiDianhua;
    }
    public void setYouxiang(String youxiang) 
    {
        this.youxiang = youxiang;
    }

    public String getYouxiang() 
    {
        return youxiang;
    }
    public void setDizhi(String dizhi) 
    {
        this.dizhi = dizhi;
    }

    public String getDizhi() 
    {
        return dizhi;
    }
    public void setJingdu(float jingdu)
    {
        this.jingdu = jingdu;
    }

    public float getJingdu()
    {
        return jingdu;
    }
    public void setWeidu(float weidu)
    {
        this.weidu = weidu;
    }

    public float getWeidu()
    {
        return weidu;
    }
    public void setZuobiao(String zuobiao) 
    {
        this.zuobiao = zuobiao;
    }

    public String getZuobiao() 
    {
        return zuobiao;
    }
    public void setZhuangtai(String zhuangtai) 
    {
        this.zhuangtai = zhuangtai;
    }

    public String getZhuangtai() 
    {
        return zhuangtai;
    }
    public void setChuangjianrenId(Long chuangjianrenId) 
    {
        this.chuangjianrenId = chuangjianrenId;
    }

    public String getChuangjianren()
    {
        return chuangjianren;
    }
    public void setChuangjianren(String chuangjianren)
    {
        this.chuangjianren = chuangjianren;
    }

    public Long getChuangjianrenId()
    {
        return chuangjianrenId;
    }
    public void setChangjianShijian(Date changjianShijian) 
    {
        this.changjianShijian = changjianShijian;
    }

    public Date getChangjianShijian() 
    {
        return changjianShijian;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("qiyeId", getQiyeId())
            .append("mingcheng", getMingcheng())
            .append("fuzeren", getFuzeren())
            .append("lianxiDianhua", getLianxiDianhua())
            .append("youxiang", getYouxiang())
            .append("dizhi", getDizhi())
            .append("jingdu", getJingdu())
            .append("weidu", getWeidu())
            .append("zuobiao", getZuobiao())
            .append("zhuangtai", getZhuangtai())
            .append("chuangjianrenId", getChuangjianrenId())
            .append("changjianShijian", getChangjianShijian())
            .toString();
    }
}
