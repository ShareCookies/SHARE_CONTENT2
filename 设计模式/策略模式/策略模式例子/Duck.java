/**
 * @autor hecaigui
 * @date 2020-1-10
 * @description
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public Duck() {

    }
    public abstract void display();

    //托托给行为类。//多用组合少用继承
    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }
}
