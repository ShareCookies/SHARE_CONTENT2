/**
 *	https://blog.csdn.net/veryisjava/article/details/51675036
 *	model��ʵ��Comparable<T>,������Collection.sort��list����
 */
package com.hcg.javaTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
* @ClassName: sortModel
* @Description: ��List�����е�Ԫ�ؽ�������
* @author hcg
* @date 2018��7��19��
*
*/

public class SortModel implements Comparable<SortModel>{

	
	private int score;
	
	private int age;
	
	public SortModel(int score, int age){
		super();
		this.score = score;
		this.age = age;
	}
 
	public int getScore() {
		return score;
	}
 
	public void setScore(int score) {
		this.score = score;
	}
 
	public int getAge() {
		return age;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
 
	@Override
	public int compareTo(SortModel o) {
		int i = this.getAge() - o.getAge();//�Ȱ����������򡣵�ǰ�ıȶԱȵĴ󣬷�������������ź�ͷ��
		if(i == 0){
			return this.score - o.getScore();//���������������÷�����������
		}
		return i;//�Ӵ�С�ţ��Ӹ�-
	}
	public static void main(String[] args) {
		List<SortModel> users = new ArrayList<SortModel>();
		users.add(new SortModel(78, 26));
		users.add(new SortModel(67, 23));
		users.add(new SortModel(34, 56));
		users.add(new SortModel(55, 23));
		Collections.sort(users);
		for(SortModel user : users){
			System.out.println(user.getScore() + "," + user.getAge());//���Ϊ��С��������
		}

	}
}
 

