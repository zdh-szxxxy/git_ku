package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysEnterprise;

/**
 * 企业Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-20
 */
public interface SysEnterpriseMapper 
{
    /**
     * 查询企业
     * 
     * @param enterpriseId 企业ID
     * @return 企业
     */
    public SysEnterprise selectSysEnterpriseById(Long enterpriseId);

    /**
     * 查询企业
     *
     * @param createBy 创建人
     * @return 企业
     */
    public SysEnterprise selectSysEnterpriseByCreateBy(String createBy);

    /**
     * 查询企业列表
     * 
     * @param sysEnterprise 企业
     * @return 企业集合
     */
    public List<SysEnterprise> selectSysEnterpriseList(SysEnterprise sysEnterprise);

    /**
     * 新增企业
     * 
     * @param sysEnterprise 企业
     * @return 结果
     */
    public int insertSysEnterprise(SysEnterprise sysEnterprise);

    /**
     * 修改企业
     * 
     * @param sysEnterprise 企业
     * @return 结果
     */
    public int updateSysEnterprise(SysEnterprise sysEnterprise);

    /**
     * 删除企业
     * 
     * @param enterpriseId 企业ID
     * @return 结果
     */
    public int deleteSysEnterpriseById(Long enterpriseId);

    /**
     * 批量删除企业
     * 
     * @param enterpriseIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysEnterpriseByIds(String[] enterpriseIds);
}
