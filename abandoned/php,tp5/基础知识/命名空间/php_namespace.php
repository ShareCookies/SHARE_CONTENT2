<?php
/* 
	1.关于命名空间的一些常识：
		1.在声明命名空间之前唯一合法的代码是用于定义源文件编码方式的 declare 语句。
		2.命名空间对命名空间内部的类/函数/常量/变量起作用。
		3.命名空间的声明方式：
			namespace MyProject1;//声明单个命名空间
			namespace MyProject\Sub\Level1;//声明分层次的单个命名空间 
			namespace test;与namespace test{}都是声明test空间，这两种写法可以写在两个php文件在require进来，但是不能在同一个php文件同时用这两种写法。
		4.http://php.net/manual/zh/language.namespaces.php
		5.我个人认为use应该可以理解为取别名操作符，其作用就是把as后的符号定义为前的符号 http://blog.csdn.net/qq_34819586/article/details/79340800
*/
//namespace ;这种写法如何声明公共空间？？？
namespace main;//声明main空间
	header("Content-Type: text/html; charset=UTF-8");
	use MyProject2\MyClass;//可以先use在require，但是require要在实际的内容前，就是说require不能在new一个对象操作的后面。
	require('php_namespace2.php');//echo include('hp_namespace2.php');
	$obj = new MyClass();//实例化的是MyProject2\MyClass
	$obj->MyClass1(); 
	//use statement2\MyClass as MyClass1;
	//$obj = new MyClass1();
	$obj = new \statement2\MyClass();//实例化的是公共空间空间下的statement2\MyClass类
	$obj->myclass(); 
	//第20-23行的实例化（即上四行包括注释）可以看出在命名空间下直接导入命名空间,要在前头加个\说明我要导入的是公共空间下的***命名空间,而use不用，直接写要导入的命名空间路径就好。
/* 
*在命名空间内引入其他文件不会属于本命名空间，要引入的文件如果没定义命名空间则属于公共空间，有的话则属于文件中本身定义的命名空间。 http://blog.csdn.net/jathamj/article/details/53102947
*/
namespace statement1;

//new MyClass();      //报错，找不到MyClass;因为解析器是去找statement1\MyClass类，而不是去找公共空间空间的MyClass类
//(new \MyClass())->MyClass1();     //这样写可以直接调用对象的方法，而不用在赋值给一个引用变量了。去找公共空间空间的MyClass类,输出MyProject\Sub\Level2空间的MyClass类;

namespace  statement2;
header("Content-Type: text/html; charset=UTF-8");
class MyClass{ 
		function myclass(){
			echo '<br/>statement2空间的myclass类';
		}
		
	}

?>