package com.cdhenren.fetch.driver.assetsManagement;

import com.cdhenren.fetch.driver.AbstractPropertyManager;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpAsset;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 资产卡片
 * @author Baopz
 * @date 2018/04/27
 */
public class AssetDriver extends AbstractPropertyManager {
    private static final String MAIN_MENU = "资产卡片";

    public AssetDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public AssetDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select("div.objbox > table > tbody > tr");

        List<ResultSet> tmpAssets = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpAsset tmpAsset = new TmpAsset();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.contains("&nbsp;") ? "" : e);
            }
            reflectEntity(tmpAsset, values);
            if (StringUtils.isEmpty(tmpAsset.get站址编码())) {
                continue;
            }
            tmpAssets.add(tmpAsset);
        }
        return tmpAssets;
    }

    @Override
    protected void setup() throws Exception {
        next(MAIN_MENU);
    }
}
