package com.cdhenren.fetch.driver.assetsManagement;

import com.cdhenren.fetch.driver.AbstractResourceManager;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpTower;
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
public class TowerDriver extends AbstractResourceManager {
    private static final String MAIN_MENU = "铁塔";

    public TowerDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }
    public TowerDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap,semaphore);
    }
    @Override
    protected List<ResultSet> parse() {
        String content = driver.getPageSource();
        Document document = Jsoup.parse(content);
        Elements lines = document.select("div.objbox > table > tbody > tr");
        List<ResultSet> tmpTowerList = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpTower tmpTower = new TmpTower();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpTower, values);
            if (StringUtils.isEmpty(tmpTower.get站址编码())
                    && StringUtils.isEmpty(tmpTower.get省())
                    && StringUtils.isEmpty(tmpTower.get资源ID())) {
                continue;
            }
            tmpTowerList.add(tmpTower);
        }
        return tmpTowerList;
    }

    @Override
    protected void setup() throws Exception {
        next(MAIN_MENU);
    }

}
