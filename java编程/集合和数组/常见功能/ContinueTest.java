package test;

import java.util.Iterator;

/**
* @ClassName: Test
* @Description: TODO(������һ�仰��������������)
* @author hcg
* @date 2018��8��19��
*
*/

public class ContinueTest {

	/**
	* @Title: main
	* @Description: TODO(������һ�仰�����������������)
	* @param @param args    ����
	* @return void    ��������
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
