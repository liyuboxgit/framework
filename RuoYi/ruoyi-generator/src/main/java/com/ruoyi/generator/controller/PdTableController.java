package com.ruoyi.generator.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.generator.domain.PdTable;
import com.ruoyi.generator.service.IPdTableService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 类似powerdesigher创建，生成sqlController
 * 
 * @author ruoyi
 * @date 2020-12-30
 */
@Controller
@RequestMapping("/table/table")
public class PdTableController extends BaseController
{
    private String prefix = "table/table";

    @Autowired
    private IPdTableService pdTableService;

    @RequiresPermissions("table:table:view")
    @GetMapping()
    public String table()
    {
        return prefix + "/table";
    }

    /**
     * 查询类似powerdesigher创建，生成sql列表
     */
    @RequiresPermissions("table:table:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PdTable pdTable)
    {
        startPage();
        List<PdTable> list = pdTableService.selectPdTableList(pdTable);
        return getDataTable(list);
    }

    /**
     * 导出类似powerdesigher创建，生成sql列表
     */
    @RequiresPermissions("table:table:export")
    @Log(title = "类似powerdesigher创建，生成sql", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PdTable pdTable)
    {
        List<PdTable> list = pdTableService.selectPdTableList(pdTable);
        ExcelUtil<PdTable> util = new ExcelUtil<PdTable>(PdTable.class);
        return util.exportExcel(list, "table");
    }

    /**
     * 新增类似powerdesigher创建，生成sql
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存类似powerdesigher创建，生成sql
     */
    @RequiresPermissions("table:table:add")
    @Log(title = "类似powerdesigher创建，生成sql", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PdTable pdTable)
    {
        return toAjax(pdTableService.insertPdTable(pdTable));
    }

    /**
     * 修改类似powerdesigher创建，生成sql
     */
    @GetMapping("/edit/{tableId}")
    public String edit(@PathVariable("tableId") Long tableId, ModelMap mmap)
    {
        PdTable pdTable = pdTableService.selectPdTableById(tableId);
        pdTable.getParams().put("list",JSON.parseObject(pdTable.getTableCont(), List.class));

        mmap.put("pdTable", pdTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存类似powerdesigher创建，生成sql
     */
    @RequiresPermissions("table:table:edit")
    @Log(title = "类似powerdesigher创建，生成sql", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PdTable pdTable)
    {
        return toAjax(pdTableService.updatePdTable(pdTable));
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(@RequestBody String data)
    {
        PdTable pdTable = new PdTable();
        JSONObject jsonObject = JSON.parseObject(data);
        Long tableId = jsonObject.getLong("tableId");
        JSONArray cols = jsonObject.getJSONArray("cols");

        pdTable.setTableId(tableId);
        pdTable.setTableCont(cols.toJSONString());
        this.pdTableService.updatePdTable(pdTable);
        return AjaxResult.success();
    }

    /**
     * 删除类似powerdesigher创建，生成sql
     */
    @RequiresPermissions("table:table:remove")
    @Log(title = "类似powerdesigher创建，生成sql", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pdTableService.deletePdTableByIds(ids));
    }
}
