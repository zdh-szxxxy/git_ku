package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.service.ISysEnterpriseService;
import com.ruoyi.system.service.ISysRoleService;
import com.sun.jna.platform.win32.WinNT;
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
import com.ruoyi.system.domain.SysRecruit;
import com.ruoyi.system.service.ISysRecruitService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;


/**
 * 招聘信息Controller
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
@Controller
@RequestMapping("/system/recruit")
public class SysRecruitController extends BaseController
{
    private String prefix = "system/recruit";

    @Autowired
    private ISysRecruitService sysRecruitService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysEnterpriseService sysEnterpriseService;

    @RequiresPermissions("system:recruit:view")
    @GetMapping()
    public String recruit()
    {
        return prefix + "/recruit";
    }

    /**
     * 查询招聘信息列表
     */
    @RequiresPermissions("system:recruit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysRecruit sysRecruit)
    {
        List<SysRole> srl=sysRoleService.selectRolesByUserId(ShiroUtils.getUserId());
        int rose=0;
        for(SysRole sr:srl){
            if(sr.isFlag()){
                switch (sr.getRoleId().intValue()){
                    case 3:rose=3;break;
                    case 5:rose=5;
                        break;}
                break;
            }
        }
        startPage();
        sysRecruit.setCreateBy("");
        sysRecruit.setParentName("");
        sysRecruit.setCreateBy(sysRecruit.getDeptName());
        sysRecruit.setDeptName("");

        List<SysRecruit> list0=new ArrayList<>();
        List<SysRecruit> list2=new ArrayList<>();
        List<SysRecruit> list1 = sysRecruitService.selectSysRecruitList(sysRecruit);
        if(StringUtils.isNotEmpty(sysRecruit.getX())){
            double x=Double.valueOf(sysRecruit.getX());
            double y=Double.valueOf(sysRecruit.getY());
            for(SysRecruit sr0:list1){
                sr0.setDistance((float)getDistance(x,y,sr0.getLongitude(),sr0.getLatitude()));
                list0.add(sr0);
            }
            Collections.sort(list0, new Comparator<SysRecruit>() {
                @Override
                public int compare(SysRecruit o1, SysRecruit o2) {
                    return (int)(o1.getDistance()-o2.getDistance());
                }
            });
        }else{
            list0=list1;
        }
        if(rose==5 || rose==3){
            for(SysRecruit sysRecruit1 :list0){
                sysRecruit1.setJiesuanCost((float)(sysRecruit1.getJiesuanCost()*0.15));
                list2.add(sysRecruit1);
            }
            return getDataTable(list2);
        }
        return getDataTable(list1);
    }
    /**
     * 查看招聘信息列表
     */
    @PostMapping("/see_list")
    @ResponseBody
    public TableDataInfo see_list(SysRecruit sysRecruit)
    {
        startPage();
        sysRecruit.setCreateBy(sysRecruit.getDeptName());
        sysRecruit.setParentName("");
        sysRecruit.setDeptName("");
//        List<SysRole> srl=sysRoleService.selectRolesByUserId(ShiroUtils.getUserId());
//        for(SysRole sr:srl){
//            if(sr.isFlag()){
//                switch (sr.getRoleId().intValue()){
//                    case 5:sysRecruit.setCreateBy(ShiroUtils.getLoginName());break;
//                    case 4:
//                        sysRecruit.setParentName(sysEnterpriseService.selectSysEnterpriseByCreateBy(ShiroUtils.getLoginName()).getDeptName());
//                }
//                break;
//            }
//        }
        List<SysRecruit> list0=new ArrayList<>();
        List<SysRecruit> list1 = sysRecruitService.selectSysRecruitList(sysRecruit);
        if(StringUtils.isNotEmpty(sysRecruit.getX())){
            double x=Double.valueOf(sysRecruit.getX());
            double y=Double.valueOf(sysRecruit.getY());
            for(SysRecruit sr0:list1){
                sr0.setDistance((float)getDistance(x,y,sr0.getLongitude(),sr0.getLatitude()));
                list0.add(sr0);
            }
            Collections.sort(list0, new Comparator<SysRecruit>() {
                @Override
                public int compare(SysRecruit o1, SysRecruit o2) {
                    return (int)(o1.getDistance()-o2.getDistance());
                }
            });
        }else{
            list0=list1;
        }

        return getDataTable(list0);
    }
    /**
     * 查询分配岗位信息列表
     */
    @PostMapping("/distribution_list")
    @ResponseBody
    public TableDataInfo distribution_list(SysRecruit sysRecruit)
    {
        startPage();
        sysRecruit.setCreateBy(ShiroUtils.getLoginName());
        sysRecruit.setDeptName("");
        List<SysRecruit> list0=new ArrayList<>();
        List<SysRecruit> list1 = sysRecruitService.selectSysRecruitList(sysRecruit);
        if(StringUtils.isNotEmpty(sysRecruit.getX())){
            double x=Double.valueOf(sysRecruit.getX());
            double y=Double.valueOf(sysRecruit.getY());
            for(SysRecruit sr0:list1){
                sr0.setDistance((float)getDistance(x,y,sr0.getLongitude(),sr0.getLatitude()));
                list0.add(sr0);
            }
            Collections.sort(list0, new Comparator<SysRecruit>() {
                @Override
                public int compare(SysRecruit o1, SysRecruit o2) {
                    return (int)(o1.getDistance()-o2.getDistance());
                }
            });
        }else{
            list0=list1;
        }
        return getDataTable(list0);
    }
    /**
     * 查看岗位信息列表
     */
    @PostMapping("/post_list")
    @ResponseBody
    public TableDataInfo post_list(SysRecruit sysRecruit)
    {
        startPage();
        sysRecruit.setCreateBy("");
        sysRecruit.setParentName("");
        List<SysRole> srl=sysRoleService.selectRolesByUserId(ShiroUtils.getUserId());
        int rose=0;
        for(SysRole sr:srl){
            if(sr.isFlag()){
                switch (sr.getRoleId().intValue()){
                    case 3:rose=3;break;
                    case 5:sysRecruit.setCreateBy(ShiroUtils.getLoginName());rose=5;
                    break;
                    case 4:
                        sysRecruit.setCreateBy(ShiroUtils.getLoginName());
                        sysRecruit.setParentName(sysEnterpriseService.selectSysEnterpriseByCreateBy(ShiroUtils.getLoginName()).getDeptName());
                }
                break;
            }
        }
        List<SysRecruit> list0=new ArrayList<>();
        List<SysRecruit> list1 = sysRecruitService.selectSysRecruitList(sysRecruit);
        if(StringUtils.isNotEmpty(sysRecruit.getX())){
            double x=Double.valueOf(sysRecruit.getX());
            double y=Double.valueOf(sysRecruit.getY());
            for(SysRecruit sr0:list1){
                sr0.setDistance((float)getDistance(x,y,sr0.getLongitude(),sr0.getLatitude()));
                list0.add(sr0);
            }
            Collections.sort(list0, new Comparator<SysRecruit>() {
                @Override
                public int compare(SysRecruit o1, SysRecruit o2) {
                    return (int)(o1.getDistance()-o2.getDistance());
                }
            });
        }else{
            list0=list1;
        }
        list1.clear();
        if(rose==5 || rose==3){
            for(SysRecruit sysRecruit1 :list0){
                sysRecruit1.setJiesuanCost((float)(sysRecruit1.getJiesuanCost()*0.15));
                list1.add(sysRecruit1);
            }
            list0.clear();list0=list1;
        }
        return getDataTable(list0);
    }
    public static double getDistance(double lng1,double lat1,double lng2,double lat2){
        double radLat1 = Math.toRadians(lat1);
        double radLat2 = Math.toRadians(lat2);
        double a = radLat1 - radLat2;
        double b = Math.toRadians(lng1) - Math.toRadians(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * 6378137.0;// 取WGS84标准参考椭球中的地球长半径(单位:m)
        s = Math.round(s * 10000.0) / 10000.0/1000.0;
        return s;
    }
    /**
     * 导出招聘信息列表
     */
    @RequiresPermissions("system:recruit:export")
    @Log(title = "招聘信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysRecruit sysRecruit)
    {
        List<SysRecruit> list = sysRecruitService.selectSysRecruitList(sysRecruit);
        ExcelUtil<SysRecruit> util = new ExcelUtil<SysRecruit>(SysRecruit.class);
        return util.exportExcel(list, "recruit");
    }

    @Log(title = "招聘管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:recruit:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SysRecruit> util = new ExcelUtil<SysRecruit>(SysRecruit.class);
        List<SysRecruit> userList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message =sysRecruitService.importRecruit(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:recruit:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysRecruit> util = new ExcelUtil<SysRecruit>(SysRecruit.class);
        return util.importTemplateExcel("招聘数据");
    }


    /**
     * 新增招聘信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存招聘信息
     */
    @RequiresPermissions("system:recruit:add")
    @Log(title = "招聘信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysRecruit sysRecruit)
    {
        sysRecruit.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(sysRecruitService.insertSysRecruit(sysRecruit));
    }

    /**
     * 修改招聘信息
     */
    @GetMapping("/edit/{recruitId}")
    public String edit(@PathVariable("recruitId") Long recruitId, ModelMap mmap)
    {
        SysRecruit sysRecruit = sysRecruitService.selectSysRecruitById(recruitId);
        mmap.put("sysRecruit", sysRecruit);
        return prefix + "/edit";
    }

    /**
     * 修改保存招聘信息
     */
    @RequiresPermissions("system:recruit:edit")
    @Log(title = "招聘信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysRecruit sysRecruit)
    {
        return toAjax(sysRecruitService.updateSysRecruit(sysRecruit));
    }

    /**
     * 删除招聘信息
     */
    @RequiresPermissions("system:recruit:remove")
    @Log(title = "招聘信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysRecruitService.deleteSysRecruitByIds(ids));
    }
    /**
     * 分配招聘信息
     */
    @Log(title = "招聘信息", businessType = BusinessType.DELETE)
    @PostMapping( "/distribution")
    @ResponseBody
    public AjaxResult distribution(String ids,String createby)
    {
        return toAjax(sysRecruitService.distributionSysRecruitByIds(ids,ShiroUtils.getSysUser().getRemark()));
    }
}
