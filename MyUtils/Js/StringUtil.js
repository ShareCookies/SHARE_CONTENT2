Var StringUtil={

}

大小写转换：
	var str = "String";
	str .toLowerCase();//.toLowerCase()字符串全转小写
	var str = "string";
	str.toUpperCase()//.toUpperCase()字符串全转大写
查找字符串：
	indexOf()：
		可返回指定字符串在字符串中首次出现的位置，若没有找到指定字符串，则会返回-1
		语法：
			allStr.indexOf(subStr,index)
			allStr，要被查找的指字符串
			subStr，要查找的指字符串，是必须要传的值；
			index，规定了在字符串中开始检索的位置，不是必传的值；

字符串截取：
	https://www.cnblogs.com/wangyulue/p/7718532.html
	str.substring(indexStart, [indexEnd])

字符串替换：
	全部替换：
		使用正则表达式进行替换
		var str='aab,bcc,a,a';
		var reg=/,/g;
		str=str.replace(reg,';');
	替换首次出现：
		var str='[aabbccaa]';
		str=str.replace('[','');
　　去空格：
		https://www.cnblogs.com/a-cat/p/8872498.html
		去除字符串内所有的空格：
			str = str.replace(/\s*/g,"");
	删除最后一位字符：
		s=s.substring(0,s.length-1)
