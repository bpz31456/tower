package com.cdhenren.fetch.driver.assetsManagement;

import com.cdhenren.fetch.driver.AbstractResourceManager;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpAirCond;
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
public class AirCondDriver extends AbstractResourceManager {
    private static final String MAIN_MENU = "机房空调设备";

    public AirCondDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public AirCondDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select("div.objbox > table > tbody > tr");

        List<ResultSet> tmpAirConds = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpAirCond tmpAirCond = new TmpAirCond();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpAirCond, values);
            if (StringUtils.isEmpty(tmpAirCond.get站址编码())) {
                continue;
            }
            tmpAirConds.add(tmpAirCond);
        }
        return tmpAirConds;
    }

    @Override
    protected void setup() throws Exception {
        next(MAIN_MENU);
    }
}
