package com.hcg.javaTest;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//遍历枚举
        for (EnumDefined e : EnumDefined.values()) {
        	//System.out.println("开始");
            System.out.println(e.toString());
            //System.out.println("结束");
        }
        System.out.println(EnumDefined.FRI);
        	
	}

}
