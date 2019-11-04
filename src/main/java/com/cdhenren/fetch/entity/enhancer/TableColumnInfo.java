package com.cdhenren.fetch.entity.enhancer;

/**
 * @author Fuhj
 */
public class TableColumnInfo {
    private String columnName;
    private String dataType;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "TableColumnInfo{" +
                "columnName='" + columnName + '\'' +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}
