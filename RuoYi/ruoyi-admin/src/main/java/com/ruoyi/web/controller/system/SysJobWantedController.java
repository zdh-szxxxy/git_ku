package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.service.ISysRoleService;
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
import com.ruoyi.system.domain.SysJobWanted;
import com.ruoyi.system.service.ISysJobWantedService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 求职信息Controller
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
@Controller
@RequestMapping("/system/wanted")
public class SysJobWantedController extends BaseController
{
    private String prefix = "system/wanted";

    @Autowired
    private ISysJobWantedService sysJobWantedService;

    @Autowired
    private ISysRoleService sysRoleService;

    @RequiresPermissions("system:wanted:view")
    @GetMapping()
    public String wanted()
    {
        return prefix + "/wanted";
    }

    /**
     * 查询求职信息列表
     */
    @RequiresPermissions("system:wanted:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysJobWanted sysJobWanted)
    {
        startPage();
        sysJobWanted.setCreateBy("");
        List<SysRole> srl=sysRoleService.selectRolesByUserId(ShiroUtils.getUserId());
        System.out.println(ShiroUtils.getUserId());
        for(SysRole sr:srl){
            System.out.println(sr.toString());
            if(sr.isFlag() && sr.getRoleId()==Long.valueOf(6)){
                sysJobWanted.setCreateBy(ShiroUtils.getLoginName());
                break;
            }
        }
        List<SysJobWanted> list = sysJobWantedService.selectSysJobWantedList(sysJobWanted);
        return getDataTable(list);
    }

    /**
     * 导出求职信息列表
     */
    @RequiresPermissions("system:wanted:export")
    @Log(title = "求职信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysJobWanted sysJobWanted)
    {
        List<SysJobWanted> list = sysJobWantedService.selectSysJobWantedList(sysJobWanted);
        ExcelUtil<SysJobWanted> util = new ExcelUtil<SysJobWanted>(SysJobWanted.class);
        return util.exportExcel(list, "wanted");
    }

    /**
     * 新增求职信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存求职信息
     */
    @RequiresPermissions("system:wanted:add")
    @Log(title = "求职信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysJobWanted sysJobWanted)
    {
        sysJobWanted.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(sysJobWantedService.insertSysJobWanted(sysJobWanted));
    }

    /**
     * 修改求职信息
     */
    @GetMapping("/edit/{jobWantedId}")
    public String edit(@PathVariable("jobWantedId") Long jobWantedId, ModelMap mmap)
    {
        SysJobWanted sysJobWanted = sysJobWantedService.selectSysJobWantedById(jobWantedId);
        mmap.put("sysJobWanted", sysJobWanted);
        return prefix + "/edit";
    }

    /**
     * 修改保存求职信息
     */
    @RequiresPermissions("system:wanted:edit")
    @Log(title = "求职信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysJobWanted sysJobWanted)
    {
        return toAjax(sysJobWantedService.updateSysJobWanted(sysJobWanted));
    }

    /**
     * 删除求职信息
     */
    @RequiresPermissions("system:wanted:remove")
    @Log(title = "求职信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysJobWantedService.deleteSysJobWantedByIds(ids));
    }
}
