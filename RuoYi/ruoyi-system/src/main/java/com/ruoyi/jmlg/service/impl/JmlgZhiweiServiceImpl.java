package com.ruoyi.jmlg.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jmlg.mapper.JmlgZhiweiMapper;
import com.ruoyi.jmlg.domain.JmlgZhiwei;
import com.ruoyi.jmlg.service.IJmlgZhiweiService;
import com.ruoyi.common.core.text.Convert;

/**
 * 职位信息Service业务层处理
 * 
 * @author zhaodanghui
 * @date 2021-04-22
 */
@Service
public class JmlgZhiweiServiceImpl implements IJmlgZhiweiService 
{
    @Autowired
    private JmlgZhiweiMapper jmlgZhiweiMapper;

    /**
     * 查询职位信息
     * 
     * @param id 职位信息ID
     * @return 职位信息
     */
    @Override
    public JmlgZhiwei selectJmlgZhiweiById(Long id)
    {
        return jmlgZhiweiMapper.selectJmlgZhiweiById(id);
    }

    /**
     * 查询职位信息列表
     * 
     * @param jmlgZhiwei 职位信息
     * @return 职位信息
     */
    @Override
    public List<JmlgZhiwei> selectJmlgZhiweiList(JmlgZhiwei jmlgZhiwei)
    {
        return jmlgZhiweiMapper.selectJmlgZhiweiList(jmlgZhiwei);
    }

    /**
     * 新增职位信息
     * 
     * @param jmlgZhiwei 职位信息
     * @return 结果
     */
    @Override
    public int insertJmlgZhiwei(JmlgZhiwei jmlgZhiwei)
    {
        return jmlgZhiweiMapper.insertJmlgZhiwei(jmlgZhiwei);
    }

    /**
     * 修改职位信息
     * 
     * @param jmlgZhiwei 职位信息
     * @return 结果
     */
    @Override
    public int updateJmlgZhiwei(JmlgZhiwei jmlgZhiwei)
    {
        return jmlgZhiweiMapper.updateJmlgZhiwei(jmlgZhiwei);
    }

    /**
     * 删除职位信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJmlgZhiweiByIds(String ids)
    {
        return jmlgZhiweiMapper.deleteJmlgZhiweiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除职位信息信息
     * 
     * @param id 职位信息ID
     * @return 结果
     */
    @Override
    public int deleteJmlgZhiweiById(Long id)
    {
        return jmlgZhiweiMapper.deleteJmlgZhiweiById(id);
    }
}
