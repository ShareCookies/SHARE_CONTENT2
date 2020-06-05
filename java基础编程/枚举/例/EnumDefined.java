/**
 * 
 */
package com.hcg.javaTest;

/**
* @ClassName: enumDefined
* @Description: TODO(这里用一句话描述这个类的作用)
* @author hcg
* @date 2018年7月25日
*
*/

public enum  WeekEnum{//命名建议**Enum
	MON, TUE, WED, THU, FRI, SAT, SUN;//命名建议首字母大写
}
使用：
		https://blog.csdn.net/qq_27093465/article/details/52180865
		1.排序值
			Integer n=WeekEnum.MON.ordinal();
			System.out.println(n);
		2.枚举名称
			String string=WeekEnum.MON.name();
			System.out.println(string);
		
		3.遍历枚举
			for (EnumDefined e : EnumDefined.values()) {
				//System.out.println("开始");
				System.out.println(e.toString());
				//System.out.println("结束");
			}
			System.out.println(EnumDefined.FRI);