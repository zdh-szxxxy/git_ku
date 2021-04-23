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
import com.ruoyi.jmlg.domain.JmlgFenchangMendian;
import com.ruoyi.jmlg.service.IJmlgFenchangMendianService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * gongchengmendianController
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/jmlg/gongchengmendian")
public class JmlgFenchangMendianController extends BaseController
{
    private String prefix = "jmlg/gongchengmendian";

    @Autowired
    private IJmlgFenchangMendianService jmlgFenchangMendianService;

    @RequiresPermissions("jmlg:gongchengmendian:view")
    @GetMapping()
    public String gongchengmendian()
    {
        return prefix + "/gongchengmendian";
    }

    /**
     * 查询gongchengmendian列表
     */
    @RequiresPermissions("jmlg:gongchengmendian:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JmlgFenchangMendian jmlgFenchangMendian)
    {
        startPage();
        List<JmlgFenchangMendian> list = jmlgFenchangMendianService.selectJmlgFenchangMendianList(jmlgFenchangMendian);
        return getDataTable(list);
    }
    /**
     * 选择工厂门店信息列表
     */
    @GetMapping("/selectGongchangMendian")
    public String selectGongchangMendian()
    {
        return prefix+"/selectGongchangMendian";
    }
    /**
     * 导出gongchengmendian列表
     */
    @RequiresPermissions("jmlg:gongchengmendian:export")
    @Log(title = "gongchengmendian", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JmlgFenchangMendian jmlgFenchangMendian)
    {
        List<JmlgFenchangMendian> list = jmlgFenchangMendianService.selectJmlgFenchangMendianList(jmlgFenchangMendian);
        ExcelUtil<JmlgFenchangMendian> util = new ExcelUtil<JmlgFenchangMendian>(JmlgFenchangMendian.class);
        return util.exportExcel(list, "gongchengmendian");
    }

    /**
     * 新增gongchengmendian
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存gongchengmendian
     */
    @RequiresPermissions("jmlg:gongchengmendian:add")
    @Log(title = "gongchengmendian", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JmlgFenchangMendian jmlgFenchangMendian)
    {
        jmlgFenchangMendian.setChuangjianrenId(ShiroUtils.getUserId());
        jmlgFenchangMendian.setChangjianShijian(new Date());
        return toAjax(jmlgFenchangMendianService.insertJmlgFenchangMendian(jmlgFenchangMendian));
    }

    /**
     * 修改gongchengmendian
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JmlgFenchangMendian jmlgFenchangMendian = jmlgFenchangMendianService.selectJmlgFenchangMendianById(id);
        mmap.put("jmlgFenchangMendian", jmlgFenchangMendian);
        return prefix + "/edit";
    }

    /**
     * 修改保存gongchengmendian
     */
    @RequiresPermissions("jmlg:gongchengmendian:edit")
    @Log(title = "gongchengmendian", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JmlgFenchangMendian jmlgFenchangMendian)
    {
        return toAjax(jmlgFenchangMendianService.updateJmlgFenchangMendian(jmlgFenchangMendian));
    }

    /**
     * 删除gongchengmendian
     */
    @RequiresPermissions("jmlg:gongchengmendian:remove")
    @Log(title = "gongchengmendian", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jmlgFenchangMendianService.deleteJmlgFenchangMendianByIds(ids));
    }
}
