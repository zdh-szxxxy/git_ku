package com.ruoyi.jmlg.mapper;

import java.util.List;
import com.ruoyi.jmlg.domain.JmlgFenchangMendian;

/**
 * gongchengmendianMapper接口
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public interface JmlgFenchangMendianMapper 
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
     * 删除gongchengmendian
     * 
     * @param id gongchengmendianID
     * @return 结果
     */
    public int deleteJmlgFenchangMendianById(Long id);

    /**
     * 批量删除gongchengmendian
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmlgFenchangMendianByIds(String[] ids);
}
