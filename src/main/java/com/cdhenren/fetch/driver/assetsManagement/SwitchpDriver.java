package com.cdhenren.fetch.driver.assetsManagement;

import com.cdhenren.fetch.driver.AbstractResourceManager;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpSwitchp;
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
public class SwitchpDriver extends AbstractResourceManager {
    private static final String MAIN_MENU = "开关电源";

    public SwitchpDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }
    public SwitchpDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap,semaphore);
    }
    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select("div.objbox > table > tbody > tr");

        List<ResultSet> tmpSwitchps = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpSwitchp tmpSwitchp = new TmpSwitchp();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpSwitchp, values);
            if (StringUtils.isEmpty(tmpSwitchp.get站址编码()) || StringUtils.isEmpty(tmpSwitchp.get省())) {
                continue;
            }
            tmpSwitchps.add(tmpSwitchp);
        }
        for (ResultSet tmpSwitchp : tmpSwitchps) {
            //System.out.println(tmpSwitchp);
        }
        return tmpSwitchps;
    }

    @Override
    protected void setup() throws Exception {
        next(MAIN_MENU);
    }
}
