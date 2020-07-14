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
        System.out.println("开始准备ny版材料");
        dough = ingredientFactory.createDough();
        cheess = ingredientFactory.createCheese();
        System.out.println("饼："+dough);
        System.out.println("奶酪："+cheess);
    }
    @Override
    void cut(){
        System.out.println("ny版就切两半");
    }
}
