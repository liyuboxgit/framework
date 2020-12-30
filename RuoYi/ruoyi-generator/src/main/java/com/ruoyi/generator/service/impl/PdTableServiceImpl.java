package com.ruoyi.generator.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.generator.mapper.PdTableMapper;
import com.ruoyi.generator.domain.PdTable;
import com.ruoyi.generator.service.IPdTableService;
import com.ruoyi.common.core.text.Convert;

/**
 * 类似powerdesigher创建，生成sqlService业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-30
 */
@Service
public class PdTableServiceImpl implements IPdTableService 
{
    @Autowired
    private PdTableMapper pdTableMapper;

    /**
     * 查询类似powerdesigher创建，生成sql
     * 
     * @param tableId 类似powerdesigher创建，生成sqlID
     * @return 类似powerdesigher创建，生成sql
     */
    @Override
    public PdTable selectPdTableById(Long tableId)
    {
        return pdTableMapper.selectPdTableById(tableId);
    }

    /**
     * 查询类似powerdesigher创建，生成sql列表
     * 
     * @param pdTable 类似powerdesigher创建，生成sql
     * @return 类似powerdesigher创建，生成sql
     */
    @Override
    public List<PdTable> selectPdTableList(PdTable pdTable)
    {
        return pdTableMapper.selectPdTableList(pdTable);
    }

    /**
     * 新增类似powerdesigher创建，生成sql
     * 
     * @param pdTable 类似powerdesigher创建，生成sql
     * @return 结果
     */
    @Override
    public int insertPdTable(PdTable pdTable)
    {
        return pdTableMapper.insertPdTable(pdTable);
    }

    /**
     * 修改类似powerdesigher创建，生成sql
     * 
     * @param pdTable 类似powerdesigher创建，生成sql
     * @return 结果
     */
    @Override
    public int updatePdTable(PdTable pdTable)
    {
        return pdTableMapper.updatePdTable(pdTable);
    }

    /**
     * 删除类似powerdesigher创建，生成sql对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePdTableByIds(String ids)
    {
        return pdTableMapper.deletePdTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除类似powerdesigher创建，生成sql信息
     * 
     * @param tableId 类似powerdesigher创建，生成sqlID
     * @return 结果
     */
    @Override
    public int deletePdTableById(Long tableId)
    {
        return pdTableMapper.deletePdTableById(tableId);
    }
}
