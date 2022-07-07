package com.newcoder.community.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.Properties;

/**
 * @author 江江江
 * @version 1.0
 * @description: TODO
 * @date 2022/7/7 14:11
 */
@Controller
public class KaptchaConfig {
    @Bean
    public Producer kaptchaProducer() {
        // 设置kaptch的属性
        Properties properties = new Properties();
        // 设置验证码图片的宽度
        properties.setProperty("kaptcha.image.width", "100");
        // 设置高度
        properties.setProperty("kaptcha.image.height", "40");
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size", "32");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "0,0,0");
        // 随机显示的字符库
        properties.setProperty("kaptcha.textproducer.char.string", "0123456ABCNXFJHJJLJIAMCIPAFLK");
        // 显示的验证码个数
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        // 不用干扰（kaptcha默认自带的就有干扰）
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNosie");

        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
