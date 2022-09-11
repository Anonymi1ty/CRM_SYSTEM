package controller.workbench;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;
import service.settings.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class activityController {
    @Autowired
    private UserService userService;

    /**
     * 跳转到市场活动页面
     * @return
     */
    @RequestMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request){
        //调用service层方法查询所有用户
        List<User> users = userService.queryAllUser();
        //将查询结果存入request域中
        request.setAttribute("users",users);
        return "workbench/activity/index";
    }

}
