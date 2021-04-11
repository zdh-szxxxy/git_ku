package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HeathyCard;
import com.ruoyi.system.service.IHeathyCardService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 健康卡Controller
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@Controller
@RequestMapping("/system/card")
public class HeathyCardController extends BaseController
{
    private String prefix = "system/card";

    @Autowired
    private IHeathyCardService heathyCardService;

    @RequiresPermissions("system:card:view")
    @GetMapping()
    public String card()
    {
        return prefix + "/card";
    }

    /**
     * 查询健康卡列表
     */
    @RequiresPermissions("system:card:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HeathyCard heathyCard)
    {
        startPage();
        List<HeathyCard> list = heathyCardService.selectHeathyCardList(heathyCard);
        return getDataTable(list);
    }

    /**
     * 导出健康卡列表
     */
    @RequiresPermissions("system:card:export")
    @Log(title = "健康卡", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HeathyCard heathyCard)
    {
        List<HeathyCard> list = heathyCardService.selectHeathyCardList(heathyCard);
        ExcelUtil<HeathyCard> util = new ExcelUtil<HeathyCard>(HeathyCard.class);
        return util.exportExcel(list, "card");
    }

    /**
     * 新增健康卡
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存健康卡
     */
    @RequiresPermissions("system:card:add")
    @Log(title = "健康卡", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HeathyCard heathyCard)
    {
        return toAjax(heathyCardService.insertHeathyCard(heathyCard));
    }

    /**
     * 修改健康卡
     */
    @GetMapping("/edit/{healthCardId}")
    public String edit(@PathVariable("healthCardId") Long healthCardId, ModelMap mmap)
    {
        HeathyCard heathyCard = heathyCardService.selectHeathyCardById(healthCardId);
        mmap.put("heathyCard", heathyCard);
        return prefix + "/edit";
    }

    /**
     * 修改保存健康卡
     */
    @RequiresPermissions("system:card:edit")
    @Log(title = "健康卡", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HeathyCard heathyCard)
    {
        return toAjax(heathyCardService.updateHeathyCard(heathyCard));
    }

    /**
     * 删除健康卡
     */
    @RequiresPermissions("system:card:remove")
    @Log(title = "健康卡", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(heathyCardService.deleteHeathyCardByIds(ids));
    }
}
