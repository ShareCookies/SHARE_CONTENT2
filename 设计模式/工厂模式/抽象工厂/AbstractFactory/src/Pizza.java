/**
 * @autor hecaigui
 * @date 2020-1-7
 * @description
 */
public abstract  class Pizza {
    String dough;
    String cheess;


    abstract void prepare();//由具体的子类来决定从哪个原料工厂获取原料
    abstract void cut();//
    void box(){
        System.out.println("出炉打包");
    }//

    //更多固定的制作步骤
}
