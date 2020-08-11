https://blog.csdn.net/s10461/article/details/53941091
https://blog.csdn.net/dayang0307/article/details/101382010
介绍:
	泛型：泛型实现了”参数化类型”的概念，使代码可以应用于多种类型。
	许多原因促成了泛型的出现。
	其中一个原因就是创建容器类。
		通常我们只会用容器存储一种类型的对象，即指定容器要持有什么类型的对象，
		而且由编译器来保证类型的正确性，而且当你取出对象时自动就是正确的类型。
		注：
			使用Object就无法达到这种效果。
	例子：一个碗可以装很多种食物，加上范型，比如是面，那么这个碗只能是装上面这类的食物的！
	例:
		用来规定你这个集合中出现的数据类型
		TreeSet<Displayer> displayerSet = new TreeSet<Displayer>();
		//一个二叉树集合，这个集合里的参数只能是Displayer类displayerSet.add(displayer);
泛型特性:
	泛型只在编译阶段有效。
	例：
		List<String> stringArrayList = new ArrayList<String>();
		List<Integer> integerArrayList = new ArrayList<Integer>();

		Class classStringArrayList = stringArrayList.getClass();
		Class classIntegerArrayList = integerArrayList.getClass();

		if(classStringArrayList.equals(classIntegerArrayList)){
			Log.d("泛型测试","类型相同");
		}
		输出结果：D/泛型测试: 类型相同。

	通过上面的例子可以证明，在编译之后程序会采取去泛型化的措施。
		在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，
		并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。？
		也就是说，泛型信息不会进入到运行时阶段。
			JVM是运行字节码的，所有的泛型对于虚拟机来讲都是属于普通类。
			泛型的本质就是利用编译器实现的Java语法糖，编译器将java文件转换为class文件前，会进行泛型擦除，所以在反编译的class文件中，是看不到泛型声明的
	对此总结成一句话：泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。



泛型的使用：	
	泛型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法。
泛型类:
	介绍:
		类应用泛型，则类中属性类型可以用泛型暂代，在实例化类的时候再指明泛型的具体类型。
			注：这样类便可以得到复用，我们可以将泛型替换成任何我们想要的类型。
	例：
		定义泛型类：
		public class Generic<T>{ 
			private T key;//key这个成员变量的类型为T,T的类型由外部指定  
			public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
				this.key = key;
			}
			public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
				return key;
			}
		}
		注：
			1.此处T可以随便写为任意标识，如T、V等
			2.所有使用泛型的地方都会替换成传入的实参类型
		实例化泛型类：
		Generic<Integer> genericInteger = new Generic<Integer>(123456);
		注：
			1.在实例化泛型类时，推荐指定T的具体类型
				在使用泛型的时候如果传入泛型实参，则会根据传入的泛型实参做相应的限制，此时泛型才会起到本应起到的限制作用。
				如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
			2.泛型的参数，类型只能是类类型（包括自定义类），不能是简单类型
			
			3.?
			不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错。
			if(ex_num instanceof Generic<Number>){   
			} 

泛型接口:
	https://www.cnblogs.com/alsf/p/5697548.html
	泛型接口与泛型类的定义及使用基本相同。	
	注:
	父类|接口有泛型时:
		父类或接口有泛型时，子类可指定泛型具体值，或子类可不指定泛型具体值继续用T来代指约束类
		1.子类指定泛型的参数类型:
			public class WordsDao extends BaseDaoHibImpl<String>
			//实例化该类时部分地方法只能传字符串参数。
		2.子类不指定泛型具体值:
			public class WordsDao<T> extends BaseDaoHibImpl<T>
			//实例化该子类时在确认泛型参数实际类型。	
泛型方法:
	介绍：
		泛型方法，是在调用方法的时候指明泛型的具体类型 。
	声明泛型方法:
		在public 与 返回值中间 使用 <T>。
		<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T（此时T才可以出现在这个泛型方法的任意位置）。
		注：
			1.只有声明了<T>的方法才算泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
			2.与泛型类的定义一样，此处T可以随便写为任意标识
			3.泛型的数量也可以为任意多个？
	例：
		public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
		  IllegalAccessException{
				T instance = tClass.newInstance();
				return instance;
		}
		泛型方法的使用：
			就是普通方法的用法。
			类实例.genericMethod(person);
		附：
			/**
			 * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
			 * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
			 * 所以这也不是一个正确的泛型方法声明。
			public void showkey(T genericObj){

			}
			*/
	注：
		泛型类中的泛型方法有些地方要注意下：
			https://blog.csdn.net/s10461/article/details/53941091
			  class GenerateTest<T>{
				public void show_1(T t){
					System.out.println(t.toString());
				}

				//在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
				public <E> void show_3(E t){
					System.out.println(t.toString());
				}
				//在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
				public <T> void show_2(T t){
					System.out.println(t.toString());
				}
			}
		静态方法与泛型：
			静态方法无法访问类上定义的泛型；即：如果静态方法要使用泛型的话，必须将静态方法也定义成泛型方法 。
泛型通配符：
	无界通配符：
		<?>
		例：
			List<?>表示“具有某种特定类型的非原生List，只是我们不知道那种类型是什么。
			附：
			java泛型无界通配符和原生的区别什么：
				无界通配符<?>看起来意味着“任何事物”，因此使用无界通配符好像等价于使用原生类型。
				实际上，List表示“持有任何Object类型的原生List”，而List<?>表示“具有某种特定类型的非原生List，只是我们不知道那种类型是什么。”

	超类型通配符：
		<? super  Father>
	泛型上下边界：
		为泛型添加上下边界，即传入的类型实参必须是指定类型的子类型：
			Generic<? extends  Father> generic = new Generic<Son>(new Son());	
		注：
			未添加上边界，子类泛型不能与父类泛型匹配。
			因为泛型能够将容器的类型错误检测移入到编译期（注不是容器的持有类型）
			例：
				//        Generic<Father> generic = new Generic<Son>(new Son());
				//        Incompatible types.
				//        Required:Generic<com.china.hcg.eas.business.Father>
				//        Found:Generic<com.china.hcg.eas.business.Son>
注：
	泛型数组：
		在java中是”不能创建一个确切的泛型类型的数组”的。
		在运行时JVM是不知道泛型信息的，如果可以进行泛型数组的声明，上面说的这种情况在编译期将不会出现任何的警告和错误，只有在运行时才会出错。
附：
元组：
	仅一次方法就能返回多个对象，这个概率称为元组。
		将一组对象直接打包存储于一个对象中。允许读取其中的元素，但是不允许向其中存放新的对象。
		（也称为数据传输对象。）
	public class TwoTuple<A,B>	{
		public final A first;
		public final B second;
		public TwoTuple(A a,B b){first = a; second = b;}
	}