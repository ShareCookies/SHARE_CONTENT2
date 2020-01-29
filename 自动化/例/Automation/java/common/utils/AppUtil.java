package common.utils;

import common.utils.OpenCMD;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public abstract class AppUtil {
    public abstract   void startQianKa(OpenCMD openCMD);
    public static  void click(OpenCMD openCMD,String coordinate){
        openCMD.writeIntoCmd("input tap "+coordinate);
    }
    public static  void swipe(OpenCMD openCMD){
        openCMD.writeIntoCmd("input swipe  300 800 300 300");
    }
    public static  void swipe(OpenCMD openCMD,String swipeCoordinate){
        openCMD.writeIntoCmd("input swipe "+swipeCoordinate);
    }
    public static  void returnButton(OpenCMD openCMD){
        openCMD.writeIntoCmd("input keyevent 4");
    }

    public static  void downSoundVolume(OpenCMD openCMD){
        openCMD.writeIntoCmd("input keyevent 25");
    }

}
