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
		 * ����Ҳ���ֻ࣬��д������һ�� 
		 * �����������ñ���
		 */
		String[] array1;//��ѡ
		String array2[];//�÷�������� C/C++ ���� ����Java�в�����Ϊ���� C/C++ ����Ա�ܹ��������java���ԡ�
		/*
		 * �����������
		 */
		array1 = new String[4];
		array2 = new String[4];
		/*
		 * Ϊ���鸳��ֵ
		 */
		//...
		
		//Collection��Map����
		//ArrayAndCollection.mapLoopThrough();
		//ArrayAndCollection.listLoopThrough();
		//ArrayAndCollection.TraversalSet();
		ArrayAndCollection.fundamentalTreeSet();
	}
	/**
	 * des��Map����
	 * http://blog.csdn.net/zhu1qiu/article/details/71170850
	 */
	public static void mapLoopThrough() {
		  Map<String, String> tempMap = new HashMap<String, String>();  
		  tempMap.put("a","12");  
		  tempMap.put("b","34");  
		  tempMap.put("c","56");  
		 
		  	 //1.������������iterator������ͨ��
			 /*
			  * ����������ʹ�÷�����
			  * 	ǰ�᣺�ö���ʵ���˵������ӿ�
			  * 	1.�����ö����iterator()�������� Iterator����
			  * 	2.��whileѭ����ѭ������ΪIterator�����hasNext������hasNext���ж�Iterator�Ƿ�����һ��Ԫ�ء�
			  * 	3.����whileѭ����{}�н���������������Iterator�����next������������������÷����᷵�ص������е���һ��Ԫ�أ���������һ�λ��Զ������ƶ�(����ʵ����map��)?��
			  * 
			  */
		  Iterator it = tempMap.entrySet().iterator();  
		  while (it.hasNext()) {  
				Map.Entry entry = (Map.Entry) it.next();//��ȡmap�ĵ���Ԫ��
				Object key = entry.getKey();//��ȡmap�ļ�
				Object value = entry.getValue();//��ȡmap��ֵ
			   System.out.println("key=" + key + " value=" + value);  
		  }  
		  //2.����:��ǿforѭ����ͨ��
		  System.out.println("===========================");
			//HashMap�ı����ǽ�����key�ı����Ļ����ϣ���key����set���ƹ����
			for(String key:tempMap.keySet())
				System.out.println(key+"->"+tempMap.get(key));
	}
	/**
	* des��list����
	*	List ����һ��Ԫ�������ҿ��ظ��ļ��ϣ������е�ÿ��Ԫ�ض������Ӧ��˳������
	*	List ����ʹ���ظ�Ԫ�أ�����ͨ������������ָ��λ�õļ���Ԫ�ء�
	* 	List Ĭ�ϰ�Ԫ�ص����˳������Ԫ�ص�������
	* 	List �����������һЩ������������������Ԫ�صķ���
	* 	list���ʾ��Ǹ���������
	* 	С�᣺����,���ظ���
	*/
	public static void listLoopThrough() {
		
		 List<String> list= new ArrayList<String>();
		 //list���Դ�Ŷ���
		 list.add("11");
		 list.add("22");
		 list.add("33");
		 list.add("44");
		 
		 //1.������������iterator������ͨ��

		 Iterator<String> it = list.iterator();
		 while(it.hasNext()){
			 System.out.println(it.next());
		 }
		 //foreach ѭ����1��������д��
		 
		 //2.����:��ǿforѭ����ͨ��
		 System.out.println("--------for----------");
		 for(Object obj :list){
		 System.out.println(obj);
		  
		 }
		  
		  
		 //3.������ͨ��Ԫ�ص���������������ͨforѭ������
		 System.out.println("--------get(int index)----------");
		 	for(int i=0 ;i<list.size();i++){
			System.out.println(list.get(i));
		 }
		 
		  
		 
		 //4.������ͨ��ListIterator������Ҳ����ǰ�����ġ�List����
		 ListIterator listIt = list.listIterator();
		 System.out.println("--------ListIterator�������----------"); 
		 while(listIt.hasNext()){
			 System.out.println(listIt.next());
		 }//ָ���Ѿ���ĩβ��
		  
		 System.out.println("--------ListIterator�������----------"); 
		 while(listIt.hasPrevious()){
			System.out.println(listIt.previous());
		 }
	}
	/**
	* des��set����
	* 	http://blog.csdn.net/sunrainamazing/article/details/71577893
	* 	С�᣺����,�����ظ�
	*/
	public static void  TraversalSet() {
	        /*
	        //Listת����HashSet
	       	List<String> list = new ArrayList<>(
	        Arrays.asList("tom","cat","Jane","jerry"));
	        Set<String> set = new HashSet<>();
	        set.addAll(list);
	        */
			Set<String> set=new HashSet<String>();
			set.add("1");
			set.add("2");
			set.add("2");//�����ظ���˴���HashSetʧ�� 
	        //1.������������iterator������ͨ��
	        Iterator it1 = set.iterator();
	        while(it1.hasNext()){
	            System.out.println(it1.next());
	        }

	        //2.����:��ǿforѭ����ͨ��
	        for(String value: set){
	            System.out.println(value);
	        }


	        //�������ͨ�ñ�����ʽ, �Ӻ���İ汾����, �õ���������
	        //���ֱ���������̫�˽⣿
	        for(Iterator it2 = set.iterator();it2.hasNext();){
	            System.out.println(it2.next());
	        }

	}

	public static void  fundamentalTreeSet() {
		Set<Integer> treeSet=new TreeSet<Integer>();
		treeSet.add(2);
		treeSet.add(5);
		treeSet.add(3);
		treeSet.add(3);//һ���ܽӽ���
		Iterator<Integer> iterator=treeSet.iterator();
		//1.������������iterator������ͨ��
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("===========================");
		//2.����:��ǿforѭ����ͨ��
		for(Integer i:treeSet) {
			System.out.println(i);
		}
	}
	

}
