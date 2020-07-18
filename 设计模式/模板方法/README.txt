模板方法：
	定义：
		在一个方法中定义一个算法的骨架，而将一些步骤（实现）延迟到子类中。
		模板方法使得子类可以在不改变算法结构的情况下,重新定义算法中的某些步骤。
	例：
		1.定义个冲泡类饮料的模板方法类,其中要冲泡的那种类型的饮料等实现延迟到子类。
		./例/CaffeineBeverage.java
		2.定义个茶类的模板方法实现类
		./例/Coffee.java
		2.定义个咖啡类的模板方法实现类
		./例/Tea.java
	注：
		1.对模板方法挂钩：
			钩子是一种被声明在抽象类中的方法,只有空的或者默认的实现。
			钩子的存在, 可以让子类有能力对算法的不同点进行挂钩。要不要挂钩,由子类自行决定。
			    final void  prepareRecipe(){
					brew();
					addCondiments();
					boilWater();
					pourInCup();
					//挂钩
					if(customerWantsCondiments()){//启用钩子
						addCondiments();//
					}
				}
				boolean customerWantsCondiments();
				void addCondiments();

	附：
		1.java api 中排序即可算模板方法。