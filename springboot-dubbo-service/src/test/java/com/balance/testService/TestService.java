package com.balance.testService;

import com.balance.SpringbootDubboServiceApplicationTests;
import com.balance.service.UsrTableService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 杜云章
 * @description:
 * @Date: 2019-06-11 11:49
 */
public class TestService  extends SpringbootDubboServiceApplicationTests{

    @Autowired
    UsrTableService usrTableService;
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Test
    public void isLoginTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("account","admin");
        map.put("password","123456");
        String loginInfo = usrTableService.isLogin(map);
        System.out.println(loginInfo);
    }

}
