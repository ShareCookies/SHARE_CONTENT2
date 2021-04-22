#!/bin/bash
for file in ../installPackages/*
do
    if test -f $file #test命令，测试是否是文本：test -f
    then
        file2=${file%.*} #字符串剪切，剪去文件名后缀
        file2=${file2##*/} #字符串剪切，减去文件路径
		#echo $file
		#echo $file2
		mv $file ./$file2/ #文件夹要存在,才能复制成功
		echo $file '复制成功' 
		allFiles=$allFiles","$file2
    fi
done
echo '文件复制工作完成(把指定目录下文件夹复制到各jar包应用目录下)(./test/test.jar 会复制到 )'
allFiles=${allFiles#*,}
/data/rjmanage/rjmanage.sh restart $allFiles