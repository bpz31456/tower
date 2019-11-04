package com.cdhenren.fetch.driver.assetsManagement;

import com.cdhenren.fetch.driver.AbstractResourceManager;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpMroom;
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
public class MroomDriver extends AbstractResourceManager {
    private static final String MAIN_MENU = "机房";

    public MroomDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public MroomDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        String content = driver.getPageSource();
        Document document = Jsoup.parse(content);
        Elements lines = document.select("div.objbox > table > tbody > tr");

        List<ResultSet> tmpMroomList = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpMroom tmpMroom = new TmpMroom();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpMroom, values);
            if (StringUtils.isEmpty(tmpMroom.get站址编码()) || StringUtils.isEmpty(tmpMroom.get省())) {
                continue;
            }
            tmpMroomList.add(tmpMroom);
        }
        return tmpMroomList;
    }

    @Override
    protected void setup() throws Exception {
        next(MAIN_MENU);
    }
}
