https://blog.csdn.net/java_cxrs/article/details/91661623
异常介绍：
	当程序出现异常后，
	要么程序崩溃无法运行了，
	要么程序还能继续运行，要么自己处理异常，要么给别人处理。
		给别人处理：
			也许你不清楚该如何处理异常，此时你要停下来,把这个问题提交到一个更高级别的环境中（即抛出异常）,
			看看是不是有别人或在别的地方,能够处理这个问题。
异常的分类：
	java里异常分为Error和Exception，异常救错误不救

	Error：
		Error是程序中无法处理的错误，表示运行应用程序中出现了严重的错误。
		此类异常无法被捕获，所以发生此类错误时，JVM将终止线程。
		例：
			NoClassDefFoundError，比如说当jvm耗完可用内存时，将出现OutOfMemoryError等
		
	Exception：
		表程序可以捕获并且可以处理的异常。
		该类型异常可分为两类。
		RuntimeException运行时异常：(不受检异常)（可自定义该类型异常）
			RuntimeException类及其子类异常，表示JVM在运行期间可能出现的错误。此类异常属于不可查异常，编译器不会检查此类异常。	
				比如用空值对象的引用（NullPointerException）、数组下标越界（ArrayIndexOutBoundException）。
			一般是由程序逻辑错误引起的，在程序中可以选择捕获处理，也可以不处理。

		非运行时异常：(受检异常)
			Exception中除RuntimeException及其子类之外的异常。编译器会检查此类异常
			如果程序中出现此类异常，必须对该异常进行处理，要么使用try-catch捕获，要么使用throws语句抛出，否则编译不通过。
				比如说IOException，
异常的操作：
	首先a方法中要有异常被抛出，然后调用a方法的b方法中对该异常又两种处理方式：捕获异常或继续抛出。
	注：
		1.如果异常一直往外抛，没有方法对其处理，那么最后会被抛给jvm，然后jvm打印异常信息并停止当前线程。
		2.异常未被处理的地方（未捕获就算未处理），其后续代码时不会执行的。
		3.子类重写父类方法，不能抛出必父类更多的异常，只能少抛或一样。
	抛出异常的方式：
		throw
			throw用在方法内，用来抛出一个异常对象，这个异常对象将被传递到调用者处。
			例：
				throw new NullPointerException("别名参数不允许为空");
		throws
			运用于方法声明之上，用于表示当前方法不处理异常，而是提醒该方法的调用者来处理异常
			public void test throws FileNotFoundException{
			}

	捕获异常的方式：
		try{}catch()...{}finally{}
		介绍：
			try {
				// 包裹住会抛出异常的代码。
					// 
			} catch(IOException e){
				// 1. 如果抛出的异常与IOException相同则会被该catch捕获
				e.printStackTrace();//2.打印异常信息
				
			} catch(Exception e){
				// try可以与多个catch配合来捕获多个类型的异常。
				// Exception e 可以捕获所有异常
			} fanally{
				//finally无论什么情况都执行。
					//即使try中有return除非直接摧毁整个程序
			}
			注：try,catch,finally	
				作用域空间是相互独立，互不可问的。
					在这三个作用访问内定义的变量外界访问不到,但是外界定义（函数作用域）的变量其可以访问的到
自定义运行时异常：
	除了JDK定义好的异常类外，在开发过程中根据业务的异常情况自定义运行时异常类，然后抛出。
	例：
		... extends RuntimeException{
			 
		}
	符：
		1.所有标准异常类都有两个构造器:1.一个是默认构造器;2.另一个是接受字符串作为参数,以便能把相关信息放入异常对象的构造器。
		2.自定义的异常类抛出目的是，终止自己程序后续的执行，并给别的程序一个说明。
		一般自己不会捕获自己定义并抛出的异常，如果自己抛自己捕获就是自娱自乐的意义。

	      