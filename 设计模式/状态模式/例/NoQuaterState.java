import org.apache.tomcat.util.log.SystemLogHandler;

/**
 * @autor hecaigui
 * @date 2020-1-31
 * @description
 */
public class NoQuaterState implements State{
    GumballMachine gumballMachine;
    public NoQuaterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    @Override
    public  void insertQuater(){
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }
    @Override
    public  void ejectQuater(){
        System.out.println("未给钱无法退钱");
    }
    @Override
    public void turnCrank(){
        System.out.println("未给钱无法..");
    }
    @Override
    public void dispense(){
        System.out.println("未给钱无法..");
    }
}
