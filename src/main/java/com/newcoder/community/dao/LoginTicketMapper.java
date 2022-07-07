package com.newcoder.community.dao;

import com.newcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author 江江江
 * @version 1.0
 * @description: TODO
 * @date 2022/7/7 15:27
 */
@Mapper
public interface LoginTicketMapper {

    /**
     * 插入登入凭证
     *
     * @param loginTicket
     * @return
     */
    @Insert({
            "insert into login_ticket(user_id,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int innsertLoginTicket(LoginTicket loginTicket);

    /**
     * 通过登录凭证名称查找
     */
    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    /**
     * 更新凭证的状态，返回更新的条数
     */
    @Update({
            "<script>",
            "update login_ticket set status=#{statuc} where ticket=#{ticket} ",
            "<if test=\"ticket!=null\"> ",
            "and 1=1 ",
            "</if>",
            "</script>"
    })
    int updateStatus(String ticket, String status);
}
