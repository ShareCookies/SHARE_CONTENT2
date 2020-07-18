/**
 * @autor hecaigui
 * @date 2020-1-29
 * @description
 */
public class Coffee extends CaffeineBeverage{
    @Override
    public void brew(){
        System.out.println("Steeping the coffee");
    }
    @Override
    public void addCondiments (){
        System.out.println("Steeping the sugar");
    }
}
