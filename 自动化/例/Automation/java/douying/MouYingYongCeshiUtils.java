package douying;

import common.utils.AppUtil;
import common.utils.OpenCMD;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public class MouYingYongCeshiUtils extends AppUtil {
    @Override
    public   void startQianKa(OpenCMD openCMD){
        openCMD.writeIntoCmd("am start -n com.ss.android.ugc.aweme.lite/com.ss.android.ugc.aweme.main.MainActivity");
    }
}
