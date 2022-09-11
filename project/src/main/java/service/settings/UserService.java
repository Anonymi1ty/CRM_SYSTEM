package service.settings;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 登录验证
     * @param map
     * @return
     */
    User login(Map<String,Object> map);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryAllUser();
}
