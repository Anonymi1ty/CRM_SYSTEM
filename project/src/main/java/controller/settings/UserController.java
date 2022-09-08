package controller.settings;

import commons.constants.Constants;
import commons.pojo.ReturnObject;
import commons.utils.dateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 登录页面跳转
     * @return
     */
    @RequestMapping(value = "/settings/qx/user/toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "settings/qx/user/login";
    }

    /**
     * 登录验证
     * @param loginAct 登录账号
     * @param loginPwd 登录密码
     * @param isRemPwd 是否记住密码
     * @return
     */
    @RequestMapping(value = "/settings/qx/user/login.do")
    @ResponseBody
    public Object login(String loginAct, String loginPwd, String isRemPwd, HttpServletRequest request){
        //将返回值封装为map
        Map<String,Object> map = new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        //调用service层方法查询用户
        User user = userService.login(map);

        //根据查询结果生成响应信息
        ReturnObject returnObject = new ReturnObject();
        if (user== null){
            //登录失败，用户名或密码错误
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("Username or password is incorrect");
            System.out.println(returnObject.getMessage());
        }else{//进一步判断用户是否合法
            String expireTime = user.getExpireTime();//失效时间
            String nowTime = dateUtils.formatDate(new Date());//当前时间
            if (nowTime.compareTo(expireTime)>0){
                //登录失败，账号已失效
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("account has expired");
        } else if ("0".equals(user.getLockState())){
                //登录失败，账号已锁定)
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("account has been locked");
            } else if (!user.getAllowIps().contains(request.getRemoteAddr())){//判断ip地址是否合法
                //登录失败，ip地址受限
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("ip address is restricted");
            }else {
                //登录成功
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                }
            }
            //将查询结果自动变为JSON格式存入session
            return returnObject;
    }

}
