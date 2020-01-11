

/**
 * @autor hecaigui
 * @date 2020-1-10
 * @description
 */
public class MiniDuckTest {
    public static void main(String[] args){
        FlyBehavior flyBehavior = new FlyNoRay();
        QuackBehavior quackBehavior = new CommonQuack();
        Duck duck = new MiniDuck(flyBehavior,quackBehavior);
        duck.display();
    }
}
