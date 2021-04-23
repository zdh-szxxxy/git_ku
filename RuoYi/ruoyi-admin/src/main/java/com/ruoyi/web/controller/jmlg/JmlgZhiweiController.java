package com.ruoyi.web.controller.jmlg;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
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
import com.ruoyi.jmlg.domain.JmlgZhiwei;
import com.ruoyi.jmlg.service.IJmlgZhiweiService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 职位信息Controller
 * 
 * @author zhaodanghui
 * @date 2021-04-22
 */
@Controller
@RequestMapping("/jmlg/zhiwei")
public class JmlgZhiweiController extends BaseController
{
    private String prefix = "jmlg/zhiwei";

    @Autowired
    private IJmlgZhiweiService jmlgZhiweiService;

    @RequiresPermissions("jmlg:zhiwei:view")
    @GetMapping()
    public String zhiwei()
    {
        return prefix + "/zhiwei";
    }

    /**
     * 查询职位信息列表
     */
    @RequiresPermissions("jmlg:zhiwei:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JmlgZhiwei jmlgZhiwei)
    {
        startPage();
        List<JmlgZhiwei> list = jmlgZhiweiService.selectJmlgZhiweiList(jmlgZhiwei);
        return getDataTable(list);
    }

    /**
     * 导出职位信息列表
     */
    @RequiresPermissions("jmlg:zhiwei:export")
    @Log(title = "职位信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JmlgZhiwei jmlgZhiwei)
    {
        List<JmlgZhiwei> list = jmlgZhiweiService.selectJmlgZhiweiList(jmlgZhiwei);
        ExcelUtil<JmlgZhiwei> util = new ExcelUtil<JmlgZhiwei>(JmlgZhiwei.class);
        return util.exportExcel(list, "zhiwei");
    }

    /**
     * 新增职位信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存职位信息
     */
    @RequiresPermissions("jmlg:zhiwei:add")
    @Log(title = "职位信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JmlgZhiwei jmlgZhiwei)
    {
        jmlgZhiwei.setChuangjianrenId(ShiroUtils.getUserId());
        jmlgZhiwei.setChaungjianShijian(new Date());
        return toAjax(jmlgZhiweiService.insertJmlgZhiwei(jmlgZhiwei));
    }

    /**
     * 修改职位信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JmlgZhiwei jmlgZhiwei = jmlgZhiweiService.selectJmlgZhiweiById(id);
        mmap.put("jmlgZhiwei", jmlgZhiwei);
        return prefix + "/edit";
    }

    /**
     * 修改保存职位信息
     */
    @RequiresPermissions("jmlg:zhiwei:edit")
    @Log(title = "职位信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JmlgZhiwei jmlgZhiwei)
    {
        return toAjax(jmlgZhiweiService.updateJmlgZhiwei(jmlgZhiwei));
    }

    /**
     * 删除职位信息
     */
    @RequiresPermissions("jmlg:zhiwei:remove")
    @Log(title = "职位信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jmlgZhiweiService.deleteJmlgZhiweiByIds(ids));
    }
}
