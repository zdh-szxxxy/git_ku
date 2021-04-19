package com.ruoyi.jmlg.service;

import java.util.List;
import com.ruoyi.jmlg.domain.JmlgQiye;

/**
 * 企业信息Service接口
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
public interface IJmlgQiyeService 
{
    /**
     * 查询企业信息
     * 
     * @param id 企业信息ID
     * @return 企业信息
     */
    public JmlgQiye selectJmlgQiyeById(Long id);

    /**
     * 查询企业信息列表
     * 
     * @param jmlgQiye 企业信息
     * @return 企业信息
     */
    public JmlgQiye selectJmlgQiyeByQiyeXinyongDaima(JmlgQiye jmlgQiye);
    /**
     * 查询企业信息列表
     *
     * @param jmlgQiye 企业信息
     * @return 企业信息集合
     */
    public List<JmlgQiye> selectJmlgQiyeList(JmlgQiye jmlgQiye);
    /**
     * 新增企业信息
     * 
     * @param jmlgQiye 企业信息
     * @return 结果
     */
    public int insertJmlgQiye(JmlgQiye jmlgQiye);

    /**
     * 修改企业信息
     * 
     * @param jmlgQiye 企业信息
     * @return 结果
     */
    public int updateJmlgQiye(JmlgQiye jmlgQiye);

    /**
     * 批量删除企业信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmlgQiyeByIds(String ids);

    /**
     * 删除企业信息信息
     * 
     * @param id 企业信息ID
     * @return 结果
     */
    public int deleteJmlgQiyeById(Long id);
}
