/**
 * @autor hecaigui
 * @date 2020-1-7
 * @description
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new ThinDough(); //提供纽约版本原料
    }
}
