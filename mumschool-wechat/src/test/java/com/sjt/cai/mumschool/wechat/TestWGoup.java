package com.sjt.cai.mumschool.wechat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.wechat.service.WeChatGroupService;
import com.sjt.cai.mumschool.wechat.dto.WeChatGroup;
import org.junit.Test;

import javax.inject.Inject;
import java.io.IOException;

//@RunWith(SpringJUnit4ClassRunner.class)
//@Contextconfiguration("/beans.xml")
public class TestWGoup {
    @Inject
    private WeChatGroupService weChatGroupService;

    @Test
    public void testAdd() throws JsonProcessingException {
        WeChatGroup g = new WeChatGroup();
        g.setId(100);
        g.setName("测试组");
        weChatGroupService.add(g);

    }
    @Test
    public void testQueryAll() throws IOException {
        weChatGroupService.queryAll();

    }
    @Test
    public void testQueryUserGroup() throws IOException {
        weChatGroupService.queryUserGroup("xxxxxxxxxxxxxxxxxxxxxx");
    }

}
