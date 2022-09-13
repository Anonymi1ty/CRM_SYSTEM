package controller.workbench;

import commons.constants.Constants;
import commons.pojo.ReturnObject;
import commons.utils.UUIDUtils;
import commons.utils.dateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Activity;
import pojo.User;
import service.settings.UserService;
import service.workbench.ActivityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class activityController {
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;

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
    /**
     * 添加市场活动
     * Object返回类型可以返回JSON类型数据
     * @param activity
     * @param session
     * @return
     */
    @RequestMapping("/workbench/activity/saveCreateActivity.do")
    @ResponseBody
    public Object saveCreateActivity(Activity activity, HttpSession session){
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        ReturnObject returnObject = new ReturnObject();
        //封装参数
        activity.setId(UUIDUtils.getUUID());
        activity.setCreateTime(dateUtils.formatDate(new Date()));
        activity.setCreateBy(user.getId());

        //调用service层方法
        int res = activityService.insertActivity(activity);
        if(res >0){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
        }else {
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("添加失败");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/activity/queryActivityForPageByCondition.do")
    @ResponseBody
    public Object queryActivityForPageByCondition(String name , String owner , String startDate , String endDate , int pageNo , int pageSize){
        //封装参数
        Map<String,Object> map= new HashMap<>();
        map.put("name",name);
        map.put("owner",owner);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("pageNo",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        //调用service层方法查询数据
        List<Activity> activities = activityService.queryActivity(map);
        int totalRows = activityService.queryActivityCount(map);
        //根据查询结果生成响应信息
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("activityList",activities);
        returnMap.put("totalRows",totalRows);
        return returnMap;
    }
}
