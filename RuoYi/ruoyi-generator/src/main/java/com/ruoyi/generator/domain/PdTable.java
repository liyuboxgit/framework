package com.ruoyi.generator.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 类似powerdesigher创建，生成sql对象 pd_table
 * 
 * @author ruoyi
 * @date 2020-12-30
 */
public class PdTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long tableId;

    /**  */
    @Excel(name = "")
    private String tableName;

    /**  */
    @Excel(name = "")
    private String tableRemark;

    /**  */
    @Excel(name = "")
    private String tableCont;

    public void setTableId(Long tableId) 
    {
        this.tableId = tableId;
    }

    public Long getTableId() 
    {
        return tableId;
    }
    public void setTableName(String tableName) 
    {
        this.tableName = tableName;
    }

    public String getTableName() 
    {
        return tableName;
    }
    public void setTableRemark(String tableRemark) 
    {
        this.tableRemark = tableRemark;
    }

    public String getTableRemark() 
    {
        return tableRemark;
    }
    public void setTableCont(String tableCont) 
    {
        this.tableCont = tableCont;
    }

    public String getTableCont() 
    {
        return tableCont;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tableId", getTableId())
            .append("tableName", getTableName())
            .append("tableRemark", getTableRemark())
            .append("tableCont", getTableCont())
            .toString();
    }
}
