package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpEleMeter;
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
public class EleMeterDriver extends AbstractRealEstate {
    private static final String MENU_1_LEVEL = "电费基础信息";
    private static final String MENU_2_LEVEL = "电表信息管理";

    public EleMeterDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public EleMeterDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select(".mini-grid-row");

        List<ResultSet> tmpEleMeters = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpEleMeter tmpEleMeter = new TmpEleMeter();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.select("div").html();
                if (e.contains("checkbox")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpEleMeter, values);
            if (StringUtils.isEmpty(tmpEleMeter.get省())) {
                continue;
            }
            tmpEleMeters.add(tmpEleMeter);
        }
        return tmpEleMeters;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }
}
