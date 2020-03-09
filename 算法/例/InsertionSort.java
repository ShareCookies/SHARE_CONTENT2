/**
 * 
 */
package com.hcg.javaTest;


/**
* @ClassName: InsertionSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author hcg
* @date 2018年7月29日
*
*/

public class InsertionSort {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    参数
	* @return void    返回类型
	* @throws
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a= {5,2,4,7,1,3};
		for (int i = 1; i < a.length; i++) {
			Integer key=a[i];//当前指针值保存下来
			int j=i-1;//获取当前指针，左边指针
			
			while (j>=0&&a[j]>key  ) {//如果左边指针大等于0且， 左边指针值大于当前指针值， 则两指针换位且指针向左移动一位
				a[j+1]=a[j];
				j=j-1;
			}
			a[j+1]=key;//  反正这一步就是把最小值放到排序好数组恰当位置
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
