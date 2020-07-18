/**
 * @autor hecaigui
 * @date 2020-1-29
 * @description
 */
public class Tea extends CaffeineBeverage{
    @Override
    public void brew(){
        System.out.println("Steeping the tea");
    }
    @Override
    public void addCondiments (){
        System.out.println("Steeping the nothing");
    }
}
