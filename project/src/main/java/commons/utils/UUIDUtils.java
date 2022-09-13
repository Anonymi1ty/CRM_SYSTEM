package commons.utils;

public class UUIDUtils {
    public static String getUUID(){
        return java.util.UUID.randomUUID().toString().replaceAll("-","");
    }
}
