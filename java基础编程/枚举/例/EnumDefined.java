/**
 * 
 */
package com.hcg.javaTest;

/**
* @ClassName: enumDefined
* @Description: TODO(������һ�仰��������������)
* @author hcg
* @date 2018��7��25��
*
*/

public enum  WeekEnum{//��������**Enum
	MON, TUE, WED, THU, FRI, SAT, SUN;//������������ĸ��д
}
ʹ�ã�
		https://blog.csdn.net/qq_27093465/article/details/52180865
		1.����ֵ
			Integer n=WeekEnum.MON.ordinal();
			System.out.println(n);
		2.ö������
			String string=WeekEnum.MON.name();
			System.out.println(string);
		
		3.����ö��
			for (EnumDefined e : EnumDefined.values()) {
				//System.out.println("��ʼ");
				System.out.println(e.toString());
				//System.out.println("����");
			}
			System.out.println(EnumDefined.FRI);