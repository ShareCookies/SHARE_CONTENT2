package test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
* @ClassName: throughSetAndEdit
* @Description: ����list��set��ͬʱ���޸���ֵ(������һ�仰��������������)
* @author hcg
* @date 2018��9��2��
*
*/

public class throughSetAndEdit {

	
	public throughSetAndEdit() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		/*
		* ʹ��ListIterator�������޸�ֵ���Ƽ���
		*/
		//https://blog.csdn.net/gooooa/article/details/77530112
		List<String> strings =new ArrayList<>();
		strings.add("1");strings.add("2");strings.add("3");strings.add("2");strings.add("5");
		ListIterator<String> iterator=strings.listIterator();
		while (iterator.hasNext()) {
			String string=iterator.next();
			if (string.equals("2")) {//����Ƕ���Ļ���������set��ȥ����Ϊ���ô��ݣ�����
				iterator.set("1");
			}
		}
		for (String string : strings) {
			System.out.println(string);
		}
		/*
		* ʹ�û���for�������޸�ֵ
		*/
	}

}
