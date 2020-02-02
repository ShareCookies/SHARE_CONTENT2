/**
 * @autor hecaigui
 * @date 2020-1-29
 * @description
 */
public abstract  class CaffeineBeverage {
    // 模板方法
    // 1.因为它是一个方法 2. 它定义了一个算法的模板，模板中算法的步骤都被
    final void  prepareRecipe(){
        brew();
        addCondiments();
        boilWater();
        pourInCup();
    }

    //由子类提供
    abstract void brew();

    abstract void addCondiments();

    void boilWater(){
        //...
    }
    void pourInCup(){
        //...
    }
}
