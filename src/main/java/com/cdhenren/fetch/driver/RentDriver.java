package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpRent;
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
public class RentDriver extends AbstractRealEstate {
    private static final String MENU_1_LEVEL = "租金管理";
    private static final String MENU_2_LEVEL = "租金台帐管理";

    public RentDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public RentDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select(".mini-grid-row");

        List<ResultSet> tmpRents = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpRent tmpRent = new TmpRent();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.select("div").html();
                if (e.contains("checkbox")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpRent, values);
            if (StringUtils.isEmpty(tmpRent.get合同编码())) {
                continue;
            }
            tmpRents.add(tmpRent);
        }
        return tmpRents;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }
}
