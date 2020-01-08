/**
 * @autor hecaigui
 * @date 2020-1-7
 * @description
 */
public abstract  class Pizza {
    Dough dough;
    //...更多原料


    abstract void prepare();//由具体的子类来决定从哪个原料工厂获取原料
    //固定的制作步骤
}
