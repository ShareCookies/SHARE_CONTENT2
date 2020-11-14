原文：https://blog.csdn.net/qq1404510094/article/details/80577555
	
Java注解@(annotation):
	介绍:
		注解是一系列元数据，它提供数据用来解释程序代码，但是注解并非代码本身的一部分。注解对于代码的运行效果没有直接影响。
			hcg：
				注解就是为java代码提供更多的解释说明。
		注解有许多用处，主要如下：
			提供信息给编译器： 编译器可以利用注解来探测错误和警告信息
			编译阶段时的处理： 软件工具可以用来利用注解信息来生成代码、Html文档或者做其它相应处理。
			运行时的处理： 某些注解可以在程序运行的时候接受代码的提取
		解释：
			当开发者使用了Annotation 修饰了类、方法、Field 等成员之后，这些 Annotation 不会自己生效，必须由开发者提供相应的代码来提取并处理 Annotation 信息。
			这些处理提取和处理 Annotation 的代码统称为 APT（Annotation Processing Tool)。
			即注解主要针对的是编译器和其它工具软件(SoftWare tool)。
			所以别再问注解什么时候用，我只能告诉你，这取决于你想利用它干什么用。


注解的定义：
	例：
	public @interface TestAnnotation {
	}
	元注解：
		介绍：
			元注解是为注解添加额外说明的一种基本注解。
		元注解有 ：
			@Retention、@Documented、@Target、@Inherited、@Repeatable 5 种。
		@Retention
			Retention 为保留期的意思。当 @Retention 应用到一个注解上的时候，它解释说明了这个注解的的存活时间。
			它的取值如下：
				RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
				RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
				RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。
		@Documented
			它的作用是能够将注解中的元素包含到 Javadoc 中去。
		@Target
			@Target 指定了注解运用的地方。
				当一个注解被 @Target 注解时，这个注解就被限定了运用的场景。
				原本注解是你想张贴到哪个地方就到哪个地方，但是因为 @Target 的存在，它张贴的地方就非常具体了，比如只能张贴到方法上、类上、方法参数上等等。
			它的取值如下：
				ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
				ElementType.CONSTRUCTOR 可以给构造方法进行注解
				ElementType.FIELD 可以给属性进行注解
				ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
				ElementType.METHOD 可以给方法进行注解
				ElementType.PACKAGE 可以给一个包进行注解
				ElementType.PARAMETER 可以给一个方法内的参数进行注解
				ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
		@Inherited
			Inherited 是继承的意思。
			但是它并不是说注解本身可以继承，而是说如果一个超类被 @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解。
			附：
				父类上的注解能被子类继承吗，接口上面的注解呢：
					https://www.cnblogs.com/grasp/p/11362118.html
		@Repeatable：
			Repeatable 自然是可重复的意思。@Repeatable 是 Java 1.8 才加进来的，所以算是一个新的特性。
				注解可重复应用于一个地方。例一个人他既是程序员又是产品经理,同时他还是个画家。
			...
	注解的属性:
		注解只有成员变量，没有方法。
		注解的成员变量以“无形参的方法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
		注：成员变量类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组。
		例：
			@Target(ElementType.TYPE)
			@Retention(RetentionPolicy.RUNTIME)
			public @interface TestAnnotation {
				int id();
				String msg();
			}
			使用：
				@TestAnnotation(id=3,msg="hello annotation")
				public class Test {
				}
		用 default 关键值指定默认值：
			例：
				@Target(ElementType.TYPE)
				@Retention(RetentionPolicy.RUNTIME)
				public @interface TestAnnotation {
					public int id() default -1;
					public String msg() default "Hi";
				}
				使用：
				因为有默认值，所以可以不用在 @TestAnnotation 后面的括号里面进行赋值了。
				@TestAnnotation()
				public class Test {}
		仅有value 的属性：
			注解内仅有一个名为 value 的属性时，应用这个注解时可以直接填写属性值到括号内。
			例：
				public @interface Check {
					String value();
				}
				使用：
					@Check("hi")
					同效果：
					@Check(value="hi")
			注：一个注解没有任何属性，那么在应用这个注解的时候，括号都可以省略。
注解的使用：
	注解可以应用在： 类上，类属性上，类方法上，方法参数上，接口等定义上。
	例：
		在类定义的地方加上 @TestAnnotation ，就可以为Test类添加额外说明。
		@TestAnnotation
		public class Test {
		}
注解的提取:
	读取类中使用的注解，获取这些注解的信息。
	通过反射获取注解信息：
		判断元素是否应用了某个注解：
			判断对象是否应用了某个注解：
				通过 Class 对象的 isAnnotationPresent() 方法判断它是否应用了某个注解。
			判断属性、方法等是否应用了某个注解：
				@TestAnnotation(msg="hello")
				public class Test {
					@Check(value="hi")
					int a;
					@Perform
					public void testMethod(){}
					@SuppressWarnings("deprecation")
					public void test1(){
						Hero hero = new Hero();
						hero.say();
						hero.speak();
					}
					public static void main(String[] args) {
						boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
						if ( hasAnnotation ) {
							TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
							//获取类的注解
							System.out.println("id:"+testAnnotation.id());
							System.out.println("msg:"+testAnnotation.msg());
						}
						try {
							Field a = Test.class.getDeclaredField("a");
							a.setAccessible(true);
							//获取一个成员变量上的注解
							Check check = a.getAnnotation(Check.class);
							if ( check != null ) {
								System.out.println("check value:"+check.value());
							}
							Method testMethod = Test.class.getDeclaredMethod("testMethod");
							if ( testMethod != null ) {
								// 获取方法中的注解
								Annotation[] ans = testMethod.getAnnotations();
								for( int i = 0;i < ans.length;i++) {
									System.out.println("method testMethod annotation:"+ans[i].annotationType().getSimpleName());
								}
							}
						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println(e.getMessage());
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println(e.getMessage());
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println(e.getMessage());
						}
					}
				}
		获取 Annotation 对象：
			getAnnotation() 方法：
				返回指定类型的注解。
			或getAnnotations() 方法：
				返回注解到这个元素上的所有注解。
			获取注解属性：
				TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
				System.out.println("id:"+testAnnotation.id());
	注：
		一个注解要在运行时被成功提取，那么 @Retention(RetentionPolicy.RUNTIME) 是必须的。
案例：
	./例/annotation
Java 中预置的注解：
	Java 语言本身已经提供了几个现成的注解。
	@Deprecated
		用来标记过时的元素
	@Override
		提示子类要复写父类方法
	@SuppressWarnings
		忽视警告的意思。
		例：
			调用被 @Deprecated 注解的方法后，编译器会警告提醒，而有时候开发者会忽略这种警告，他们可以在调用的地方通过 @SuppressWarnings 达到目的。
	@SafeVarargs
		参数安全类型注解。在 Java 1.7 的版本中加入。
		它的目的是提醒开发者不要用参数做一些不安全的操作,它的存在会阻止编译器产生 unchecked 这样的警告。
	@FunctionalInterface
		函数式接口注解。函数式编程很火，所以 Java 8 也及时添加了这个特性。