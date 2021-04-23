package com.ruoyi.jmlg.mapper;

import java.util.List;
import com.ruoyi.jmlg.domain.JmlgZhiwei;

/**
 * 职位信息Mapper接口
 * 
 * @author zhaodanghui
 * @date 2021-04-22
 */
public interface JmlgZhiweiMapper 
{
    /**
     * 查询职位信息
     * 
     * @param id 职位信息ID
     * @return 职位信息
     */
    public JmlgZhiwei selectJmlgZhiweiById(Long id);

    /**
     * 查询职位信息列表
     * 
     * @param jmlgZhiwei 职位信息
     * @return 职位信息集合
     */
    public List<JmlgZhiwei> selectJmlgZhiweiList(JmlgZhiwei jmlgZhiwei);

    /**
     * 新增职位信息
     * 
     * @param jmlgZhiwei 职位信息
     * @return 结果
     */
    public int insertJmlgZhiwei(JmlgZhiwei jmlgZhiwei);

    /**
     * 修改职位信息
     * 
     * @param jmlgZhiwei 职位信息
     * @return 结果
     */
    public int updateJmlgZhiwei(JmlgZhiwei jmlgZhiwei);

    /**
     * 删除职位信息
     * 
     * @param id 职位信息ID
     * @return 结果
     */
    public int deleteJmlgZhiweiById(Long id);

    /**
     * 批量删除职位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmlgZhiweiByIds(String[] ids);
}
