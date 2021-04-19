package com.ruoyi.jmlg.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jmlg.mapper.JmlgQiyeMapper;
import com.ruoyi.jmlg.domain.JmlgQiye;
import com.ruoyi.jmlg.service.IJmlgQiyeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 企业信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
@Service
public class JmlgQiyeServiceImpl implements IJmlgQiyeService 
{
    @Autowired
    private JmlgQiyeMapper jmlgQiyeMapper;

    /**
     * 查询企业信息
     * 
     * @param id 企业信息ID
     * @return 企业信息
     */
    @Override
    public JmlgQiye selectJmlgQiyeById(Long id)
    {
        return jmlgQiyeMapper.selectJmlgQiyeById(id);
    }

    /**
     * 查询企业信息列表
     * 
     * @param jmlgQiye 企业信息
     * @return 企业信息
     */
    @Override
    public List<JmlgQiye> selectJmlgQiyeByQiyeXinyongDaima(JmlgQiye jmlgQiye)
    {
        return jmlgQiyeMapper.selectJmlgQiyeByQiyeXinyongDaima(jmlgQiye);
    }
    /**
     * 查询企业信息列表
     *
     * @param jmlgQiye 企业信息
     * @return 企业信息
     */
    @Override
    public List<JmlgQiye> selectJmlgQiyeByQiyeMingcheng(JmlgQiye jmlgQiye)
    {
        return jmlgQiyeMapper.selectJmlgQiyeByQiyeMingcheng(jmlgQiye);
    }
    /**
     * 查询企业信息列表
     *
     * @param jmlgQiye 企业信息
     * @return 企业信息
     */
    @Override
    public List<JmlgQiye> selectJmlgQiyeList(JmlgQiye jmlgQiye)
    {
        return jmlgQiyeMapper.selectJmlgQiyeList(jmlgQiye);
    }

    /**
     * 新增企业信息
     * 
     * @param jmlgQiye 企业信息
     * @return 结果
     */
    @Override
    public int insertJmlgQiye(JmlgQiye jmlgQiye)
    {
        return jmlgQiyeMapper.insertJmlgQiye(jmlgQiye);
    }

    /**
     * 修改企业信息
     * 
     * @param jmlgQiye 企业信息
     * @return 结果
     */
    @Override
    public int updateJmlgQiye(JmlgQiye jmlgQiye)
    {
        return jmlgQiyeMapper.updateJmlgQiye(jmlgQiye);
    }

    /**
     * 删除企业信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJmlgQiyeByIds(String ids)
    {
        return jmlgQiyeMapper.deleteJmlgQiyeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除企业信息信息
     * 
     * @param id 企业信息ID
     * @return 结果
     */
    @Override
    public int deleteJmlgQiyeById(Long id)
    {
        return jmlgQiyeMapper.deleteJmlgQiyeById(id);
    }
}
