package service.workbench.Imp;

import mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Activity;
import service.workbench.ActivityService;

import java.util.List;
import java.util.Map;

@Service("activityService")
public class ActivityServiceImp implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int insertActivity(Activity activity) {
        return activityMapper.insertActivity(activity);
    }

    @Override
    public List<Activity> queryActivity(Map<String, Object> map) {
        return activityMapper.queryActivityForPageByCondition(map);
    }

    @Override
    public int queryActivityCount(Map<String, Object> map) {
        return activityMapper.selectCountOfActivityByCondition(map);
    }
}

