package com.cdhenren.fetch.driver.assetsManagement;

import com.cdhenren.fetch.driver.AbstractResourceManager;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpBattery;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author Baopz
 * @date 2018/04/27
 */
public class BatteryDriver extends AbstractResourceManager {
    private static final String MAIN_MENU = "蓄电池组";

    public BatteryDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public BatteryDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select("div.objbox > table > tbody > tr");

        List<ResultSet> tmpBatterys = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpBattery tmpBattery = new TmpBattery();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpBattery, values);
            if (StringUtils.isEmpty(tmpBattery.get资产编号())) {
                continue;
            }
            tmpBatterys.add(tmpBattery);
        }
        return tmpBatterys;
    }

    @Override
    protected void setup() throws Exception {
        next(MAIN_MENU);
    }
}
