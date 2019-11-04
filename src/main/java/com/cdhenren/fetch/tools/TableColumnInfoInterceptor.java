package com.cdhenren.fetch.tools;

/**
 * @author Fuhj
 * @date 2019.09.28
 */
public class TableColumnInfoInterceptor {
    private String[] columns;
    public TableColumnInfoInterceptor(String[] columns){
        this.columns = columns;
    }
    public boolean isPass(String toCheck){
        for (String column : columns) {
            if(column.equals(toCheck)){
                return false;
            }
        }
        return true;
    }
}
