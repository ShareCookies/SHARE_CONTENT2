/**
 * @autor hecaigui
 * @date 2020-1-7
 * @description
 */
public class NYPizzaStore extends PizzaStore {
    protected Pizza createPizza(String type){
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("gough")){
            pizza = new NYPefectPizza(ingredientFactory);
        }
    }
}
