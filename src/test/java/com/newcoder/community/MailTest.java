package com.newcoder.community;

import com.newcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

/**
 * @author 江江江
 * @version 1.0
 * @description: TODO
 * @date 2022/6/15 18:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTest {
    @Autowired
    private MailClient mailClient;

    @Resource
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailClient.sendMail("3136573103@qq.com", "TestMail", "测试邮件发送！");
    }

    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "jzh");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClient.sendMail("3136573103@qq.com", "HTML", content);
    }
}
