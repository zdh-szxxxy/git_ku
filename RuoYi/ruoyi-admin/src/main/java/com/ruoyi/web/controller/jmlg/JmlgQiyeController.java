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
import com.ruoyi.jmlg.domain.JmlgQiye;
import com.ruoyi.jmlg.service.IJmlgQiyeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 企业信息Controller
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
@Controller
@RequestMapping("/jmlg/qiye")
public class JmlgQiyeController extends BaseController
{
    private String prefix = "jmlg/qiye";

    @Autowired
    private IJmlgQiyeService jmlgQiyeService;

    @RequiresPermissions("jmlg:qiye:view")
    @GetMapping()
    public String qiye()
    {
        return prefix + "/qiye";
    }

    /**
     * 查询企业信息列表
     */
    @RequiresPermissions("jmlg:qiye:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JmlgQiye jmlgQiye)
    {
        startPage();
        List<JmlgQiye> list = jmlgQiyeService.selectJmlgQiyeList(jmlgQiye);
        return getDataTable(list);
    }

    /**
     * 导出企业信息列表
     */
    @RequiresPermissions("jmlg:qiye:export")
    @Log(title = "企业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JmlgQiye jmlgQiye)
    {
        List<JmlgQiye> list = jmlgQiyeService.selectJmlgQiyeList(jmlgQiye);
        ExcelUtil<JmlgQiye> util = new ExcelUtil<JmlgQiye>(JmlgQiye.class);
        return util.exportExcel(list, "qiye");
    }

    /**
     * 新增企业信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存企业信息
     */
    @RequiresPermissions("jmlg:qiye:add")
    @Log(title = "企业信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JmlgQiye jmlgQiye)
    {
        jmlgQiye.setId(new Long(0));
        List<JmlgQiye> list=jmlgQiyeService.selectJmlgQiyeByQiyeXinyongDaima(jmlgQiye);
        if(list.size()>0){
            return error("新增企业失败，企业信用代码已存在");
        }
        List<JmlgQiye> list1=jmlgQiyeService.selectJmlgQiyeByQiyeMingcheng(jmlgQiye);
        if(list1.size()>0){
            return error("新增企业失败，企业名称已存在");
        }
        jmlgQiye.setChuangjianrenId(ShiroUtils.getUserId());
        jmlgQiye.setChuangjianShijian(new Date());
        return toAjax(jmlgQiyeService.insertJmlgQiye(jmlgQiye));
    }

    /**
     * 修改企业信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JmlgQiye jmlgQiye = jmlgQiyeService.selectJmlgQiyeById(id);
        mmap.put("jmlgQiye", jmlgQiye);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业信息
     */
    @RequiresPermissions("jmlg:qiye:edit")
    @Log(title = "企业信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JmlgQiye jmlgQiye)
    {
        return toAjax(jmlgQiyeService.updateJmlgQiye(jmlgQiye));
    }

    /**
     * 删除企业信息
     */
    @RequiresPermissions("jmlg:qiye:remove")
    @Log(title = "企业信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jmlgQiyeService.deleteJmlgQiyeByIds(ids));
    }
}
