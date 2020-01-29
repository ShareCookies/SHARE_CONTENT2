package common.utils;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public class ThreadUtils {
    /**
     * @description
     * @param   sleepTime ms
     */
    public static void sleep(long sleepTime){
        try {
            Thread.sleep(sleepTime);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
