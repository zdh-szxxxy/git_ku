package com.ruoyi.web.controller.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *地图
 * @author ruoyi
 */
@Controller
@RequestMapping("/demo/map")
public class DemoMapController
{
    private String prefix = "demo/map";

    /**
     * 简单地图
     */
    @GetMapping("/simple_map")
    public String dialog()
    {
        return prefix + "/simple_map";
    }

    /**
     * 弹层组件
     */
    @GetMapping("/layer")
    public String layer()
    {
        return prefix + "/layer";
    }

    /**
     * 表单
     */
    @GetMapping("/form")
    public String form()
    {
        return prefix + "/form";
    }

    /**
     * 表格
     */
    @GetMapping("/table")
    public String table()
    {
        return prefix + "/table";
    }

    /**
     * 表格check
     */
    @GetMapping("/check")
    public String check()
    {
        return prefix + "/table/check";
    }

    /**
     * 表格radio
     */
    @GetMapping("/radio")
    public String radio()
    {
        System.out.println(prefix + "/table/radio");
        return prefix + "/table/radio";
    }

    /**
     * 表格回传父窗体
     */
    @GetMapping("/parent")
    public String parent()
    {
        return prefix + "/table/parent";
    }
}
