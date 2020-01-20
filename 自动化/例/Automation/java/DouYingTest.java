import java.awt.*;
import java.awt.event.InputEvent;

/**
 * @autor hecaigui
 * @date 2020-1-18
 * @description
 */
public class DouYingTest {
    public static Robot rb ;
    public static RobotCommonUtils robotCommonUtils ;

    static{
        // 初始化工作
        try {
            DouYingTest.rb = new Robot();
            //设置Robot产生一个动作后的默认休眠时间ms,否则执行过快
            DouYingTest.rb.setAutoDelay(5);
        } catch (AWTException e) {
            e.printStackTrace();
            throw new RuntimeException("Robot对象初始化失败");
        }
        DouYingTest.robotCommonUtils = new RobotCommonUtils(DouYingTest.rb);
    }
    public static void main(String[] args) {
        DouYingTest douYingTest = new DouYingTest();
        douYingTest.intoCmd();
        douYingTest.activyDouYing();

    }
    /**
     * @description 激活抖音
     */
    public  void activyDouYing(){
        robotCommonUtils.stringTransferToRobotKeyEvent("am start -n com.ss.android.ugc.aweme/.main.MainActivity");
    }

    /**
     * @description 进入cmd页面
     */
    public  void intoCmd(){
        //todo:手机屏幕不休眠（或常亮）
        //TODO：cmd 要开启adb ，放于电脑左上角，alt+tab能切换到cmd
        robotCommonUtils.altTab();
        rb.mouseMove(518,339);
        rb.delay(500);
        robotCommonUtils.mouseLeftClick(500);
    }
}
