package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
* @ClassName: LinkedHashMapDemo
* @Description: TODO(������һ�仰��������������)
* @author hcg
* @date 2018��9��2��
*
*/

public class LinkedHashMapDemo {

	/**
	* @Title: main
	* @Description: TODO(������һ�仰�����������������)
	* @param @param args    ����
	* @return void    ��������
	* @throws
	*/

	public static void main(String[] args) {
		/*
		 * ֵ�ǰ�����˳�������
		 */
		LinkedHashMap<Integer,String> linkedMap =
		new LinkedHashMap<Integer,String>(countingMapData(9));
		System.out.println(linkedMap);
		/*
		 * ֵ�ǰ�����˳������ģ�Least- recently-used order��
		 */
		linkedMap =new LinkedHashMap<Integer,String>(16,0.75f, true);
			//  ����һ����ָ����ʼ�������������Ӻ�����ģʽ�Ŀ� LinkedHashMap ʵ����
			//	ָ����ʼ����.Ĭ�ϳ�ʼ����Ϊ16
			//	�������ӣ�һ���� 0.75f������ Ԫ�ظ��� ���� �������ȵ�0.75�� ʱ����������
			//	����ʽ false ���ڲ���˳��, true ���ڷ���˳��Ĭ��false

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
			simulateMap.put(i, "���ǵ�"+i+"��");
		}
		return simulateMap;
	}

}
