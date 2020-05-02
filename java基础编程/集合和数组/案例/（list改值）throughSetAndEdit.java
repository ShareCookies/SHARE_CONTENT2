package test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
* @ClassName: throughSetAndEdit
* @Description: 遍历list或set的同时，修改其值(这里用一句话描述这个类的作用)
* @author hcg
* @date 2018年9月2日
*
*/

public class throughSetAndEdit {

	
	public throughSetAndEdit() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		/*
		* 使用ListIterator遍历并修改值（推荐）
		*/
		//https://blog.csdn.net/gooooa/article/details/77530112
		List<String> strings =new ArrayList<>();
		strings.add("1");strings.add("2");strings.add("3");strings.add("2");strings.add("5");
		ListIterator<String> iterator=strings.listIterator();
		while (iterator.hasNext()) {
			String string=iterator.next();
			if (string.equals("2")) {//如果是对象的话，无需在set回去，因为引用传递！！！
				iterator.set("1");
			}
		}
		for (String string : strings) {
			System.out.println(string);
		}
		/*
		* 使用基础for遍历并修改值
		*/
	}

}
