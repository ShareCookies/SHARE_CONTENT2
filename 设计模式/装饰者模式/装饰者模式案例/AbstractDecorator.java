/**
 * 
 */
package test;

/**
 * @author Administrator
 * 抽象装饰者
 * 用来确保装饰者类型与被装饰者的类型一致，和用来约束具体装饰者要实现的方法。
 */
public abstract class AbstractDecorator extends AbstractComponent {
	/**
	 * 
	 */
	public abstract String getDes();
}
