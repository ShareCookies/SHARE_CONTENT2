<?php
//stdClass  http://www.cnblogs.com/fengliang/p/3586781.html
//StdClass类是PHP中的一个基类,是一个没有成员方法和属性的空对象。->对象操作符['']数组操作符

$test='{"a":"qq","b":"ww"}';
$json=json_decode($test);
//print_r($json); //可用来查看json对象的具体内容
echo $json->a;//得到qq

/*取消注释可进行测试
$test='[{"a":"加","b":"单"},{"a":"11","b":"22"}]';
$json=json_decode($test);
//print_r($json); 
echo $json[1]->a;//得到11
//count($json);//得到数组长度
for($i=0;$i<count($json);$i++){
	//遍历对象每次循环都把其中键值对保存到$key和$value变量。foreach可以遍历数组和对象。
	foreach($json[$i] as $key=>$value){
		print $key.$value."<br/>";
	}	
}
*/

/*取消注释可进行测试
$test='{"people": [{"firstName": "Brett", "lastName":"McLaughlin"},{ "firstName": "Json", "lastName":"Hunter"}],
"people2": [{"firstName": "Brett2", "lastName":"McLaughli2"},{ "firstName": "Json3", "lastName":"Hunter3"}]}';
$json=json_decode($test);
//print_r($json); 
//var_dump($json);//一对象里包含两个公开属性,每个属性里包含两个数组，每个数组里又包含一个对象，每个对象里有三个公开属性
echo $json->people[1]->firstName;//得到Json
//json格式小结：{}中一定要有键名:键值,键值可以是{}或数组。[]中可以包含{}
*/
?>

//遍历对象 http://blog.csdn.net/fanyilong_v5/article/details/39008829

//php下载源码http://bbs.csdn.net/topics/330231942

