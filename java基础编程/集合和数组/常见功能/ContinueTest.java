package test;

import java.util.Iterator;

/**
* @ClassName: Test
* @Description: TODO(这里用一句话描述这个类的作用)
* @author hcg
* @date 2018年8月19日
*
*/

public class ContinueTest {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    参数
	* @return void    返回类型
	* @throws
	*/


	public static void main(String[] args) 
	{		
		outer:for(int i = 0 ; i<3; i++){ 
			System.out.println("i"+i);
			inner:for(int j = 0 ; j<2 ; j++){
				System.out.println("j"+j); //1 2 3
				continue outer;
			}
		}
		String[] strings= {"a","b","c"};
		for (String string : strings) {
			if (string.equals("b")) {
				continue;
			}
			System.out.println(string);
		}

	}
}
