/**
 * @autor hecaigui
 * @date 2020-1-9
 * @description
 */
//调用者 。 调用者持有一个命令对象，并在某个时刻调用命令对象的execute()发出请求。
public class SimpleRemoteControl {
    Command slot;
    public SimpleRemoteControl(){}
    public void setCommand (Command command){
        slot= command;
    }
    public void buttonMasPress (){
        slot.execute();
    }
}
