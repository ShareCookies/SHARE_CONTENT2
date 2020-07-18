/**
 * @autor hecaigui
 * @date 2020-1-31
 * @description
 */
public class GumballMachine {
    // 售完糖果
    //State soldOutState;
    // 无25美分
    State noQuarterState;
    // 投入25美分
    State hasQuarterState;
    // 售出糖果
    //State soldState;

    //State state = soldOutState;
    State state = null;
    int count = 0;
    public GumballMachine(int numbersGumball){
        //oldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        //soldState = new SoldState(this);
        this.count = numbersGumball;
        if (numbersGumball>0){
            state = noQuarterState;
        }
    }
    // 糖果机按钮1：投钱
    void insertQuarter(){
        state.insertQuater();
    }
    // 糖果机按钮2：退钱
    void ejectQuarter(){
        state.ejectQuater();
    }
    // 糖果机按钮3：转动操作杠
    void turnCrank(){
        state.turnCrank();
        state.dispense();
    }
    // get set
    void setState(State state){
        this.state = state;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public void setNoQuarterState(State noQuarterState) {
        this.noQuarterState = noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public void setHasQuarterState(State hasQuarterState) {
        this.hasQuarterState = hasQuarterState;
    }

    public static void main(String[] args) {
        // 初始化机器
        GumballMachine gumballMachine = new GumballMachine(5);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}
