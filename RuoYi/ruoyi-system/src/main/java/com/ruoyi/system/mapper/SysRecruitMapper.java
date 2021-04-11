package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRecruit;

/**
 * 招聘信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
public interface SysRecruitMapper 
{
    /**
     * 查询招聘信息
     * 
     * @param recruitId 招聘信息ID
     * @return 招聘信息
     */
    public SysRecruit selectSysRecruitById(Long recruitId);

    /**
     * 查询招聘信息列表
     * 
     * @param sysRecruit 招聘信息
     * @return 招聘信息集合
     */
    public List<SysRecruit> selectSysRecruitList(SysRecruit sysRecruit);

    /**
     * 新增招聘信息
     * 
     * @param sysRecruit 招聘信息
     * @return 结果
     */
    public int insertSysRecruit(SysRecruit sysRecruit);

    /**
     * 修改招聘信息
     * 
     * @param sysRecruit 招聘信息
     * @return 结果
     */
    public int updateSysRecruit(SysRecruit sysRecruit);

    /**
     * 删除招聘信息
     * 
     * @param recruitId 招聘信息ID
     * @return 结果
     */
    public int deleteSysRecruitById(Long recruitId);

    /**
     * 批量删除招聘信息
     * 
     * @param recruitIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRecruitByIds(String[] recruitIds);
}
