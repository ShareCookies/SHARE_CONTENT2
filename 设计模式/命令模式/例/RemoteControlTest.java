/**
 * @autor hecaigui
 * @date 2020-1-9
 * @description
 */

//测试类。允许调用者发出请求
public class RemoteControlTest {
    public static void main(String[] a){
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        remote.setCommand(lightOnCommand);
        remote.buttonMasPress();
    }
}
