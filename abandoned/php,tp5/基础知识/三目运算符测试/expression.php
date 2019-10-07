<?php
	header("Content-Type: text/html; charset=UTF-8");
	//echo 1?'true前':'false后';
	//echo $test=''?:'false后';
	echo 8>4?:'false后';//:前头省略的话则默认为1，后头不能省略。这种写法能在php中行，java中不行。所以不推荐
	/*
	java中会报错
	public class TestB {
		public static void main(String[] args) {
		//String test=8<5?"true前":"false后";
		System.out.println(test);
		//System.out.println(8>5?:9);//会报错
		}
	}
	*/
	