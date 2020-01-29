package common.utils;

import common.utils.OpenCMD;

/**
 * @autor hecaigui
 * @date 2020-1-9
 * @description
 */
//命令接口。让所有的命令对象具有同一个方法。
public abstract class AdbCommand {
    public OpenCMD openCMD;
    public AdbCommand(OpenCMD openCMD){
        this.openCMD = openCMD;
        openCMD.writeIntoCmd("adb shell");
    }
    public AdbCommand(OpenCMD openCMD,String deviceSerialNumber){
        this.openCMD = openCMD;
        openCMD.writeIntoCmd("adb -s "+ deviceSerialNumber +" shell");
    }
    public  abstract void execute();
}
