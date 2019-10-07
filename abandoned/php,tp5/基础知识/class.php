<?php
	/*php只有对属性或方法的访问控制，没有对类的访问控制（可见性）。java对类有访问控制。
	类属性如果用 var 定义，则被视为公有。类方法默认共有。
	*/
	
	
	/**
	 * Define MyClass
	 */
	class MyClass
	{
		public $public = 'Public';
		protected $protected = 'Protected';
		private $private = 'Private';

		function printHello()
		{
			echo $this->public;
			echo $this->protected;
			echo $this->private;
		}
	}

	$obj = new MyClass();
	echo $obj->public; // 这行能被正常执行
	//echo $obj->protected; // 这行会产生一个致命错误
	//echo $obj->private; // 这行也会产生一个致命错误
	$obj->printHello(); // 输出 Public、Protected 和 Private


	/**
	 * Define MyClass2
	 */
	class MyClass2 extends MyClass
	{
		// 可以对 public 和 protected 进行重定义，但 private 而不能
		protected $protected = 'Protected2';

		function printHello()
		{
			echo $this->public;
			echo $this->protected;
			echo $this->private;
		}
	}

	$obj2 = new MyClass2();
	echo $obj2->public; // 这行能被正常执行
	echo $obj2->private; // 未定义 private
	//echo $obj2->protected; // 这行会产生一个致命错误
	$obj2->printHello(); // 输出 Public、Protected2 和 Undefined


?>