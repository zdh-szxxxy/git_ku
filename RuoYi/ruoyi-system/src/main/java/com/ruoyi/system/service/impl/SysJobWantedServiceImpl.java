package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysJobWantedMapper;
import com.ruoyi.system.domain.SysJobWanted;
import com.ruoyi.system.service.ISysJobWantedService;
import com.ruoyi.common.core.text.Convert;

/**
 * 求职信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
@Service
public class SysJobWantedServiceImpl implements ISysJobWantedService 
{
    @Autowired
    private SysJobWantedMapper sysJobWantedMapper;

    /**
     * 查询求职信息
     * 
     * @param jobWantedId 求职信息ID
     * @return 求职信息
     */
    @Override
    public SysJobWanted selectSysJobWantedById(Long jobWantedId)
    {
        return sysJobWantedMapper.selectSysJobWantedById(jobWantedId);
    }

    /**
     * 查询求职信息列表
     * 
     * @param sysJobWanted 求职信息
     * @return 求职信息
     */
    @Override
    public List<SysJobWanted> selectSysJobWantedList(SysJobWanted sysJobWanted)
    {
        return sysJobWantedMapper.selectSysJobWantedList(sysJobWanted);
    }

    /**
     * 新增求职信息
     * 
     * @param sysJobWanted 求职信息
     * @return 结果
     */
    @Override
    public int insertSysJobWanted(SysJobWanted sysJobWanted)
    {
        sysJobWanted.setCreateTime(DateUtils.getNowDate());
        return sysJobWantedMapper.insertSysJobWanted(sysJobWanted);
    }

    /**
     * 修改求职信息
     * 
     * @param sysJobWanted 求职信息
     * @return 结果
     */
    @Override
    public int updateSysJobWanted(SysJobWanted sysJobWanted)
    {
        sysJobWanted.setUpdateTime(DateUtils.getNowDate());
        return sysJobWantedMapper.updateSysJobWanted(sysJobWanted);
    }

    /**
     * 删除求职信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysJobWantedByIds(String ids)
    {
        return sysJobWantedMapper.deleteSysJobWantedByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除求职信息信息
     * 
     * @param jobWantedId 求职信息ID
     * @return 结果
     */
    @Override
    public int deleteSysJobWantedById(Long jobWantedId)
    {
        return sysJobWantedMapper.deleteSysJobWantedById(jobWantedId);
    }
}
