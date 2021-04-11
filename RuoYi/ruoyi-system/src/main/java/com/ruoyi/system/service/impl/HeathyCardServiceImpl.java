package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HeathyCardMapper;
import com.ruoyi.system.domain.HeathyCard;
import com.ruoyi.system.service.IHeathyCardService;
import com.ruoyi.common.core.text.Convert;

/**
 * 健康卡Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@Service
public class HeathyCardServiceImpl implements IHeathyCardService 
{
    @Autowired
    private HeathyCardMapper heathyCardMapper;

    /**
     * 查询健康卡
     * 
     * @param healthCardId 健康卡ID
     * @return 健康卡
     */
    @Override
    public HeathyCard selectHeathyCardById(Long healthCardId)
    {
        return heathyCardMapper.selectHeathyCardById(healthCardId);
    }

    /**
     * 查询健康卡列表
     * 
     * @param heathyCard 健康卡
     * @return 健康卡
     */
    @Override
    public List<HeathyCard> selectHeathyCardList(HeathyCard heathyCard)
    {
        return heathyCardMapper.selectHeathyCardList(heathyCard);
    }

    /**
     * 新增健康卡
     * 
     * @param heathyCard 健康卡
     * @return 结果
     */
    @Override
    public int insertHeathyCard(HeathyCard heathyCard)
    {
        heathyCard.setCreateTime(DateUtils.getNowDate());
        return heathyCardMapper.insertHeathyCard(heathyCard);
    }

    /**
     * 修改健康卡
     * 
     * @param heathyCard 健康卡
     * @return 结果
     */
    @Override
    public int updateHeathyCard(HeathyCard heathyCard)
    {
        return heathyCardMapper.updateHeathyCard(heathyCard);
    }

    /**
     * 删除健康卡对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHeathyCardByIds(String ids)
    {
        return heathyCardMapper.deleteHeathyCardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除健康卡信息
     * 
     * @param healthCardId 健康卡ID
     * @return 结果
     */
    @Override
    public int deleteHeathyCardById(Long healthCardId)
    {
        return heathyCardMapper.deleteHeathyCardById(healthCardId);
    }
}
