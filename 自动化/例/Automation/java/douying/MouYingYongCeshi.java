package douying;

import common.utils.AdbCommand;
import common.utils.OpenCMD;
import common.utils.ThreadUtils;


/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public class MouYingYongCeshi extends AdbCommand {

    public MouYingYongCeshi(OpenCMD openCMD){
        super(openCMD);
    }
    public MouYingYongCeshi(OpenCMD openCMD,String deviceSerialNumber){
        super(openCMD,deviceSerialNumber);
    }
    @Override
    public void execute(){
        //关闭音量
        for (int i=0;i<20;i++) {
            MouYingYongCeshiUtils.downSoundVolume(openCMD);
        }

        new MouYingYongCeshiUtils().startQianKa(openCMD);
        //第一次开启应用多等会
        ThreadUtils.sleep(1000*20);

        int seeVedioNum = 180*60/10;
        for (int i=0;i<seeVedioNum+10;i++){
            MouYingYongCeshiUtils.swipe(openCMD);
            //25s会获取一次积分
            ThreadUtils.sleep(1000*10);
        }
        openCMD.closeCmd();
    }
}
