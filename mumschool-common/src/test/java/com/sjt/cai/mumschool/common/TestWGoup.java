package com.sjt.cai.mumschool.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.common.service.GroupService;
import com.sjt.cai.mumschool.common.dto.WGroup;
import org.junit.Test;

import javax.inject.Inject;
import java.io.IOException;

//@RunWith(SpringJUnit4ClassRunner.class)
//@Contextconfiguration("/beans.xml")
public class TestWGoup {
    @Inject
    private GroupService groupService;

    @Test
    public void testAdd() throws JsonProcessingException {
        WGroup g = new WGroup();
        g.setId(100);
        g.setName("测试组");
        groupService.add(g);

    }
    @Test
    public void testQueryAll() throws IOException {
        groupService.queryAll();

    }
    @Test
    public void testQueryUserGroup() throws IOException {
        groupService.queryUserGroup("xxxxxxxxxxxxxxxxxxxxxx");
    }

}
