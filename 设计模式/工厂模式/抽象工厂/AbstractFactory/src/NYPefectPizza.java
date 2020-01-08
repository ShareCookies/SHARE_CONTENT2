/**
 * @autor hecaigui
 * @date 2020-1-7
 * @description
 */
public class NYPefectPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;
    public NYPefectPizza(PizzaIngredientFactory pizzaIngredientFactory){
        this.ingredientFactory = pizzaIngredientFactory;
    }
    @Override
    void prepare(){
        dough = ingredientFactory.createDough();
    }
}
