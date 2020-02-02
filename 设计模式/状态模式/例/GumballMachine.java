/**
 * @autor hecaigui
 * @date 2020-1-31
 * @description
 */
public class GumballMachine {
    State soldOutState;
    State noQuaterState;
    State hasQuaterState;
    State soldState;

    State state = soldState;
    int count = 0;
    public GumballMachine(int numbersGumball){
        soldOutState = new SoldOutState(this);
        noQuaterState = new NoQuaterState(this);
        hasQuaterState = new HasQuaterState(this);
        soldState = new SoldState(this);
        this.count = numbersGumball;
        if (numbersGumball>0){
            state = noQuaterState;
        }
    }
    void insertQuater(){
        state.insertQuater();
    }
    void ejectQuater(){
        state.ejectQuater();
    }
    void turnCrank(){
        state.turnCrank();
        state.dispense();
    }
    void setState(State state){
        this.state = state;
    }
    //其余方法
}
