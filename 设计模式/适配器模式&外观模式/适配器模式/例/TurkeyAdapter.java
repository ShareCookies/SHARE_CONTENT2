/**
 * @autor hecaigui
 * @date 2020-1-11
 * @description
 */
//适配器模式关键点
//
//适配器实现目标接口。然后把适配对象的行为，适配为目标接口的行为。
public class TurkeyAdapter implements Duck {
    Turkey turkey;
    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }
    //用火鸡对象冒充鸭子
    @Override
    public void quack(){
        turkey.gobble();
    }
    @Override
    public void fly(){
        for(int i=0;i<5;i++){
            turkey.fly();
        }
    }
}
