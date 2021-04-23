package com.ruoyi.jmlg.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 职位信息对象 jmlg_zhiwei
 * 
 * @author zhaodanghui
 * @date 2021-04-22
 */
public class JmlgZhiwei extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录id */
    private Long id;

    /** 工厂门店id */
    private Long gongchangMendianId;

    /** 工厂名店 */
    private String gongchangMendian;
    /** 名称 */
    @Excel(name = "名称")
    private String mingcheng;
    /** 薪资类型 */
    @Excel(name = "薪资类型")
    private String xinziLeixing;

    /** 薪资 */
    @Excel(name = "薪资")
    private Double xinzi;

    /** 包吃 */
    @Excel(name = "包吃")
    private String baochi;

    /** 包住 */
    @Excel(name = "包住")
    private String baozhu;

    /** 结算方式 */
    @Excel(name = "结算方式")
    private String jiesuanFangshi;

    /** 穿无尘衣 */
    @Excel(name = "穿无尘衣")
    private String chuanWuchenyi;

    /** 招聘人数 */
    @Excel(name = "招聘人数")
    private Integer zhaopinRenshu;

    /** 工期 */
    @Excel(name = "工期")
    private Integer gongqi;

    /** 扣押 */
    @Excel(name = "扣押")
    private String kouya;

    /** 性别要求 */
    @Excel(name = "性别要求")
    private String xingbieYaoqiu;

    /** 年龄要求 */
    @Excel(name = "年龄要求")
    private String nianlingYaoqiu;

    /** 经验要求 */
    @Excel(name = "经验要求")
    private String jingyanYaoqiu;

    /** 学历要求 */
    @Excel(name = "学历要求")
    private String xueliYaoqiu;

    /** 面试材料 */
    @Excel(name = "面试材料")
    private String mianshiCailiao;

    /** 面试时间 */
    @Excel(name = "面试时间")
    private String mianshiShijian;

    /** 薪资结构 */
    @Excel(name = "薪资结构")
    private String xinziJiegou;

    /** 薪资说明 */
    @Excel(name = "薪资说明")
    private String xinziShuoming;

    /** 吃饭说明 */
    @Excel(name = "吃饭说明")
    private String chifanShuoming;

    /** 住宿说明 */
    @Excel(name = "住宿说明")
    private String zhusuShuoming;

    /** 厂车线路 */
    @Excel(name = "厂车线路")
    private String changcheXianlu;

    /** 职位描述 */
    @Excel(name = "职位描述")
    private String zhiweiMiaoshu;

    /** 创建人id */
    private Long chuangjianrenId;
    /** 创建人 */
    private String chuangjianren;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date chaungjianShijian;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGongchangMendianId(Long gongchangMendianId) 
    {
        this.gongchangMendianId = gongchangMendianId;
    }

    public Long getGongchangMendianId() 
    {
        return gongchangMendianId;
    }
    public void setGongchangMendian(String gongchangMendian)
    {
        this.gongchangMendian = gongchangMendian;
    }

    public String getGongchangMendian()
    {
        return gongchangMendian;
    }
    public void setMingcheng(String mingcheng) 
    {
        this.mingcheng = mingcheng;
    }

    public String getMingcheng() 
    {
        return mingcheng;
    }
    public void setXinziLeixing(String xinziLeixing) 
    {
        this.xinziLeixing = xinziLeixing;
    }

    public String getXinziLeixing() 
    {
        return xinziLeixing;
    }
    public void setXinzi(Double xinzi) 
    {
        this.xinzi = xinzi;
    }

    public Double getXinzi() 
    {
        return xinzi;
    }
    public void setBaochi(String baochi) 
    {
        this.baochi = baochi;
    }

    public String getBaochi() 
    {
        return baochi;
    }
    public void setBaozhu(String baozhu) 
    {
        this.baozhu = baozhu;
    }

    public String getBaozhu() 
    {
        return baozhu;
    }
    public void setJiesuanFangshi(String jiesuanFangshi) 
    {
        this.jiesuanFangshi = jiesuanFangshi;
    }

    public String getJiesuanFangshi() 
    {
        return jiesuanFangshi;
    }
    public void setChuanWuchenyi(String chuanWuchenyi) 
    {
        this.chuanWuchenyi = chuanWuchenyi;
    }

    public String getChuanWuchenyi() 
    {
        return chuanWuchenyi;
    }
    public void setZhaopinRenshu(Integer zhaopinRenshu) 
    {
        this.zhaopinRenshu = zhaopinRenshu;
    }

    public Integer getZhaopinRenshu() 
    {
        return zhaopinRenshu;
    }
    public void setGongqi(Integer gongqi) 
    {
        this.gongqi = gongqi;
    }

    public Integer getGongqi() 
    {
        return gongqi;
    }
    public void setKouya(String kouya) 
    {
        this.kouya = kouya;
    }

    public String getKouya() 
    {
        return kouya;
    }
    public void setXingbieYaoqiu(String xingbieYaoqiu) 
    {
        this.xingbieYaoqiu = xingbieYaoqiu;
    }

    public String getXingbieYaoqiu() 
    {
        return xingbieYaoqiu;
    }
    public void setNianlingYaoqiu(String nianlingYaoqiu) 
    {
        this.nianlingYaoqiu = nianlingYaoqiu;
    }

    public String getNianlingYaoqiu() 
    {
        return nianlingYaoqiu;
    }
    public void setJingyanYaoqiu(String jingyanYaoqiu) 
    {
        this.jingyanYaoqiu = jingyanYaoqiu;
    }

    public String getJingyanYaoqiu() 
    {
        return jingyanYaoqiu;
    }
    public void setXueliYaoqiu(String xueliYaoqiu) 
    {
        this.xueliYaoqiu = xueliYaoqiu;
    }

    public String getXueliYaoqiu() 
    {
        return xueliYaoqiu;
    }
    public void setMianshiCailiao(String mianshiCailiao) 
    {
        this.mianshiCailiao = mianshiCailiao;
    }

    public String getMianshiCailiao() 
    {
        return mianshiCailiao;
    }
    public void setMianshiShijian(String mianshiShijian) 
    {
        this.mianshiShijian = mianshiShijian;
    }

    public String getMianshiShijian() 
    {
        return mianshiShijian;
    }
    public void setXinziJiegou(String xinziJiegou) 
    {
        this.xinziJiegou = xinziJiegou;
    }

    public String getXinziJiegou() 
    {
        return xinziJiegou;
    }
    public void setXinziShuoming(String xinziShuoming) 
    {
        this.xinziShuoming = xinziShuoming;
    }

    public String getXinziShuoming() 
    {
        return xinziShuoming;
    }
    public void setChifanShuoming(String chifanShuoming) 
    {
        this.chifanShuoming = chifanShuoming;
    }

    public String getChifanShuoming() 
    {
        return chifanShuoming;
    }
    public void setZhusuShuoming(String zhusuShuoming) 
    {
        this.zhusuShuoming = zhusuShuoming;
    }

    public String getZhusuShuoming() 
    {
        return zhusuShuoming;
    }
    public void setChangcheXianlu(String changcheXianlu) 
    {
        this.changcheXianlu = changcheXianlu;
    }

    public String getChangcheXianlu() 
    {
        return changcheXianlu;
    }
    public void setZhiweiMiaoshu(String zhiweiMiaoshu) 
    {
        this.zhiweiMiaoshu = zhiweiMiaoshu;
    }

    public String getZhiweiMiaoshu() 
    {
        return zhiweiMiaoshu;
    }
    public void setChuangjianrenId(Long chuangjianrenId) 
    {
        this.chuangjianrenId = chuangjianrenId;
    }

    public Long getChuangjianrenId() 
    {
        return chuangjianrenId;
    }
    public void setChuangjianren(String chuangjianren)
    {
        this.chuangjianren = chuangjianren;
    }

    public String getChuangjianren()
    {
        return chuangjianren;
    }
    public void setChaungjianShijian(Date chaungjianShijian) 
    {
        this.chaungjianShijian = chaungjianShijian;
    }

    public Date getChaungjianShijian() 
    {
        return chaungjianShijian;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gongchangMendianId", getGongchangMendianId())
            .append("mingcheng", getMingcheng())
            .append("xinziLeixing", getXinziLeixing())
            .append("xinzi", getXinzi())
            .append("baochi", getBaochi())
            .append("baozhu", getBaozhu())
            .append("jiesuanFangshi", getJiesuanFangshi())
            .append("chuanWuchenyi", getChuanWuchenyi())
            .append("zhaopinRenshu", getZhaopinRenshu())
            .append("gongqi", getGongqi())
            .append("kouya", getKouya())
            .append("xingbieYaoqiu", getXingbieYaoqiu())
            .append("nianlingYaoqiu", getNianlingYaoqiu())
            .append("jingyanYaoqiu", getJingyanYaoqiu())
            .append("xueliYaoqiu", getXueliYaoqiu())
            .append("mianshiCailiao", getMianshiCailiao())
            .append("mianshiShijian", getMianshiShijian())
            .append("xinziJiegou", getXinziJiegou())
            .append("xinziShuoming", getXinziShuoming())
            .append("chifanShuoming", getChifanShuoming())
            .append("zhusuShuoming", getZhusuShuoming())
            .append("changcheXianlu", getChangcheXianlu())
            .append("zhiweiMiaoshu", getZhiweiMiaoshu())
            .append("chuangjianrenId", getChuangjianrenId())
            .append("chaungjianShijian", getChaungjianShijian())
            .toString();
    }
}
