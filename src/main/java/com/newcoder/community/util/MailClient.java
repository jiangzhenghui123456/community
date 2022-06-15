package com.newcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author 江江江
 * @version 1.0
 * @description: 邮件发送的客户端
 * @date 2022/6/15 18:06
 */
@Component
public class MailClient {
    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);


    // Spring中专门用来发送邮件的接口
    @Resource
    private JavaMailSender mailSender;

    // 通过@Value直接获取配置文件中的属性值,发送邮件方
    @Value("${spring.mail.username}")
    private String from;

    /**
     * '
     * 发送邮件的方法
     *
     * @param to      接受邮件方
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public void sendMail(String to, String subject, String content) {
        try {
            // 创建一个message
            MimeMessage message = mailSender.createMimeMessage();
            // 通过message实例化一个helper
            MimeMessageHelper helper = new MimeMessageHelper(message);
            // 注入数据
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            // 发送内容，trueHTML能够识别
            helper.setText(content, true);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            logger.error("发送邮件失败:" + e.getMessage());
        }

    }

}
