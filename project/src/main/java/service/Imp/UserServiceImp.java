package service.Imp;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import java.util.Map;
@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(Map<String, Object> map) {
        return userMapper.selectUserByUsernameAndPsw(map);
    }
}
