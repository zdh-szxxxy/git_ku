package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysEnterpriseMapper;
import com.ruoyi.system.domain.SysEnterprise;
import com.ruoyi.system.service.ISysEnterpriseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 企业Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-20
 */
@Service
public class SysEnterpriseServiceImpl implements ISysEnterpriseService 
{
    @Autowired
    private SysEnterpriseMapper sysEnterpriseMapper;


    /**
     * 查询企业
     * 
     * @param enterpriseId 企业ID
     * @return 企业
     */
    @Override
    public SysEnterprise selectSysEnterpriseById(Long enterpriseId)
    {
        return sysEnterpriseMapper.selectSysEnterpriseById(enterpriseId);
    }

    /**
     * 查询企业
     *
     * @param createBy 企业ID
     * @return 企业
     */
    @Override
    public SysEnterprise selectSysEnterpriseByCreateBy(String createBy)
    {
        return sysEnterpriseMapper.selectSysEnterpriseByCreateBy(createBy);
    }

    /**
     * 查询企业列表
     * 
     * @param sysEnterprise 企业
     * @return 企业
     */
    @Override
    public List<SysEnterprise> selectSysEnterpriseList(SysEnterprise sysEnterprise)
    {
        return sysEnterpriseMapper.selectSysEnterpriseList(sysEnterprise);
    }

    /**
     * 新增企业
     * 
     * @param sysEnterprise 企业
     * @return 结果
     */
    @Override
    public int insertSysEnterprise(SysEnterprise sysEnterprise)
    {
        sysEnterprise.setCreateTime(DateUtils.getNowDate());
        return sysEnterpriseMapper.insertSysEnterprise(sysEnterprise);
    }

    /**
     * 修改企业
     * 
     * @param sysEnterprise 企业
     * @return 结果
     */
    @Override
    public int updateSysEnterprise(SysEnterprise sysEnterprise)
    {
        sysEnterprise.setUpdateTime(DateUtils.getNowDate());
        return sysEnterpriseMapper.updateSysEnterprise(sysEnterprise);
    }

    /**
     * 删除企业对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysEnterpriseByIds(String ids)
    {
        return sysEnterpriseMapper.deleteSysEnterpriseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除企业信息
     * 
     * @param enterpriseId 企业ID
     * @return 结果
     */
    @Override
    public int deleteSysEnterpriseById(Long enterpriseId)
    {
        return sysEnterpriseMapper.deleteSysEnterpriseById(enterpriseId);
    }
}
