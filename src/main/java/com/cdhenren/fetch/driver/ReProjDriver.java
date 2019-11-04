package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpReProj;
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
 * @date 2018/05/02
 */
public class ReProjDriver extends AbstractProj {
    private static final String MENU_1_LEVEL = "项目调整";
    private static final String MENU_2_LEVEL = "项目销项查询";

    public ReProjDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public ReProjDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select(".mini-grid-row");

        List<ResultSet> tmpReProjs = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpReProj tmpReProj = new TmpReProj();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.select("div").html();
                try {
                    if (e.contains("div")) {
                        e = element.select("div > div").html();
                    }
                    if (e.contains("<a")) {
                        e = element.select("div > a").html();
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpReProj, values);
            if (StringUtils.isEmpty(tmpReProj.get所属区域())) {
                continue;
            }
            tmpReProjs.add(tmpReProj);
        }
        return tmpReProjs;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }
}
