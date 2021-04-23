package com.ruoyi.jmlg.service;

import java.util.List;
import com.ruoyi.jmlg.domain.JmlgFenchangMendian;

/**
 * gongchengmendianService接口
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public interface IJmlgFenchangMendianService 
{
    /**
     * 查询gongchengmendian
     * 
     * @param id gongchengmendianID
     * @return gongchengmendian
     */
    public JmlgFenchangMendian selectJmlgFenchangMendianById(Long id);

    /**
     * 查询gongchengmendian列表
     * 
     * @param jmlgFenchangMendian gongchengmendian
     * @return gongchengmendian集合
     */
    public List<JmlgFenchangMendian> selectJmlgFenchangMendianList(JmlgFenchangMendian jmlgFenchangMendian);

    /**
     * 新增gongchengmendian
     * 
     * @param jmlgFenchangMendian gongchengmendian
     * @return 结果
     */
    public int insertJmlgFenchangMendian(JmlgFenchangMendian jmlgFenchangMendian);

    /**
     * 修改gongchengmendian
     * 
     * @param jmlgFenchangMendian gongchengmendian
     * @return 结果
     */
    public int updateJmlgFenchangMendian(JmlgFenchangMendian jmlgFenchangMendian);

    /**
     * 批量删除gongchengmendian
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmlgFenchangMendianByIds(String ids);

    /**
     * 删除gongchengmendian信息
     * 
     * @param id gongchengmendianID
     * @return 结果
     */
    public int deleteJmlgFenchangMendianById(Long id);
}
