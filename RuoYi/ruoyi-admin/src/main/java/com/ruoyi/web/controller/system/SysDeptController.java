package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.SysEnterprise;
import com.ruoyi.system.domain.SysRecruit;
import com.ruoyi.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;

/**
 * 门店信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/dept")
public class SysDeptController extends BaseController
{
    private String prefix = "system/dept";

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysEnterpriseService sysEnterpriseService;

    @Autowired
    private ISysRecruitService sysRecruitService;

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private ISysUserService sysUserService;

    @RequiresPermissions("system:dept:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/dept";
    }

    @RequiresPermissions("system:dept:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysDept dept)
    {
        dept.setCreateBy("");
        List<SysRole> sr=roleService.selectRolesByUserId(ShiroUtils.getUserId());
        for(SysRole s:sr){
            if(s.isFlag() && s.getRoleId()>Long.valueOf(3)){
                dept.setCreateBy(ShiroUtils.getLoginName());
                break;
            }
        }
        List<SysDept> deptList = deptService.selectDeptList(dept);
        return getDataTable(deptList);
    }
    /**
     * 查询岗位
     */
    @GetMapping("/see_post/{deptId}")
    public String detail(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        SysDept sysDept=sysDeptService.selectDeptById(deptId);
        SysRecruit sysRecruit=new SysRecruit();
        sysRecruit.setDeptName(sysDept.getDeptName());
        //mmap.put("deptName",sysDept.getDeptName());
        mmap.put("deptName",deptId);
        return "system/dept/see_post";
    }
    /**
     * 分配岗位
     */
    @RequiresPermissions("system:dept:distribution_post")
    @GetMapping("/distribution_post/{deptId}")
    public String distribution(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        SysDept sysDept=sysDeptService.selectDeptById(deptId);
        SysUser sysUser=new SysUser();
        sysUser.setCreateBy(ShiroUtils.getLoginName());
        List<SysUser> sysUserList=sysUserService.selectUserList(sysUser);
        String createby="";
        for(SysUser sysUser1:sysUserList){
            if(sysUser1.getDeptId().equals(deptId)){
                createby=sysUser1.getLoginName();
            }
        }
        SysRecruit sysRecruit=new SysRecruit();
        sysRecruit.setDeptName(sysDept.getDeptName());
        mmap.put("deptName",sysDept.getDeptName());
        //mmap.put("createby",createby);
        mmap.put("createby",deptId);
        SysUser sysUser1=ShiroUtils.getSysUser();
        //sysUser1.setRemark(createby);
        sysUser1.setRemark(deptId.toString());
        ShiroUtils.setSysUser(sysUser1);
        return "system/dept/distribution_post";
    }
    /**
     * 新增门店
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        SysEnterprise sd=sysEnterpriseService.selectSysEnterpriseByCreateBy(ShiroUtils.getLoginName());
        mmap.put("dept", sd);
        return prefix + "/add";
    }

    /**
     * 新增保存门店
     */
    @Log(title = "门店管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:dept:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysDept dept)
    {
        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept)))
        {
            return error("新增门店'" + dept.getDeptName() + "'失败，门店名称已存在");
        }
        dept.setCreateBy(ShiroUtils.getLoginName());
        dept.setEnterpriseCode("-");
        dept.setIndustry("-");
        dept.setAlias("-");
        return toAjax(deptService.insertDept(dept));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{deptId}")
    public String edit(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        SysDept dept = deptService.selectDeptById(deptId);
        if (StringUtils.isNotNull(dept) && 100L == deptId)
        {
            dept.setParentName("无");
        }
        mmap.put("dept", dept);
        return prefix + "/edit";
    }

    /**
     * 保存
     */
    @Log(title = "门店管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:dept:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysDept dept)
    {
        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept)))
        {
            return error("修改门店'" + dept.getDeptName() + "'失败，门店名称已存在");
        }
        else if (dept.getParentId().equals(dept.getDeptId()))
        {
            return error("修改门店'" + dept.getDeptName() + "'失败，上级门店不能是自己");
        }
        else if (StringUtils.equals(UserConstants.DEPT_DISABLE, dept.getStatus())
                && deptService.selectNormalChildrenDeptById(dept.getDeptId()) > 0)
        {
            return AjaxResult.error("该门店包含未停用的子门店！");
        }
        dept.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(deptService.updateDept(dept));
    }
    /**
     * 删除企业
     */
    //@RequiresPermissions("system:enterprise:remove")
    @Log(title = "门店管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(deptService.deleteDeptById(Long.parseLong(ids)));
    }

    /**
     * 删除
     */
    @Log(title = "门店管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:dept:remove")
    @GetMapping("/remove/{deptId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("deptId") Long deptId)
    {
        if (deptService.selectDeptCount(deptId) > 0)
        {
            return AjaxResult.warn("存在下级门店,不允许删除");
        }
        if (deptService.checkDeptExistUser(deptId))
        {
            return AjaxResult.warn("门店存在用户,不允许删除");
        }
        return toAjax(deptService.deleteDeptById(deptId));
    }

    /**
     * 校验门店名称
     */
    @PostMapping("/checkDeptNameUnique")
    @ResponseBody
    public String checkDeptNameUnique(SysDept dept)
    {
        return deptService.checkDeptNameUnique(dept);
    }

    /**
     * 选择门店树
     * 
     * @param deptId 门店ID
     * @param excludeId 排除ID
     */
    @GetMapping(value = { "/selectDeptTree/{deptId}", "/selectDeptTree/{deptId}/{excludeId}" })
    public String selectDeptTree(@PathVariable("deptId") Long deptId,
            @PathVariable(value = "excludeId", required = false) String excludeId, ModelMap mmap)
    {
        SysDept sd=deptService.selectDeptById(deptId);
        mmap.put("dept", sd);
        //mmap.put("excludeId", excludeId);
        return prefix + "/tree";
    }
    @GetMapping(value = { "/selectDeptsTree/{deptId}", "/selectDeptsTree/{deptId}/{excludeId}" })
    public String selectDeptsTree(@PathVariable("deptId") Long deptId,
                                 @PathVariable(value = "excludeId", required = false) String excludeId, ModelMap mmap)
    {
        SysDept sd=deptService.selectDeptById(deptId);
        mmap.put("dept", sd);
        //mmap.put("excludeId", excludeId);
        return prefix + "/trees";
    }
    /**
     * 加载门店列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        SysDept sd=new SysDept();
        sd.setCreateBy(ShiroUtils.getLoginName());
        List<Ztree> ztrees = deptService.selectDeptTree(sd);
        return ztrees;
    }
    @GetMapping("/treesData")
    @ResponseBody
    public List<Ztree> treesData()
    {
        SysDept sd=new SysDept();
        sd.setCreateBy(ShiroUtils.getLoginName());
        List<Ztree> ztrees = deptService.selectDeptsTree(sd);
        return ztrees;
    }
    /**
     * 加载门店列表树（排除下级）
     */
    @GetMapping("/treeData/{excludeId}")
    @ResponseBody
    public List<Ztree> treeDataExcludeChild(@PathVariable(value = "excludeId", required = false) Long excludeId)
    {
        SysDept sd=new SysDept();
        sd.setCreateBy("");
        List<SysRole> srl=roleService.selectRolesByUserId(ShiroUtils.getUserId());
        for(SysRole sr:srl){
            if(sr.isFlag() && sr.getRoleId()>=Long.valueOf(103)){
                sd.setCreateBy(ShiroUtils.getLoginName());
                break;
            }
        }
        List<Ztree> ztrees = deptService.selectDeptTree(sd);
        return ztrees;
    }
    @GetMapping("/treesData/{excludeId}")
    @ResponseBody
    public List<Ztree> treesDataExcludeChild(@PathVariable(value = "excludeId", required = false) Long excludeId)
    {
        SysDept sd=new SysDept();
        sd.setCreateBy("");
        List<SysRole> srl=roleService.selectRolesByUserId(ShiroUtils.getUserId());
        for(SysRole sr:srl){
            if(sr.isFlag() && sr.getRoleId()>=Long.valueOf(103)){
                sd.setCreateBy(ShiroUtils.getLoginName());
                break;
            }
        }
        List<Ztree> ztrees = deptService.selectDeptsTree(sd);
        return ztrees;
    }
    /**
     * 加载角色门店（数据权限）列表树
     */
    @GetMapping("/roleDeptTreeData")
    @ResponseBody
    public List<Ztree> deptTreeData(SysRole role)
    {
        List<Ztree> ztrees = deptService.roleDeptTreeData(role);
        return ztrees;
    }
}
