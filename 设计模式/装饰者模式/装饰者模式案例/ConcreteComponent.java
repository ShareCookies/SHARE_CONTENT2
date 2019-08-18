/**
 * 
 */
package test;

/**
 * @author Administrator
 * 具体组件
 * 具体组件可以被装饰者，装饰，然后增加新的职责
 */
public class ConcreteComponent extends AbstractComponent{
	//通过构造器设置饮料的描述。注：des实例变量继承自AbstractComponent
	public ConcreteComponent() {
		des="披萨底";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 11;//返回ConcreteComponent饮料的价格
	}
}
