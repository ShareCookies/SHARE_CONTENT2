package com.hcg.javaTest;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//����ö��
        for (EnumDefined e : EnumDefined.values()) {
        	//System.out.println("��ʼ");
            System.out.println(e.toString());
            //System.out.println("����");
        }
        System.out.println(EnumDefined.FRI);
        	
	}

}
