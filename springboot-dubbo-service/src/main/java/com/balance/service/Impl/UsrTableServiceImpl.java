package com.balance.service.Impl;


import com.balance.dao.UsrTableDao;
import com.balance.model.UsrTable;
import com.balance.model.UsrTableExample;
import com.balance.service.UsrTableService;
import com.balance.util.MapBeanUtil;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: 杜云章
 * @description: 用户业务处理
 * @Date: 2019-06-11 11:10
 */
@Component
@Service(version = "1.0.0", timeout = 10000)
public class UsrTableServiceImpl implements UsrTableService {

    private static Logger log = LoggerFactory.getLogger(UsrTableServiceImpl.class);

    @Resource
    UsrTableDao usrTableDao;

    @Resource
    RedisTemplate<String, String> redisTemplate;

    /**
     * 校验登录结果
     * @author 杜云章
     * @param map map[account, password]
     * @return boolean true 表示校验成功 false表示校验失败
     * @date 2019/6/11 - 9:16
     */
    private boolean checkLogin(Map<String, Object> map) {
        String account = (String) map.get("account");
        if (account == null || "".equals(account)) {
            map.put("errorMessage", "账号为空");
            log.error("账号为空");
            return false;
        }
        String password = (String) map.get("password");
        if (password == null || "".equals(password)) {
            map.put("errorMessage", "密码为空");
            log.error("密码为空");
            return false;
        }
        UsrTableExample ux = new UsrTableExample();
        ux.createCriteria().andUsrAccountEqualTo(account);
        List<UsrTable> usrTables = usrTableDao.selectByExample(ux);
        if (usrTables.isEmpty()) {
            map.put("errorMessage", "账号不存在");
            log.error("账号不存在");
            return false;
        }
        if (!(password.equals(usrTables.get(0).getUsrPassword()))) {
            map.put("errorMessage", "密码错误");
            log.error("密码错误");
            return false;
        }
        map.clear();
        //深拷贝，用 = 会使得此处成为浅拷贝对map的操作不会在函数回调的时候不生效
        map.putAll(MapBeanUtil.objToMap(usrTables.get(0)));
        map.put("errorMessage", "0");
        return true;
    }

    @Override
    public String isLogin(Map<String, Object> map) {
        if (checkLogin(map)) {
            redisTemplate.opsForHash().putAll("loginInfo", map);
            log.info("成功登录");
        }
        return (String) map.get("errorMessage");
    }

    @Override
    public UsrTable getCurrentUsr() throws Exception {
        Map<Object, Object> loginInfo = redisTemplate.opsForHash().entries("loginInfo");
        return  MapBeanUtil.map2Bean(loginInfo, UsrTable.class);
    }
}
