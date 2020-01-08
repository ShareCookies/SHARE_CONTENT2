/**
 * @autor hecaigui
 * @date 2020-1-7
 * @description
 */
public class PizzaStore {
    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.cut();
        pizza.box();
    }
    protected abstract Pizza createPizza(String type);
}
