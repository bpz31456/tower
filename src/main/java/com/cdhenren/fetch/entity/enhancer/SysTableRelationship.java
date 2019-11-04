package com.cdhenren.fetch.entity.enhancer;

/**
 * @author Fuhj
 */
public class SysTableRelationship {
    private String keyId;
    private String tableName;
    private String column;
    private String excelColumn;
    private String dataType;

    @Override
    public String toString() {
        return "SysTableRelationship{" +
                "keyId='" + keyId + '\'' +
                ", tableName='" + tableName + '\'' +
                ", column='" + column + '\'' +
                ", excelColumn='" + excelColumn + '\'' +
                ", dataType='" + dataType + '\'' +
                '}';
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getExcelColumn() {
        return excelColumn;
    }

    public void setExcelColumn(String excelColumn) {
        this.excelColumn = excelColumn;
    }
}
