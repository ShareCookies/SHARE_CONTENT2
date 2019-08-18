/**
 * 
 */
package test;

/**
 * @author Administrator
 * 抽象组件，所有装饰者和具体组件都得继承该类。
 * 以便让装饰者和被装饰者具有共同的超类，即它们的类型必须一样。
 * 这里继承达到的作用：是类型匹配
 */
public abstract class AbstractComponent {
	String des="unkong beverage";
	public String getDes() {
		return des;
	}
	public abstract double cost();
}
