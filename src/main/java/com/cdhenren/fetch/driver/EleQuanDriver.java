package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpEleQuan;
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
 * @date 2018/04/28
 */
public class EleQuanDriver extends AbstractRealEstate {
    private static final String MENU_1_LEVEL = "电费基础信息";
    private static final String MENU_2_LEVEL = "电量管理";

    public EleQuanDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public EleQuanDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select(".mini-grid-row");

        List<ResultSet> tmpEleQuans = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpEleQuan tmpEleQuan = new TmpEleQuan();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.select("div").html();
                if (e.contains("checkbox") || e.contains("radio")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpEleQuan, values);
            if (StringUtils.isEmpty(tmpEleQuan.get省())) {
                continue;
            }
            tmpEleQuans.add(tmpEleQuan);
        }
        return tmpEleQuans;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }
}