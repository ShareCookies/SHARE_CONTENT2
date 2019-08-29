package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class ArrayAndCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 数组也是类，只是写法特殊一点 
		 * 声明数组引用变量
		 */
		String[] array1;//首选
		String array2[];//该风格是来自 C/C++ 语言 ，在Java中采用是为了让 C/C++ 程序员能够快速理解java语言。
		/*
		 * 创建数组对象
		 */
		array1 = new String[4];
		array2 = new String[4];
		/*
		 * 为数组赋初值
		 */
		//...
		
		//Collection和Map遍历
		//ArrayAndCollection.mapLoopThrough();
		//ArrayAndCollection.listLoopThrough();
		//ArrayAndCollection.TraversalSet();
		ArrayAndCollection.fundamentalTreeSet();
	}
	/**
	 * des：Map遍历
	 * http://blog.csdn.net/zhu1qiu/article/details/71170850
	 */
	public static void mapLoopThrough() {
		  Map<String, String> tempMap = new HashMap<String, String>();  
		  tempMap.put("a","12");  
		  tempMap.put("b","34");  
		  tempMap.put("c","56");  
		 
		  	 //1.迭代：迭代器iterator迭代，通用
			 /*
			  * 迭代器遍历使用方法：
			  * 	前提：该对象实现了迭代器接口
			  * 	1.：调用对象的iterator()方法返回 Iterator对象
			  * 	2.：while循环，循环条件为Iterator对象的hasNext方法。hasNext会判断Iterator是否还有下一个元素。
			  * 	3.：在while循环体{}中进行内容输出。结合Iterator对象的next方法进行内容输出，该方法会返回迭代器中的下一个元素（），返回一次会自动向下移动(具体实现在map类)?。
			  * 
			  */
		  Iterator it = tempMap.entrySet().iterator();  
		  while (it.hasNext()) {  
				Map.Entry entry = (Map.Entry) it.next();//获取map的单个元素
				Object key = entry.getKey();//获取map的键
				Object value = entry.getValue();//获取map的值
			   System.out.println("key=" + key + " value=" + value);  
		  }  
		  //2.迭代:增强for循环，通用
		  System.out.println("===========================");
			//HashMap的遍历是建立在key的遍历的基础上，而key是用set机制管理的
			for(String key:tempMap.keySet())
				System.out.println(key+"->"+tempMap.get(key));
	}
	/**
	* des：list遍历
	*	List 代表一个元素有序、且可重复的集合，集合中的每个元素都有其对应的顺序索引
	*	List 允许使用重复元素，可以通过索引来访问指定位置的集合元素。
	* 	List 默认按元素的添加顺序设置元素的索引。
	* 	List 集合里添加了一些根据索引来操作集合元素的方法
	* 	list本质就是个对象数组
	* 	小结：有序,可重复。
	*/
	public static void listLoopThrough() {
		
		 List<String> list= new ArrayList<String>();
		 //list可以存放对象
		 list.add("11");
		 list.add("22");
		 list.add("33");
		 list.add("44");
		 
		 //1.迭代：迭代器iterator迭代，通用

		 Iterator<String> it = list.iterator();
		 while(it.hasNext()){
			 System.out.println(it.next());
		 }
		 //foreach 循环是1迭代的缩写吗
		 
		 //2.迭代:增强for循环，通用
		 System.out.println("--------for----------");
		 for(Object obj :list){
		 System.out.println(obj);
		  
		 }
		  
		  
		 //3.迭代：通过元素的索引迭代，用普通for循环事现
		 System.out.println("--------get(int index)----------");
		 	for(int i=0 ;i<list.size();i++){
			System.out.println(list.get(i));
		 }
		 
		  
		 
		 //4.迭代：通过ListIterator迭代，也可向前迭代的。List特有
		 ListIterator listIt = list.listIterator();
		 System.out.println("--------ListIterator正向迭代----------"); 
		 while(listIt.hasNext()){
			 System.out.println(listIt.next());
		 }//指针已经到末尾了
		  
		 System.out.println("--------ListIterator反向迭代----------"); 
		 while(listIt.hasPrevious()){
			System.out.println(listIt.previous());
		 }
	}
	/**
	* des：set遍历
	* 	http://blog.csdn.net/sunrainamazing/article/details/71577893
	* 	小结：无序,不可重复
	*/
	public static void  TraversalSet() {
	        /*
	        //List转换成HashSet
	       	List<String> list = new ArrayList<>(
	        Arrays.asList("tom","cat","Jane","jerry"));
	        Set<String> set = new HashSet<>();
	        set.addAll(list);
	        */
			Set<String> set=new HashSet<String>();
			set.add("1");
			set.add("2");
			set.add("2");//对象重复因此存入HashSet失败 
	        //1.迭代：迭代器iterator迭代，通用
	        Iterator it1 = set.iterator();
	        while(it1.hasNext()){
	            System.out.println(it1.next());
	        }

	        //2.迭代:增强for循环，通用
	        for(String value: set){
	            System.out.println(value);
	        }


	        //集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
	        //这种遍历方法不太了解？
	        for(Iterator it2 = set.iterator();it2.hasNext();){
	            System.out.println(it2.next());
	        }

	}

	public static void  fundamentalTreeSet() {
		Set<Integer> treeSet=new TreeSet<Integer>();
		treeSet.add(2);
		treeSet.add(5);
		treeSet.add(3);
		treeSet.add(3);//一样拒接接收
		Iterator<Integer> iterator=treeSet.iterator();
		//1.迭代：迭代器iterator迭代，通用
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("===========================");
		//2.迭代:增强for循环，通用
		for(Integer i:treeSet) {
			System.out.println(i);
		}
	}
	

}
