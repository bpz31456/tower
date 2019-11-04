package db;

import com.cdhenren.fetch.dao.bean.CommonMapper;
import com.cdhenren.fetch.dao.bean.TestMapper;
import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.entity.enhancer.CommonBean;
import com.cdhenren.fetch.entity.enhancer.TableColumnInfo;
import com.cdhenren.fetch.entity.enhancer.TestBean;
import com.cdhenren.fetch.tools.DbUtils;
import com.cdhenren.fetch.tools.DynamicSqlUtils;
import com.cdhenren.fetch.tools.poi.ExcelEnhancerUtils;
import com.cdhenren.fetch.tools.poi.Relationship;
import com.cdhenren.fetch.tools.poi.RelationshipFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.insert.render.BatchInsert;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mybatis.dynamic.sql.SqlBuilder.insert;


public class JDBCTest {

    private Logger logger = LoggerFactory.getLogger(JDBCTest.class);

    @Test
    public void test() {
        SqlSession session = MyBatisUtil.getSession("891");
        TestMapper mapper = session.getMapper(TestMapper.class);
        List<TestBean> beans = new ArrayList<>(1 << 4);
        beans.add(new TestBean("tangsan", 28, 1));
        beans.add(new TestBean("lisi", 29, 2));
        beans.add(new TestBean("wangwu", 30, 3));
        beans.add(new TestBean("zhouliu", 31, 4));


        SqlTable test_bean = SqlTable.of("test_bean");
        SqlColumn<String> id = test_bean.column("id", JDBCType.INTEGER);
        SqlColumn<String> name = test_bean.column("name", JDBCType.VARCHAR);
        SqlColumn<String> age = test_bean.column("age", JDBCType.INTEGER);
        BatchInsert<TestBean> batchInsert = insert(beans)
                .into(test_bean)
                .map(id).toProperty("id")
                .map(name).toProperty("name")
                .map(age).toProperty("age")
                .build()
                .render(RenderingStrategies.MYBATIS3);
        batchInsert.insertStatements().forEach(mapper::insert);
        session.commit();
        MyBatisUtil.closeSession(session);
    }

    @Test
    public void test02() {
        SqlSession sqlSession = MyBatisUtil.getSession("891");
        Map<String, String> paramater = new HashMap<>();
        paramater.put("tableSchema", "xztt");
        paramater.put("tableName", "sys_task");
        List<TableColumnInfo> tableColumnInfos =
                sqlSession.selectList("com.cdhenren.fetch.dao.xml.SysTaskMapper.queryTableInfo", paramater);
        tableColumnInfos.forEach(tableColumnInfo -> {
            logger.info(tableColumnInfo.toString());
        });
        MyBatisUtil.closeSession(sqlSession);
    }

    @Test
    public void test3() {

        List<TableColumnInfo> tableColumnInfos = DbUtils.getTableColumns("891", "test_bean");

        //
        Relationship relationship = RelationshipFactory.generator("891", "test_bean");
        Map<String, List<Object>> stringListMap = null;
        try {
            stringListMap =
                    ExcelEnhancerUtils.readFile("C:\\Users\\Fuhj\\Desktop\\tower\\user.xls",
                            new int[]{1},
                            relationship,
                            new String[]{"test_bean"});
            stringListMap.forEach((s, objects) -> {
                logger.info("tableName:{},size:{}", s, objects.size());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Object> list = stringListMap.get("test_bean");

        //入库
        MyBatisUtil.setLocation("891");
        SqlSession sqlSession = MyBatisUtil.getSession(ExecutorType.BATCH);
        CommonMapper mapper = sqlSession.getMapper(CommonMapper.class);
        DynamicSqlUtils.batchInsert(list, "test_bean", tableColumnInfos)
                .insertStatements().forEach(mapper::insert);
        sqlSession.commit();
        MyBatisUtil.closeSession(sqlSession);
    }

    @Test
    public void test04() {
        List<TableColumnInfo> sysTasks = DbUtils.getTableColumns("891", "sys_task");
        sysTasks.forEach(tableColumnInfo -> {
            logger.info(tableColumnInfo.toString());
        });
    }

    @Test
    public void test05() {

    }
}
