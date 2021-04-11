package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HeathyCard;

/**
 * 健康卡Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public interface HeathyCardMapper 
{
    /**
     * 查询健康卡
     * 
     * @param healthCardId 健康卡ID
     * @return 健康卡
     */
    public HeathyCard selectHeathyCardById(Long healthCardId);

    /**
     * 查询健康卡列表
     * 
     * @param heathyCard 健康卡
     * @return 健康卡集合
     */
    public List<HeathyCard> selectHeathyCardList(HeathyCard heathyCard);

    /**
     * 新增健康卡
     * 
     * @param heathyCard 健康卡
     * @return 结果
     */
    public int insertHeathyCard(HeathyCard heathyCard);

    /**
     * 修改健康卡
     * 
     * @param heathyCard 健康卡
     * @return 结果
     */
    public int updateHeathyCard(HeathyCard heathyCard);

    /**
     * 删除健康卡
     * 
     * @param healthCardId 健康卡ID
     * @return 结果
     */
    public int deleteHeathyCardById(Long healthCardId);

    /**
     * 批量删除健康卡
     * 
     * @param healthCardIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHeathyCardByIds(String[] healthCardIds);
}
