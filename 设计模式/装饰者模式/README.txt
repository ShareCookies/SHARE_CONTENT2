装饰者模式（Decorator模式）：
	
	定义：
		装饰者模式动态地将责任附加到对象身上。
			装饰技巧能够在不修改任何底层代码的情况下，给你的（或别人的）对象赋予新的职责。
			所以只要代码能实现该功能就算装饰器模式。
		附：
			1.
				装饰者模式又名包装(Wrapper)模式。
				这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。
			2.装饰者作用：
				装饰者可以在被装饰者的行为前面或后面加上自己的行为，甚至将被装饰者的行为整个取代掉，而达到特定的目的。
			3.
				装饰者模式以对客户端透明的方式扩展对象的功能，是继承关系的一个替代方案。
				若要扩展功能，装饰者提供了比继承更有弹性的替代方案
			优点/缺点：
				优点：
				缺点：
					装饰者会导致设计中出现许多小对象，如果过度使用，会让程序变得很复杂。
	
	例：
	案例0：javaI/O的装饰者模式介绍：p100
	案例1：
		https://www.jianshu.com/p/d7f20ae63186
		介绍：
	        （1）Component抽象组件接口:来规范准备附加功能的类。
	        （2）ConcreteComponent具体组件类：实现抽象组件。将要被附加功能的类。
	        （3）Decorator抽象装饰者：主要用来规范具体装饰者。
				实现抽象组件，持有一个具体组件的引用。
	        （4）ConcreteDecorator具体装饰者：通过具体组件引用，来对具体组件添加额外功能。
		实现：
			Component：
				// 人接口定义一个eat()方法，这是所有的具体构件类和装饰类必须实现的。
				public interface Component {
					void eat();
				}
			ConcreteComponent：
				public class ConcreteComponent implements Component {
					//人的一具体分类男人，男人一定有人的eat()方法
					public void eat() {
						System.out.println("男人在吃");
					}
				}
			Decorator：
				public abstract class Decorator implements Component {
					//持有一个具体组件的引用。
					protected Component person;
					public void setPerson(Component person) {
						this.person = person;
					}
					//利用引用，实现抽象组件接口
					public void eat() {
						person.eat();
					}
				}
			
			ConcreteDectrator：	
				//具体装饰角色,a类型男，能吃两顿
				public class ConcreteDectratorA extends Decorator {
					public void eat() {
						super.eat();
						reEat();
						System.out.println("ManDecoratorA类");
					}
					public void reEat() {
						System.out.println("再吃一顿饭");
					}
				}
				//具体装饰角色,b类型男，能吃一顿
				public class ConcreteDectratorB extends Decorator {
					public void eat() {
						super.eat();
						System.out.println("===============");
						System.out.println("ManDecoratorB类，吃一顿");
					}
				}