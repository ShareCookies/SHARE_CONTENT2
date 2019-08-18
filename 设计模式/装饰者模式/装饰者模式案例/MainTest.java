/**
 * 
 */
package test;

/**
 * @author Administrator
 *
 * 这里的对象都是直接new出来的，使用工厂和生成器设计模式，能够以更好的方式建立装饰者对象
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractComponent concreteComponent=new ConcreteComponent();
		System.out.println(concreteComponent.getDes()+"，花费$"+concreteComponent.cost());
		
		AbstractComponent concreteComponent2=new ConcreteComponent();
		concreteComponent2=new ConcreteDecorator(concreteComponent2);
		System.out.println(concreteComponent2.getDes()+"，花费$"+concreteComponent2.cost());

	}

}
