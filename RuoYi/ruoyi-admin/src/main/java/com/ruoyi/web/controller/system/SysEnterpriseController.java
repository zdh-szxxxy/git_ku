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
import com.ruoyi.system.domain.SysEnterprise;
import com.ruoyi.system.service.ISysEnterpriseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 企业Controller
 *
 * @author ruoyi
 * @date 2021-02-20
 */
@Controller
@RequestMapping("/system/enterprise")
public class SysEnterpriseController extends BaseController
{
    private String prefix = "system/enterprise";

    @Autowired
    private ISysEnterpriseService sysEnterpriseService;

    @Autowired
    private ISysRoleService sysRoleService;

    @RequiresPermissions("system:enterprise:view")
    @GetMapping()
    public String enterprise()
    {
        return prefix + "/enterprise";
    }

    /**
     * 查询企业列表
     */
    @RequiresPermissions("system:enterprise:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysEnterprise sysEnterprise)
    {
        startPage();
        List<SysRole> sr10=sysRoleService.selectRolesByUserId(ShiroUtils.getUserId());
        for(SysRole sr0:sr10){
            if(sr0.isFlag() && sr0.getRoleId()>3){
                sysEnterprise.setCreateBy(ShiroUtils.getLoginName());
            }
        }
        List<SysEnterprise> list = sysEnterpriseService.selectSysEnterpriseList(sysEnterprise);
        return getDataTable(list);
    }

    /**
     * 导出企业列表
     */
    @RequiresPermissions("system:enterprise:export")
    @Log(title = "企业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysEnterprise sysEnterprise)
    {
        List<SysEnterprise> list = sysEnterpriseService.selectSysEnterpriseList(sysEnterprise);
        ExcelUtil<SysEnterprise> util = new ExcelUtil<SysEnterprise>(SysEnterprise.class);
        return util.exportExcel(list, "enterprise");
    }

    /**
     * 新增企业
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存企业
     */
    @RequiresPermissions("system:enterprise:add")
    @Log(title = "企业", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysEnterprise sysEnterprise)
    {
        sysEnterprise.setCreateBy(ShiroUtils.getLoginName());
        sysEnterprise.setParentId(Long.parseLong("0"));
        sysEnterprise.setAncestors("0");
        return toAjax(sysEnterpriseService.insertSysEnterprise(sysEnterprise));
    }

    /**
     * 修改企业
     */
    @GetMapping("/edit/{deptId}")
    public String edit(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        System.out.println("1111-----"+deptId+"-------aaaa2222");
        SysEnterprise sysEnterprise = sysEnterpriseService.selectSysEnterpriseById(deptId);
        mmap.put("sysEnterprise", sysEnterprise);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业
     */
    @RequiresPermissions("system:enterprise:edit")
    @Log(title = "企业", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysEnterprise sysEnterprise)
    {
        return toAjax(sysEnterpriseService.updateSysEnterprise(sysEnterprise));
    }

    /**
     * 删除企业
     */
    @RequiresPermissions("system:enterprise:remove")
    @Log(title = "企业", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysEnterpriseService.deleteSysEnterpriseByIds(ids));
    }
}
