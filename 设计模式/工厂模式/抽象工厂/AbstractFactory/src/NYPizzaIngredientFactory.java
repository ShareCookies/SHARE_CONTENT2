/**
 * @autor hecaigui
 * @date 2020-1-7
 * @description
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public String createDough() {
        return  "houBanDough"; //提供纽约版本饼原料
    }
    @Override
    public String createCheese() {
        return  "xianBanChess"; //提供纽约版本奶酪原料
    }
}
