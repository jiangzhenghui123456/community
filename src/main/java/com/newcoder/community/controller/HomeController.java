package com.newcoder.community.controller;

import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.Page;
import com.newcoder.community.entity.User;
import com.newcoder.community.service.DiscussPostService;
import com.newcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 江江江
 * @version 1.0
 * @description: 首页的controller ,mapping路径可以省略，直接不打这个mapper的路径
 * @date 2022/6/11 16:52
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private DiscussPostService discussPostService;

    /**
     * 返回index.jsp页面
     * dispatcherServlet 会自动通过注解判断这是一个请求网页的方法，从而会将方法的所有属性返回到指定的页面中
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {

        /*
            方法调用栈，SpringMVC会自动实例化Model和Page，并将Page注入Model
            所以，在thymeleaf中可以直接访问Page对象中的数据
         */
        // 获取数据总数
        page.setRows(discussPostService.findDiscussPostRows(0));
        // 设置点击的访问路径
        page.setPath("/index");
        // 调用获取帖子对象的方法
        List<DiscussPost> discussPosts = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        // 将帖子对象和user对象一起存入map中
        ArrayList<Map<String, Object>> discussPost = new ArrayList<>();

        if (discussPosts != null) {
            discussPosts.stream().forEach(discuss -> {
                HashMap<String, Object> map = new HashMap<>();
                map.put("post", discuss);
                User user = userService.findUserById(discuss.getUserId());
                map.put("user", user);
                discussPost.add(map);
            });
        }

        model.addAttribute("discussPosts", discussPost);
        return "/index";
    }
}
