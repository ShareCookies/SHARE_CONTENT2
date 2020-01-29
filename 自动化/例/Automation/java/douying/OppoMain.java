package douying;

import common.utils.AdbCommand;
import common.utils.OpenCMD;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description oppo
 */
public class OppoMain {
    public static void main(String[] args) {
        OpenCMD openCMD = new OpenCMD();
        AdbCommand startTask = new MouYingYongCeshi(openCMD);
        //AdbCommand startTask = new MouYingYongCeshi(openCMD,"序列号");
        startTask.execute();
    }
}
