/**
 * 
 */
package com.hcg.javaTest;


/**
* @ClassName: InsertionSort
* @Description: TODO(������һ�仰��������������)
* @author hcg
* @date 2018��7��29��
*
*/

public class InsertionSort {

	/**
	* @Title: main
	* @Description: TODO(������һ�仰�����������������)
	* @param @param args    ����
	* @return void    ��������
	* @throws
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a= {5,2,4,7,1,3};
		for (int i = 1; i < a.length; i++) {
			Integer key=a[i];//��ǰָ��ֵ��������
			int j=i-1;//��ȡ��ǰָ�룬���ָ��
			
			while (j>=0&&a[j]>key  ) {//������ָ������0�ң� ���ָ��ֵ���ڵ�ǰָ��ֵ�� ����ָ�뻻λ��ָ�������ƶ�һλ
				a[j+1]=a[j];
				j=j-1;
			}
			a[j+1]=key;//  ������һ�����ǰ���Сֵ�ŵ����������ǡ��λ��
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
