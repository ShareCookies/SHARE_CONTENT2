介绍：
	出版者+订阅者=观察者模式。
	概念：
		（符合该概念的即可算该设计模式）
		出版者对象管理某些数据，当数据发生改变时就会通知订阅者对象。
		观察者对象注册到出版者对象中，就能称为订阅者对象。
	
	例：	
		./观察者模式类图.png
		附：
		1.观察者模式定义了对象之间的一对多依赖。
		这样当一个对象改变状态时，它的所有依赖者都会受到通知并自动更新。
		2.观察者对象要能注册到出版者对象中，或从出版者对象中取消订阅。


Java内置的观察者模式：
	java.util包内包含Obserber接口和Observable类
	
	java.util.Observable类：
		继承Observable的类就相当于出版者。
		addObserber()方法 ,添加观察者。、
			该方法通常由观察者类调用，然后把观察者本身添加到观察者队列中。
		deleteObserver(),取消观察者。
		发出通知：
			1.调用setChanged(),changed状态标记为true。
			2.调用notifyObservers()或notifyObservers(Object arg)
			notifyObservers(Object arg)：
				该方法可以传输任何数据对象给每一个观察者。
		注：
			clearChangge() ,changed状态设为false
			hasChanged(),返回 changed状态。
	java.util.Observer接口:
		实现Observer接口的类就相当于观察者。
			当出版者调用通知方法后，观察者的update()方法将被自动调用。
			Observable出版者作为参数，是为了让观察者知道是那个出版者通知它的。
			Object 这是由notifyObservers 传过来的数据。
	注：
		1.使用java的观察者模式，不要依赖于观察者被通知的次序。
		2.java的观察者模式，并不符合OO设计原则，因为：
			1.未面向接口编程
			2.多用组合，少用继承
			(setChanged() 为protected 被保护起来了，除非继承了类，否则你无法创建Observable实例并组合到你自己的对象中)。