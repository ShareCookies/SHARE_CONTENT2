/**
 * 
 */
package test;

/**
 * @author Administrator
 * 具体装饰者
 * 用来装饰具体组件，所以具体组件一般是主料如披萨底部，而具体装饰者则是赔了如火腿。
 * 必须实现的部分
 */
public class ConcreteDecorator extends AbstractDecorator{
	//1.用一个实例变量来记录被装饰者
	AbstractComponent beverage;

	//2.想办法让被装饰者记录到实例变量中，这里是使用了构造器注入
	public ConcreteDecorator(AbstractComponent beverage) {
		this.beverage=beverage;
	}
	@Override
	public String getDes() {
		// TODO Auto-generated method stub
		return beverage.getDes()+"+火腿";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .2+beverage.cost();
	}

}
