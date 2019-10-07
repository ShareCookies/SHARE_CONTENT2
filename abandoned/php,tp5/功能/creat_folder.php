<?php
	$folder_path='photo/'.date("Y").'/'.date("m").'/'.date("d");
	if(!is_dir($folder_path)){
		echo "创建目录中";
		mkdir($folder_path,0777,true);
	}
	else echo "目录存在";
?>