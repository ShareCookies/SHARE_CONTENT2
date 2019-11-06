/**
 *	https://blog.csdn.net/veryisjava/article/details/51675036
 *	model类实现Comparable<T>,即可用Collection.sort对list排序
 */
package com.hcg.javaTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
* @ClassName: sortModel
* @Description: 对List集合中的元素进行排序
* @author hcg
* @date 2018年7月19日
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
		int i = this.getAge() - o.getAge();//先按照年龄排序。当前的比对比的大，返回正数，排序放后头。
		if(i == 0){
			return this.score - o.getScore();//如果年龄相等了再用分数进行排序
		}
		return i;//从大到小排，加个-
	}
	public static void main(String[] args) {
		List<SortModel> users = new ArrayList<SortModel>();
		users.add(new SortModel(78, 26));
		users.add(new SortModel(67, 23));
		users.add(new SortModel(34, 56));
		users.add(new SortModel(55, 23));
		Collections.sort(users);
		for(SortModel user : users){
			System.out.println(user.getScore() + "," + user.getAge());//结果为从小到大排序
		}

	}
}
 

