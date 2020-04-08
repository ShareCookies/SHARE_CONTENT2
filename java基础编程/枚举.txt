原文：https://www.cnblogs.com/hyl8218/p/5088287.html
枚举定义：
	例：
		public enum EnumTest {
			MON, TUE, WED, THU, FRI, SAT, SUN;
		}
	enum 自定义属性和方法：
		public enum EnumTest  {
			MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6),
			SUN(0) {
				// 重写自定义方法
				@Override
				public boolean isRest() {
					return true;
				}
			};
			// enum自定义方法
			public boolean isRest() {
				return false;
			}

			// 自定义属性
			private int customValue;
			public EnumTest(int value) {
				this.customValue = value;
			}
			public int getCustomValue() {
				return customValue;
			}
			public void setCustomValue(int customValue) {
				this.customValue = customValue;
			}

			public static void main(String[] args) {
				System.out.println("enum 已有的属性name" + EnumTest.FRI);
				System.out.println("enum 已有的属性ordinal " + EnumTest.FRI.ordinal());
				System.out.println("enum. 的 自定义值 = " + EnumTest.FRI.getCustomValue());
			}
		}	
	附：
		1.
			这段代码实际上调用了7次 Enum(String name, int ordinal)：
			new Enum<EnumTest>("MON",0);
			new Enum<EnumTest>("TUE",1);
			... ...	
		2.枚举解析
			enum 的语法结构尽管和 class 的语法不一样，但是经过编译器编译之后产生的是一个class文件。该class文件经过反编译可以看到实际上是生成了一个类，该类继承了java.lang.Enum<E>。
			所以，实际上 enum 就是一个 class，只不过 java 编译器帮我们做了语法的解析和编译而已。
			可以把 enum 看成是一个普通的 class，它们都可以定义一些属性和方法，不同之处是：enum 不能使用 extends 关键字继承其他类，因为 enum 已经继承了 java.lang.Enum（java是单一继承）。



对枚举进行遍历和switch的操作：
	public class Test {
		public static void main(String[] args) {
			for (EnumTest e : EnumTest.values()) {
				System.out.println(e.toString());
			}			 
			EnumTest test = EnumTest.TUE;
			switch (test) {
				case MON:
					System.out.println("今天是星期一");
					break;
				case TUE:
					System.out.println("今天是星期二");
					break;
				// ... ...
				default:
					System.out.println(test);
					break;
			}
		}
	}
枚举对象的常用方法：
	返回枚举常量的名称：
		String toString()
			   返回枚举常量的名称，它包含在声明中。
		String name() 
			  返回此枚举常量的名称，它包含在声明中。
		例：
			System.out.println(EnumTest.FRI);
			System.out.println("name(): " + test.name());
			System.out.println("toString(): " + test.toString());
	返回枚举常量的序数：
		int ordinal() 
			返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。
			例：System.out.println("ordinal(): " + test.ordinal());
	int compareTo(E o) 
		比较此枚举与指定对象的顺序。
		例：
		    EnumTest test = EnumTest.TUE;
			switch (test.compareTo(EnumTest.MON)) {
				case -1:
					System.out.println("TUE 在 MON 之前");
					break;
				case 1:
					System.out.println("TUE 在 MON 之后");
					break;
				default:
					System.out.println("TUE 与 MON 在同一位置");
					break;
			}
	static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) 
          返回带指定名称的指定枚举类型的枚举常量。
附：

	枚举消除if else ：
		https://www.bilibili.com/read/cv4257620
		public enum EnumTest  {
			SUN() {
				@Override
				public String hasOpetation() {
					return "有玩手机权限";
				}
			};
			public String hasOpetation() {
				return "无权限";
			}
			public static void main(String[] args) {
			   String day = "SUN";
			   System.out.println(EnumTest.valueOf(day).hasOpetation());
			}
		}		

	https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/basic/%E7%94%A8%E5%A5%BDJava%E4%B8%AD%E7%9A%84%E6%9E%9A%E4%B8%BE%E7%9C%9F%E7%9A%84%E6%B2%A1%E6%9C%89%E9%82%A3%E4%B9%88%E7%AE%80%E5%8D%95.md