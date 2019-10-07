<?php

namespace{
	header("Content-Type: text/html; charset=UTF-8");
	$variable='<br/>公共空间变量<br/>';
	//const CONNECT_OK = 1;//定义一个常量，这个常量在公共空间有效
	//echo CONNECT_OK;
	//echo '<br/>公共空间空间常量'.CONSTANT;
	//use MyProject\Sub\Level2\MyClass;//导入MyProject\Sub\Level2空间的MyClass类
	//use MyProject2\MyClass;//导入MyProject2空间的MyClass类
	//use MyProject\Sub\Level2;//导入MyProject\Sub\Level2空间
	//use MyProject\Sub\Level2\CONNECT_OK;
	//echo CONNECT_OK;
	//$obj = new Level2\MyClass();
	//$obj->MyClass1(); // 这行能被正常执行
	
	
	class MyClass{
		/*构造函数
		function __construct(){
            echo 'I am Constructors!<br/>';
        }
		*/
		//析构函数
15     function __destruct(){}
		function MyClass1(){
			echo '<br/>MyProject\Sub\Level2空间的MyClass类';
		}
	}
	$test=new MyClass();
	var_dump($test);//可看出当前类在那个空间
	
}

namespace MyProject2{
	header("Content-Type: text/html; charset=UTF-8");
	const CONNECT_OK = 1;//定义个命名空间内常量
	//echo 'MyProject2空间的'.CONNECT_OK.'常量';
	define("CONSTANT", "Hello world"); //定义一个全局常量
	class MyClass{ 
		function MyClass1(){
			echo 'MyProject2空间的MyClass类';
		}
		
	}
}


//命名空间MyProject\Sub\Level2下，创建了常量MyProject\Sub\Level2\CONNECT_OK，类MyProject\Sub\Level2\Connection和函数 MyProject\Sub\Level2\connect。
namespace MyProject\Sub\Level2{
	header("Content-Type: text/html; charset=UTF-8");
	//$test=11;
	const CONNECT_OK = 3;
	class MyClass{
		function MyClass1(){
			echo '<br/>MyProject\Sub\Level2空间的MyClass类';
		}
	}
	function connect() { /* ... */  }
	//echo "<br/>MyProject\Sub\Level2空间常量".CONNECT_OK;
}




?>
