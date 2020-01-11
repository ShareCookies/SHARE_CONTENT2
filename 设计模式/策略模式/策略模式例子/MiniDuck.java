/**
 * @autor hecaigui
 * @date 2020-1-10
 * @description
 */
public class MiniDuck extends Duck{
    public MiniDuck(FlyBehavior flyBehavior,QuackBehavior quackBehavior){
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }
    @Override
    public void display(){
        flyBehavior.fly();
        quackBehavior.quack();
    }
}
