/**
 * @autor hecaigui
 * @date 2020-1-9
 * @description
 */
//具体命令对象。定义了动作和接收者之间的绑定关系。
// 调用者只需通过execute发出请求，然后由ConcreteCommand调用者接收者的一个或多个动作。
public class LightOnCommand implements Command {
    Light light;
    public LightOnCommand (Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }
}
// 接收者
class Light {
    public void on(){
        System.out.println("开灯");
    }
    public void off(){
        System.out.println("关灯");
    }
}


