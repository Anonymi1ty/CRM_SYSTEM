package service.workbench;

import pojo.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {
    /**
     * 保存创建的市场活动
     * @param activity Activity表中的实体类对象
     * @return
     */
    int insertActivity(Activity activity);

    /**
     * 根据条件查询市场活动
     * @param map
     * @return
     */
    List<Activity> queryActivity(Map<String,Object> map);

    /**
     * 查询全部市场活动数
     * @param map
     * @return
     */
    int queryActivityCount(Map<String,Object> map);
}
