#!/bin/bash
for file in ./*
do
    if test -f $file #test命令，测试是否是文本：test -f
    then
		echo $file '是文件不迁移'
    else
		for file2 in ./$file/*
		do
			if test -f $file2
			then
				packageSuffixName=${file2##*.}
			    filename=${file2%.*} #字符串剪切，剪去文件名后缀
				filename=${filename##*/} #字符串剪切，减去文件路径
				if [ $packageSuffixName = "jar" ]
				then
					#echo $file
					#echo $file2
					#echo $filename
					mv $file $filename
				fi
			fi
		done
    fi
done
echo '文件夹重命名完成(根据文件夹下jar包名来重命名)'