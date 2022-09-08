package service;

import pojo.User;

import java.util.Map;

public interface UserService {
    /**
     * 登录验证
     * @param map
     * @return
     */
    User login(Map<String,Object> map);
}
