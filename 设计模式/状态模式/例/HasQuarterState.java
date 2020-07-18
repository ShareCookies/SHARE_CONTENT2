

/**
 * @autor hecaigui
 * @date 2020-1-31
 * @description
 */
public class HasQuarterState implements State{
    GumballMachine gumballMachine;
    public HasQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    @Override
    public  void insertQuater(){
        System.out.println("已投入钱，正在出糖果中");
    }
    @Override
    public  void ejectQuater(){
        System.out.println("不退钱");
    }
    @Override
    public void turnCrank(){
        System.out.println("机器开始转，准备出糖果");

    }
    @Override
    public void dispense(){
        System.out.println("出糖果了");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
}
