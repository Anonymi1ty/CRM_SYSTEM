package commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class dateUtils {
    /**
     * 对日期进行格式化
     * @return yyyy-MM-dd HH:mm:ss格式的日期
     */
    public static String formatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}

