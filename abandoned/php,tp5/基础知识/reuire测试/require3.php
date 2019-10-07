<?php
header("Content-Type: text/html; charset=UTF-8");

	require('class.php');
	
	$obj = new MyClass();
	$obj->MyClass1(); 
	
	//require('class.php');//只写最后一行require会报错，所以得出php是按顺序从头开始从左到右执行