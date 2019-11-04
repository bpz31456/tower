package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpFallView;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 暂时还不稳定
 *
 * @author Baopz
 * @date 2018/05/02
 */
public class ProjDriver extends AbstractProj {
    private static final String MENU_1_LEVEL = "全视图";
    private static final String MENU_2_LEVEL = "数据导出";

    public ProjDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public ProjDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select(".mini-grid-row");

        List<ResultSet> tmpFallViews = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpFallView tmpFallView = new TmpFallView();
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
                if (e.contains("checkbox") || e.contains("radio")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpFallView, values);
            if (StringUtils.isEmpty(tmpFallView.get序号())) {
                continue;
            }
            tmpFallViews.add(tmpFallView);
        }
        return tmpFallViews;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }
}
