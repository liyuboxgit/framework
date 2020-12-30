package com.ruoyi.generator.service;

import java.util.List;
import com.ruoyi.generator.domain.PdTable;

/**
 * 类似powerdesigher创建，生成sqlService接口
 * 
 * @author ruoyi
 * @date 2020-12-30
 */
public interface IPdTableService 
{
    /**
     * 查询类似powerdesigher创建，生成sql
     * 
     * @param tableId 类似powerdesigher创建，生成sqlID
     * @return 类似powerdesigher创建，生成sql
     */
    public PdTable selectPdTableById(Long tableId);

    /**
     * 查询类似powerdesigher创建，生成sql列表
     * 
     * @param pdTable 类似powerdesigher创建，生成sql
     * @return 类似powerdesigher创建，生成sql集合
     */
    public List<PdTable> selectPdTableList(PdTable pdTable);

    /**
     * 新增类似powerdesigher创建，生成sql
     * 
     * @param pdTable 类似powerdesigher创建，生成sql
     * @return 结果
     */
    public int insertPdTable(PdTable pdTable);

    /**
     * 修改类似powerdesigher创建，生成sql
     * 
     * @param pdTable 类似powerdesigher创建，生成sql
     * @return 结果
     */
    public int updatePdTable(PdTable pdTable);

    /**
     * 批量删除类似powerdesigher创建，生成sql
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePdTableByIds(String ids);

    /**
     * 删除类似powerdesigher创建，生成sql信息
     * 
     * @param tableId 类似powerdesigher创建，生成sqlID
     * @return 结果
     */
    public int deletePdTableById(Long tableId);
}
