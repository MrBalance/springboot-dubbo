package com.balance.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.balance.model.UsrTable;
import com.balance.service.UsrTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 杜云章
 * @description:
 * @Date: 2019-06-11 18:23
 */
@RestController
@RequestMapping("/usrTable")
public class UsrTableController {

    private static Logger log = LoggerFactory.getLogger(UsrTableController.class);

    @Reference(version = "1.0.0")
    private UsrTableService usrTableService;

    @PostMapping("/login")
    public String login(@RequestParam Map<String, Object> map) {
        log.info("进入UsrTableController.login()方法");
        String isLoginInfo = usrTableService.isLogin(map);
        log.info("执行结果：" + isLoginInfo);
        return isLoginInfo;
    }

    //RestFull
    @GetMapping("/loginGet/{account}/{password}")
        public String loginGet(@PathVariable("account") String account,@PathVariable("password") String password) {
        log.info("进入UsrTableController.login()方法");
        Map<String, Object> map = new HashMap<>();
        map.put("account", account);
        map.put("password", password);
        String isLoginInfo = usrTableService.isLogin(map);
        log.info("执行结果：" + isLoginInfo);
        return isLoginInfo;
    }

    @GetMapping("/getCurrentUsr")
    public UsrTable getCurrentUsr() throws Exception {
        log.info("进入UsrTableController.getCurrentUsr()方法");
        UsrTable currentUsr = usrTableService.getCurrentUsr();
        log.info("执行结果：" + currentUsr);
        return currentUsr;
    }


}
