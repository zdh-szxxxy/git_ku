package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysJobWanted;

/**
 * 求职信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
public interface SysJobWantedMapper 
{
    /**
     * 查询求职信息
     * 
     * @param jobWantedId 求职信息ID
     * @return 求职信息
     */
    public SysJobWanted selectSysJobWantedById(Long jobWantedId);

    /**
     * 查询求职信息列表
     * 
     * @param sysJobWanted 求职信息
     * @return 求职信息集合
     */
    public List<SysJobWanted> selectSysJobWantedList(SysJobWanted sysJobWanted);

    /**
     * 新增求职信息
     * 
     * @param sysJobWanted 求职信息
     * @return 结果
     */
    public int insertSysJobWanted(SysJobWanted sysJobWanted);

    /**
     * 修改求职信息
     * 
     * @param sysJobWanted 求职信息
     * @return 结果
     */
    public int updateSysJobWanted(SysJobWanted sysJobWanted);

    /**
     * 删除求职信息
     * 
     * @param jobWantedId 求职信息ID
     * @return 结果
     */
    public int deleteSysJobWantedById(Long jobWantedId);

    /**
     * 批量删除求职信息
     * 
     * @param jobWantedIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysJobWantedByIds(String[] jobWantedIds);
}
