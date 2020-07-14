/**
 * @autor hecaigui
 * @date 2020-1-7
 * @description
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type){
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("纽约版披萨")){
            pizza = new NYPefectPizza(ingredientFactory);
        }
        return pizza;
    }

    public static void main(String[] args) {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza("纽约版披萨");
    }
}
