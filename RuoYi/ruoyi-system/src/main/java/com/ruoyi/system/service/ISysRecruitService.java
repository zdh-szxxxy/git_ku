package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.SysRecruit;

/**
 * 招聘信息Service接口
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
public interface ISysRecruitService 
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
     * 导入招聘数据
     *
     * @param userList 招聘数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作招聘
     * @return 结果
     */
    public String importRecruit(List<SysRecruit> userList, Boolean isUpdateSupport, String operName);
    
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
     * 批量分配招聘信息
     * 
     * @param ids 需要分配的数据ID
     * @return 结果
     */
    public int distributionSysRecruitByIds(String ids,String createby);
    /**
     * 批量删除招聘信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRecruitByIds(String ids);
    /**
     * 删除招聘信息信息
     * 
     * @param recruitId 招聘信息ID
     * @return 结果
     */
    public int deleteSysRecruitById(Long recruitId);
}
