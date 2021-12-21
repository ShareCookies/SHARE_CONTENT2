介绍：
	工厂：
		把创建对象的代码放在一个对象中，这个对象只管如何创建出指定（披萨）对象，任何对象想要获取指定（披萨）对象找它就对了。
		这个新对象可称为工厂。
		即：
			即把某实例创建封装到一个类里，后续某实例的获取均有该类提供，该类称为工厂。
	什么时候可用工厂模式：
		1.当一个接口变量有多个不同的具体实例时，且代码会因为具体实例的新增要进行改变时，就可用到工厂模式。
		比如:
			本段代码是根据用户想要的披萨，来实例化具体披萨。
			Duck duck;
			if("picnic"){
				duck = new MDuck();
			}else if("hunting"){
				duck = new DDuck();
			}
			
			当具体实例新增时，就必须打开各个地方代码进行检查修改，导致麻烦，维护困难等。
			所以应将实例化具体类的代码从应用中抽离，使其不会干扰到应用的其他部分。
		2.hcg：我认为当对象的实例化教复杂时也可用到工厂模式。

		
工厂模式的3中类型：
	
	简单工厂：
		介绍：	
			由一个对象负责所有具体类的实例化，
		例：p116
			//把创建指定对象的代码封装进一个类后，如果实例化过程有改变只需修改这个类就行。
			public class SimplePizzaFactory{
				public Pizza createPizza(String type){//所有用户通过工厂的该方法来获取实例化对象。
					Duck pizza=null;
					if(type.equal("picnic")){
						duck = new MDuck();
					}else if(type.equal("hunting")){
						duck = new DDuck();
					}
					return pizza;
				}
			}

	静态工厂：(最常用)
		介绍：
			即把工厂方法定义为静态的。
		缺陷：
			不能通过继承来改变工厂创建方法的行为。
			子类可以继承父类的静态方法。但是不能覆盖。因为静态方法是在编译时确定了，不能多态，也就是不能运行时绑定。
		附：
			简单工厂其实不算一个设计模式，反而比较像一种编程习惯。
	工厂方法：
		定义：
			工厂方法模式定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。
			工厂方法把类的实例化推迟到子类。
		例:	
			工厂方法通过对PizzaStore进行改造，添加一个抽象的工厂方法，然后由一群子类负责实例化。
			public abstract class PizzaStore {
				public Pizza orderPizza(String type){
					Pizza pizza;
					pizza=createPizza(type);//与简单工厂对比：createPizza()方法从工厂对象中移回PizzaStore
					
					//披萨后续的流程将不会被改变
					pizza.prepare();
					pizza.bake();
					pizza.cut();
					pizza.box();
					return pizza;
				}
				abstract Pizza createPizza(String type);//工厂方法是抽象的，要有子类来负责对象的创建。
			} 

			public class NYPizzaStore extends PizzaStore{
				//如何创建具体类（披萨），将由子类来决定。例这些具体类都是纽约
				public Pizza createPizza (String type){
					Pizza pizza=null;
					if(type.equal("picnic")){
						pizza = new picnicPizza();
					}else if(type.equal("hunting")){
						pizza = new huntingPizza();
					}
					return pizza;
				}
			}
			附：
				1.工厂方法可以不用抽象，而是定义成一个生成默认产品的方法。
				2.根据传入的参数创建不同的对象，该方式叫 参数化工厂方法。
				但工厂经常只生产一种对象，所以可以不需要参数化。
	抽象工厂：
		定义：
			抽象工厂模式提供一个接口,用于创建相关（或依赖）对象的家族,而不需要明确指定具体类。
			注：
				抽象工厂与工厂方法的区别：p159
				
				1.抽象工厂中有利用工厂方法来实现生产方法。
					因为抽象工厂定义一组产品接口，但由抽象工厂子类来提供这些方法具体做法。
				
				2.工厂都是用来创建对象的
					工厂方法:
						工厂方法是通过继承，来创建对象的。
					抽象工厂方法：
						抽象工厂方法是通过对象的组合，来创建对象的。
				3.用途
					当你需要创建产品家族（或让相关的产品集合起来时）使用抽象工厂。
					当你想把客户代码从需要实例化的具体类中解耦时使用工厂方法。并且只需继承为子类并实现工厂方法就可以。		
		例：
			1.定义一个抽象工厂接口，所有的具体工厂都必须实现此接口。
			这个接口的一系列方法是用来生产家族产品的。（每个方法生成出来的产品是相关的）
			例：
				./抽象工厂/AbstractFactory/PizzaIngredientFactory.java
			2.不同的具体工厂实现不同的产品家族。
			例：
				./抽象工厂/AbstractFactory/NYPizzaIngredientFactory.java
			3.
			具体商店把抽象工厂引用（引用是指向具体的工厂）传递给具体的产品，在由产品通过组合的方式，先从工厂获取具体原料在赋值到组合中，最后返回产品给商店。
				./抽象工厂/AbstractFactory/NYPizzaStore.java
		附：
			优势：?
				便于...
				https://www.zhihu.com/question/20367734
总结：
	简单工厂：
		通过一对象获取类的实例。
	静态工厂：
		工厂方法定义为静态的，即无需实例化工厂。	
	工厂方法：
		工厂定义创建一个对象的接口，把对象的实例化推迟到工厂子类。
	抽象工厂：
		定义创建一组产品(一产品的各个组成部分)的接口，一组产品由工厂子类来实现。
		产品则通过组合进来的不同类型工厂，实现个性化产品的创建
	用途：
		当你需要创建产品家族（或让相关的产品集合起来时）使用抽象工厂。
							
		当你想把代码从需要实例化的具体类中解耦时使用工厂方法。
		
		所以各工厂只是使用场景不一样，每个模式都有自己的特点，所以合理的使用才是王道
