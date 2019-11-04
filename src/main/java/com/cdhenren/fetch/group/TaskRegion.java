package com.cdhenren.fetch.group;

/**
 * 任务分组，按照每个子系统为一个Region区域
 *
 * @author Fuhj
 * @date 2019.09.21
 */
public enum TaskRegion {
    /**
     * 运营管理，资源管理，二级菜单
     */
    RESOURCE_MANAGEMENT("http://res.chinatowercom.cn:7010/resweb/newMain.jsp", 2,"资源管理"),

    /**
     * 运营管理，物业管理，二级菜单
     */
    PROPERTY_MANAGEMENT("http://pcms.chinatowercom.cn:8880/default/main/skins/topbottom/index.jsp", 2,"物业管理"),

    /**
     * 运营管理，运维监控，二级菜单
     */
    OPERATIONAL_MONITORING("http://180.153.49.216:9000/layout/index.xhtml", 2,"运维监控"),

    /**
     * 运营管理，项目管理，二级菜单
     */
    PROJECT_MANAGEMENT("http://pms.pc.chinatowercom.cn:13456/pms/", 2,"项目管理"),

    /**
     * 运营管理，审计管理，二级菜单
     */
    AUDIT_MANAGEMENT("http://audit.chinatowercom.cn:8801/audit/commons/index/index.jsp", 2,"审计管理"),

    /**
     * 运营管理，crm，二级菜单
     */
    CRM("http://crm.chinatowercom.cn:36080/default/main/skins/topbottom/home.jsp", 2,"CRM"),

    /**
     * 运营分析，一级菜单
     */
    OPERATION_ANALYSIS_MAIN("http://eip.chinatowercom.cn/interface/chinaTowernew/index.jsp", 1,"运营分析"),
    /**
     * 运营分析，二级菜单
     */
    OPERATION_ANALYSIS("https://bi-new.chinatowercom.cn/ctbass/frameIndex.do", 2,"运营分析"),

    /**
     * 运营管理，一级菜单
     */
    OPERATIONS_MANAGE("http://4a.chinatowercom.cn:20000/uac_oa/oldIndex?appAcctId=2000001954", 1,"运营管理主界面"),
    ;
    private String url;
    private int level;
    private String modelName;

    TaskRegion(String url, int level,String modelName) {
        this.url = url;
        this.level = level;
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public String getUrl() {
        return url;
    }

    public int getLevel() {
        return level;
    }}
