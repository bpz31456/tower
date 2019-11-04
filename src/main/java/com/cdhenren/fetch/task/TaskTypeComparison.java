package com.cdhenren.fetch.task;

import com.cdhenren.fetch.driver.assetsManagement.*;
import com.cdhenren.fetch.driver.property.BasicInformationDownloadDriver;
import com.cdhenren.fetch.driver.property.CardDownloadDriver;
import com.cdhenren.fetch.driver.property.ContractRDownloadDriver;
import com.cdhenren.fetch.driver.property.EleMeterDownloadDriver;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * 任务类型对照表
 * 与taskType同时使用，如果TaskTypeComparison不存在就用taskType中的（新增的）
 * 替换原有的就用这个替换表
 * @author Fuhj
 * @version 3.0.0
 */
public final class TaskTypeComparison {
    private static Map<Class<?>, String> table = ImmutableMap.<Class<?>, String>builder()
            //资源管理
            //资管-站址采集
            .put(SiteDriver.class, "com.cdhenren.fetch.driver.enhancer.assetsManagement.EnhancerSiteDriver")
            //资管-铁塔采集
            .put(TowerDriver.class, "com.cdhenren.fetch.driver.enhancer.assetsManagement.EnhancerTowerDriver")
            //资管-机房采集
            .put(MroomDriver.class, "com.cdhenren.fetch.driver.enhancer.assetsManagement.EnhancerMroomDriver")
            //电源开关
            .put(SwitchpDriver.class, "com.cdhenren.fetch.driver.enhancer.assetsManagement.EnhancerSwitchpDriver")
            //蓄电池
            .put(BatteryDriver.class, "com.cdhenren.fetch.driver.enhancer.assetsManagement.EnhancerBatteryDriver")
            //空调
            .put(AirCondDriver.class, "com.cdhenren.fetch.driver.enhancer.assetsManagement.EnhancerAirCondDriver")
            //资产卡片
            .put(AssetDriver.class, "com.cdhenren.fetch.driver.enhancer.assetsManagement.EnhancerAssetDriver")

            //物业-基础信息
            .put(BasicInformationDownloadDriver.class,"com.cdhenren.fetch.driver.enhancer.propertyManagement.BasicInformationEnhancerDriver")
            //物业-电表采集
            .put(EleMeterDownloadDriver.class,"com.cdhenren.fetch.driver.enhancer.propertyManagement.EleMeterEnhancerDriver")
            //物业-卡片采集
            .put(CardDownloadDriver.class,"com.cdhenren.fetch.driver.enhancer.propertyManagement.CardEnhancerDriver")
            //物业-合同信息
            .put(ContractRDownloadDriver.class,"com.cdhenren.fetch.driver.enhancer.propertyManagement.ContractREnhancerDriver")
            //.put(PlaneDriver.class, "com.cdhenren.fetch.driver.enhancer.assetsManagement.EnhancerPlaneDriver")
            .build();

    static String getProxy(Class<?> key) {
        return table.get(key);
    }
}
