package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
* @ClassName: LinkedHashMapDemo
* @Description: TODO(这里用一句话描述这个类的作用)
* @author hcg
* @date 2018年9月2日
*
*/

public class LinkedHashMapDemo {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    参数
	* @return void    返回类型
	* @throws
	*/

	public static void main(String[] args) {
		/*
		 * 值是按插入顺序输出的
		 */
		LinkedHashMap<Integer,String> linkedMap =
		new LinkedHashMap<Integer,String>(countingMapData(9));
		System.out.println(linkedMap);
		/*
		 * 值是按访问顺序输出的，Least- recently-used order。
		 */
		linkedMap =new LinkedHashMap<Integer,String>(16,0.75f, true);
			//  构造一个带指定初始容量、加载因子和排序模式的空 LinkedHashMap 实例。
			//	指定初始容量.默认初始容量为16
			//	加载因子，一般是 0.75f。即当 元素个数 超过 容量长度的0.75倍 时，进行扩容
			//	排序方式 false 基于插入顺序, true 基于访问顺序。默认false

		linkedMap.putAll (countingMapData(9));
		System.out.println(linkedMap);
		for(int i=0;i<6 ;i++)linkedMap.get(i);
		System.out.println(linkedMap);
		linkedMap.get(0);
		System.out.println(linkedMap);
		
	}
	public static Map<Integer,String> countingMapData(int num) {
		Map<Integer,String> simulateMap=new HashMap<Integer,String>();
		for (int i = 0; i < num; i++) {
			simulateMap.put(i, "这是第"+i+"个");
		}
		return simulateMap;
	}

}
