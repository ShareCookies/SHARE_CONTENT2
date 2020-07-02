接口作用:
	接口其实就是为了描述一个共有行为，所以ava的接口用来指定一个类必须做什么.。
	注：
		接口常用于解耦
		Interface是否继承自Object：
			不是
			https://blog.csdn.net/xidiancoder/article/details/78011148?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase
			https://www.cnblogs.com/softnovo/articles/4546418.html
			接口不implements或extend自Object。JLS有一个特殊的子句来将Object方法添加到接口。

接口定义：
	public  interface  student(){
		public  String  school="哈哈哈";//接口成员变量默认会添加  public static final修饰   	
		public   void  test();//接口成员方法会默认添加 public abstract修饰
	}
	附：
		1.接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字。
		注：
			1.public abstract interface与public  interface本质上完全一样，在java编译后都是abstract interface
			2.接口要用public修饰，因为接口可以让所有的类去实现（非继承），不只是其子类，所以接口要用public去修饰。

		2.以抽象类模拟接口：
			public  abstract   class  student(){
				public  static  final String  school="哈哈哈";
				public  abstract  void  test();
			}
接口注意事项：
	1.接口特性：
		1.一个类只能extend（继承）一个类，但能implements（实现）多个接口。
		2.接口之间能多继承：
			Java中的接口是支持多继承的。
			即一个接口则可以同时extends多个接口，却不能implements任何接口。
		附：
			写在接口方法上的注解，可以被子类方法继承。（即子类可不必在写该注解）
	接口属性:
		接口成员变量只能是常量。
			即接口属性默认修饰符为 public static final
			注：
				1.使用static原因:接口不涉及和任何具体实例相关的细节,因此接口没有构造方法,不能被实例化,没有实例变量，只有静态（static）变量。
				2.使用final原因:接口的中的变量是所有实现类共有的，既然共有，肯定是不变的东西，因为变化的东西也不能够算共有。所以变量是不可变(final)类型。
				3.使用public原因:接口用于描述系统对外提供的所有服务,因此接口中的成员常量和方法都必须是公开(public)类型的,确保外部使用者能访问它们。
				4.使用abstract原因:接口仅仅描述系统能做什么,但不指明如何去做,所以接口中的方法,都是抽象(abstract)方法。
	接口方法：
		接口成员方法默认公有抽象方法：
			即接口方法默认修饰符为 public abstract
			注：
				1.接口中每一个方法也是隐式抽象的，声明时可不加abstract。
				2.接口中的方法都是公有的。
	
		*Java8接口方法默认实现：
			https://blog.csdn.net/fly910905/article/details/87534052
			从java8开始，接口可以给方法一个默认的实现，称之为默认接口方法，这样所有实现该接口的子类都可以持有该方法的默认实现。

	Java接口的使用：
		接口作为参数传递：
			介绍：
				接口当参数，使用时只需传递实现了该接口的类即可。
					附：
						1.传递过去的类只能调用接口定义的方法。
		例：
			./test/
		接口做方法返回值类型：
			即返回值只要是实现了该接口的类的对象即可。
	附：
		接口中的访问修饰符：
			https://blog.csdn.net/zh521zh/article/details/82259967
			接口中能用的访问修饰符：
				default（还是public级别）
					例： void test();
				public
			不能用的访问修饰符：	
				private：抽象方法没有方法体，是用来被继承的，所以不能用private修饰；
				protected：protected访问修饰符也不能使用，因为接口可以让所有的类去实现（非继承），不只是其子类。

			注：
				1.接口中无法使用的修饰符：
					synchronized、native等。
				2.alibaba规定接口中最好不用任何修饰符：
					例：void f();
					反例：public abstract void f();