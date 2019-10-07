<?php
	
	//java静态	https://www.cnblogs.com/dianqijiaodengdai/p/6144698.html
	
	/* 
		
		this是指向对象实例的一个引用，this只能用来调用实例属性和实例方法
		this用法：$this->实例属性或实例方法
		self是对类本身的一个引用，self只能用来调用静态属性或静态方法
		self用法：self::静态属性或静态方法
		（我记得java的静态属性既可以用类名访问也可以用对象来访问）
		
		参考自：http://blog.csdn.net/skynet001/article/details/7518164
		http://blog.csdn.net/tancy_weipj/article/details/50971230
	*/
	
	class UserName
	{ 
		//定义成员属性 
		private $name;
		//定义一个静态变量
		private static $staticVariable ='staticVariable<br/>';
		//定义构造函数
		function __construct( $name )
		 {
			  $this->name = $name; //这里已经使用了this指针
		 }
	 
		 //析构函数
		 function __destruct(){}
		 //打印用户名成员函数
		 function printName()
		 {
			  print( $this->name ); //又使用了this指针
		 }
		 
		 //打印用户名成员函数
		 function printStatic()
		 {
			  print(self::$staticVariable); //使用了self指针访问静态变量
			  //print($this->$staticVariable);//报错
		 }
		 
	 }
	
	 //实例化对象
	 $nameObject = new UserName( "heiyeluren<br/>" );
	 //执行打印
	 $nameObject->printName(); //输出: heiyeluren
	 //第二次实例化对象
	 $nameObject2 = new UserName( "PHP5<br/>" );
	 //执行打印
	 $nameObject2->printName(); //输出：PHP5
	 /*
	//上面四个操作想说明this是指向对象实例的一个引用，因为类的两次实例化，其实例化变量用this来赋值，其输出结果是不同的，所以说this是指向对象实例的一个引用。
	我 们看，上面的类分别在构造函数和printName()使用了this指针，那么当时this是指向谁呢？
	其实this是在实例化的时候来确定指向谁，比如第一次实例化对象的时候，
	那么当时this就是指向$nameObject对象，那么执行printName()打印的时候就把print( $this->name )变成了print( $nameObject->name )，那么当然就输出了"heiyeluren"。
	第二个实例的时候，print( $this- >name )变成了print( $nameObject2->name )，于是就输出了"PHP5"。
	所以说，this就是指向当前对象实例的指针，不指向任何其他对象或类。
	*/
	 
	 //尝试输出静态变量
	 $nameObject2->printStatic(); //输出：staticVariable
	 /* 就是想说明self是对类本身的一个引用 */
?>









<?php
	/*
	parent是对父类本身的一个引用，parent能用来调用静态属性||静态方法||方法
	parent用法：parent::静态属性||静态方法|| 方法
	*/
	/* 
	php子类继承父类，其实例化的时候，我觉得应是在子类对象的内存中有一块区域放了父类的属性和实例方法，静态方法还在父类内存空间。
	php子类的构造函数可以重写父类的构造函数。
	
	java继承中是没有创建父类对象的，子类继承自父类的实际变量内容存储在new出来的空间里的一个地方（所以子类对象的内存空间只是放了父类的属性和方法的引用）。super这个关键字只不过是访问了这个空间特定部分的数据（也就是专门存储父类数据的内存部分）。	http://www.cnblogs.com/wxw7blog/p/7052757.html
	父类中的构造方法是不能继承的（所以不能重写父类构造方法），因为子类构造方法的第一条语句，都是隐含地调用super()，如果父类没有这种形式的构造函数（即参数不同），那么在编译的时候就会报错。	https://www.cnblogs.com/liumingyi/p/5833011.html
	*/
	class Animal2
	{
		//基类的属性
		public $name=1; //名字
		public static $parentStaticVariable="parentStaticVariable";
		
		//基类的构造函数
		 public function __construct()
		 {
			  $this->name = 10;//我觉的从这行代码中可以看出该子类对象的内存中有一块区域放了父类方法，因为$this->是指当前对象的属性
			  echo "parentConstruct<br/>";
		 }
		  function printPerson()
		 {
			  print("parentFuction<br/>" );
		 }
		 static function parentStaticFunction()
		 {
			  //$this->name = 1011;//Fatal error:Using $this when not in object context 
			  print("parentStaticFunction<br/>" );
		 }
		 
		 
	 }

	 //派生类
	 class Person2 extends Animal2 //Person类继承了Animal类
	 {
		 public $personSex; //性别
		 public $personAge; //年龄

		 /* 
		 //子类没有构造函数则自动继承自父类
		 function __construct( $personSex, $personAge,$name='anonymousPerson' )
		 {
			  parent::__construct( $name ); //使用parent调用了父类的构造函数
			  //$this->__construct( $name );
			 
		 } */
		  
		 /* //子类有构造函数则重写父类构造函数
		 function __construct(  )
		 {
			 echo "sonConstruct<br/>";
		 }  */
		 /* //子类既继承父类的构造函数又想写自己的构造函数
		 function __construct(  )
		 {
			 parent::__construct();
			 echo "sonConstruct<br/>";
		 } 
		  */
		 


		 function printPerson()
		 {
			 //$this->name=5;/* //我认为从这行可以看出该子对象内存中一块区域中放了父类的属性 */
			  print( $this->name."<br/>" );
			  //echo parent::$parentStaticVariable;//访问父类静态变量
			  //parent::parentStaticFunction();//引用了父类中的静态方法
			  //parent::printPerson();//引用了父类中原有的实例方法
			  
		 }
		 
	 }

	 //实例化Person对象
	$parent = new Person2();
	 //执行打印
	$parent->printPerson(); //


	
?>


<?php
	/* 
	这是网上测试案例：
	parent测试
	我们知道parent是指向父类的指针，一般我们使用parent来调用父类的构造函数。
	*/
	//基类
	class Animal
	{
		//基类的属性
		public $name; //名字

		//基类的构造函数
		 public function __construct( $name )
		 {
			  $this->name = $name;
			  //echo 'parentonstruct';
		 }
	 }

	 //派生类
	 class Person extends Animal //Person类继承了Animal类
	 {
		 public $personSex; //性别
		 public $personAge; //年龄

		 //继承类的构造函数
		 function __construct( $personSex, $personAge,$name='anonymousPerson' )
		 {
			  parent::__construct( $name ); //使用parent调用了父类的构造函数
			  //$this->__construct( $name );
			  $this->personSex = $personSex;
			  $this->personAge = $personAge;
		 }

		 function printPerson()
		 {
			  print( $this->name. " is " .$this->personSex. ",this year " .$this->personAge."<br/>" );
		  }
	 }

	 //实例化Person对象
	$personObject = new Person( "male", "21");
	 //执行打印
	$personObject->printPerson(); //输出：anonymousPerson is male,this year 21
	 //实例化第二个对象
	$object = new Person( "male", "21","test");
	 //执行打印
	$object->printPerson(); //输出：anonymousPerson is male,this year 21
	
	
	/* 	
	我 们注意这么几个细节：成员属性都是public的，特别是父类的，是为了供继承类通过this来访问。
	我们注意关键的地方，第25行： parent::__construct( "heiyeluren" ),这时候我们就使用parent来调用父类的构造函数进行对父类的初始化，
	因为父类的成员都是public的，于是我们就能够在继承类中直接使用 this来调用。	 
	*/
	
?>





