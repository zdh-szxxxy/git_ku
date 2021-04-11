package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRecruitMapper;
import com.ruoyi.system.domain.SysRecruit;
import com.ruoyi.system.service.ISysRecruitService;
import com.ruoyi.common.core.text.Convert;

/**
 * 招聘信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
@Service
public class SysRecruitServiceImpl implements ISysRecruitService 
{
    @Autowired
    private SysRecruitMapper sysRecruitMapper;

    /**
     * 查询招聘信息
     * 
     * @param recruitId 招聘信息ID
     * @return 招聘信息
     */
    @Override
    public SysRecruit selectSysRecruitById(Long recruitId)
    {
        return sysRecruitMapper.selectSysRecruitById(recruitId);
    }

    /**
     * 查询招聘信息列表
     * 
     * @param sysRecruit 招聘信息
     * @return 招聘信息
     */
    @Override
    public List<SysRecruit> selectSysRecruitList(SysRecruit sysRecruit)
    {
        return sysRecruitMapper.selectSysRecruitList(sysRecruit);
    }

    /**
     * 导入招聘数据
     *
     * @param userList 招聘数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作招聘
     * @return 结果
     */
    @Override
    public String importRecruit(List<SysRecruit> recruitList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(recruitList) || recruitList.size() == 0)
        {
            throw new BusinessException("导入招聘数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SysRecruit Recruit : recruitList)
        {
            try{
                Recruit.setCreateBy(operName);
                Recruit.setStatus("0");
                this.insertSysRecruit(Recruit);
                successNum++;
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、招聘编码 " + Recruit.getRecruitCode() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条");
        }
        return successMsg.toString();
    }


    /**
     * 新增招聘信息
     * 
     * @param sysRecruit 招聘信息
     * @return 结果
     */
    @Override
    public int insertSysRecruit(SysRecruit sysRecruit)
    {
        sysRecruit.setCreateTime(DateUtils.getNowDate());
        return sysRecruitMapper.insertSysRecruit(sysRecruit);
    }

    /**
     * 修改招聘信息
     * 
     * @param sysRecruit 招聘信息
     * @return 结果
     */
    @Override
    public int updateSysRecruit(SysRecruit sysRecruit)
    {
        sysRecruit.setUpdateTime(DateUtils.getNowDate());
        return sysRecruitMapper.updateSysRecruit(sysRecruit);
    }

    /**
     * 删除招聘信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int distributionSysRecruitByIds(String ids,String createby)
    {
        String idsl[]=Convert.toStrArray(ids);
        SysRecruit sr0=new SysRecruit();
        int n=0;
        for(String s:idsl){
            sr0=sysRecruitMapper.selectSysRecruitById(Long.valueOf(s));
            sr0.setCreateBy(createby);
            n+=sysRecruitMapper.updateSysRecruit(sr0);
        }
        return n;
    }
    /**
     * 删除招聘信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysRecruitByIds(String ids)
    {
        return sysRecruitMapper.deleteSysRecruitByIds(Convert.toStrArray(ids));
    }
    /**
     * 删除招聘信息信息
     * 
     * @param recruitId 招聘信息ID
     * @return 结果
     */
    @Override
    public int deleteSysRecruitById(Long recruitId)
    {
        return sysRecruitMapper.deleteSysRecruitById(recruitId);
    }
}
