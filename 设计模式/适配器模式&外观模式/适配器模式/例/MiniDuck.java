/**
 * @autor hecaigui
 * @date 2020-1-10
 * @description
 */
public class MiniDuck implements Duck{
    @Override
    public void fly(){
        System.out.println("flySlow");
    }
    @Override
    public void quack(){
        System.out.println("mini");
    }
}
