package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpPlane;
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
public class PlaneDriver extends AbstractResourceManager {
    private static final String MAIN_MENU = "平面";

    public PlaneDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public PlaneDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select("div.objbox > table > tbody > tr");

        List<ResultSet> tmpPlanes = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpPlane tmpPlane = new TmpPlane();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpPlane, values);
            if (StringUtils.isEmpty(tmpPlane.get站址编码())) {
                continue;
            }
            tmpPlanes.add(tmpPlane);
        }
        return tmpPlanes;
    }

    @Override
    protected void setup() throws Exception {
        next(MAIN_MENU);
    }
}
