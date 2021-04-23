package com.ruoyi.jmlg.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jmlg.mapper.JmlgFenchangMendianMapper;
import com.ruoyi.jmlg.domain.JmlgFenchangMendian;
import com.ruoyi.jmlg.service.IJmlgFenchangMendianService;
import com.ruoyi.common.core.text.Convert;

/**
 * gongchengmendianService业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Service
public class JmlgFenchangMendianServiceImpl implements IJmlgFenchangMendianService 
{
    @Autowired
    private JmlgFenchangMendianMapper jmlgFenchangMendianMapper;

    /**
     * 查询gongchengmendian
     * 
     * @param id gongchengmendianID
     * @return gongchengmendian
     */
    @Override
    public JmlgFenchangMendian selectJmlgFenchangMendianById(Long id)
    {
        return jmlgFenchangMendianMapper.selectJmlgFenchangMendianById(id);
    }

    /**
     * 查询gongchengmendian列表
     * 
     * @param jmlgFenchangMendian gongchengmendian
     * @return gongchengmendian
     */
    @Override
    public List<JmlgFenchangMendian> selectJmlgFenchangMendianList(JmlgFenchangMendian jmlgFenchangMendian)
    {
        return jmlgFenchangMendianMapper.selectJmlgFenchangMendianList(jmlgFenchangMendian);
    }

    /**
     * 新增gongchengmendian
     * 
     * @param jmlgFenchangMendian gongchengmendian
     * @return 结果
     */
    @Override
    public int insertJmlgFenchangMendian(JmlgFenchangMendian jmlgFenchangMendian)
    {
        return jmlgFenchangMendianMapper.insertJmlgFenchangMendian(jmlgFenchangMendian);
    }

    /**
     * 修改gongchengmendian
     * 
     * @param jmlgFenchangMendian gongchengmendian
     * @return 结果
     */
    @Override
    public int updateJmlgFenchangMendian(JmlgFenchangMendian jmlgFenchangMendian)
    {
        return jmlgFenchangMendianMapper.updateJmlgFenchangMendian(jmlgFenchangMendian);
    }

    /**
     * 删除gongchengmendian对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJmlgFenchangMendianByIds(String ids)
    {
        return jmlgFenchangMendianMapper.deleteJmlgFenchangMendianByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除gongchengmendian信息
     * 
     * @param id gongchengmendianID
     * @return 结果
     */
    @Override
    public int deleteJmlgFenchangMendianById(Long id)
    {
        return jmlgFenchangMendianMapper.deleteJmlgFenchangMendianById(id);
    }
}
