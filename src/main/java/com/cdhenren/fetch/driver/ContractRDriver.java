package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpContractR;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 用了下载文件的方法，不用查询表格的方法
 *
 * @author Baopz
 * @date 2018/04/28
 */
@Deprecated
public class ContractRDriver extends AbstractRealEstate {
    private static final String MENU_1_LEVEL = "基础信息";
    private static final String MENU_2_LEVEL = "合同信息管理";

    public ContractRDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select(".mini-grid-row");

        List<ResultSet> tmpContractRs = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpContractR tmpContractR = new TmpContractR();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.select("div").html();
                if (e.contains("checkbox")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpContractR, values);
            if (StringUtils.isEmpty(tmpContractR.get合同状态())) {
                continue;
            }
            tmpContractRs.add(tmpContractR);
        }
        return tmpContractRs;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }

}
