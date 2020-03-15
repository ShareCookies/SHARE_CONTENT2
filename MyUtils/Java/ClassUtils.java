/**
 * 
 */
package com.hecaigui.EAS.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class ClassUtils {
	
	/**
	 * 反射获取对象的属性。
	 * @return Map<String������, Object����ֵ> ｛属性名：属性值｝，只返回属性值非null的。注：继承自父类的属性无法获取
	 * @param object
	 * @throws Exception 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static Map<String, Object> getObjectValue2(Object object) throws NoSuchMethodException, SecurityException, Exception {
		Map<String, Object> map=new HashMap<>();
		 Class<?> class1 = object.getClass();//
		 
		Field[] fields = class1.getDeclaredFields(); // 获取实体类的所有属性，返回Field数组  
		//fields = class1.getFields();
		for (Field field : fields) {
			//System.out.println(field.getGenericType());//打印该类的所有属性类型  
			//System.out.println(field.getName());//打印该类的所有属性名
			/** 
	         * 这里需要说明一下：他是根据拼凑的字符来找你写的getter方法的 
	         * 在Boolean值的时候是isXXX（默认使用ide生成getter的都是isXXX） 
	         * 如果出现NoSuchMethod异常 就说明它找不到那个gettet方法 需要做个规范 
	         */  
	       Method m = (Method) object.getClass().getMethod(  
	               "get" + StringUtils.firstCapital(field.getName()));  
	       Object fieldValue =  m.invoke(object);//调用getter方法获取属性值  
	       if (fieldValue != null) {  
	    	   map.put(field.getName(), fieldValue);
	       }
		}
		return map;
	}
	
	/**
	 * 获取对象的｛属性名：属性值｝，只返回属性值非null的。注：能获取继承自父类的属性
	 * @return Map<String������, Object����ֵ>
	 * @param object
	 * @throws Exception 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static Map<String, Object> getObjectValue(Object object) throws NoSuchMethodException, SecurityException, Exception {
		Map<String, Object> map=new HashMap<>();
		List<Field> fieldList = new ArrayList<>();
		Class<?> tempClass = object.getClass();//先获取当前类
		//当为null的时候说明到达了最上层的父类(Object类).
		while (tempClass != null) {
		      fieldList.addAll(Arrays.asList(tempClass .getDeclaredFields()));
		      tempClass = tempClass.getSuperclass(); //得到父类,
		}
		for (Field field : fieldList) {
	       Method m = (Method) object.getClass().getMethod(  
	               "get" + StringUtils.firstCapital(field.getName()));  
	       Object fieldValue =  m.invoke(object); 
	       if (fieldValue != null) {  
	    	   map.put(field.getName(), fieldValue);
	       }
		}
		return map;
	}
	
	/**
	* 路径获取
	*/
	public static void main(String[] args) {
        // 用户的当前工作目录 ! F:\autoGenerateMapper
		String currentUserWorkingPath = System.getProperty("user.dir");
        System.out.println(System.getProperty("user.dir"));

        //当前类路径
        //Thread.currentThread().getContextClassLoader() and Class.getClassLoader() 的区别：https://blog.51cto.com/tianya23/731287
        String path = Thread.currentThread().getContextClassLoader().getResource(".").getPath();
        System.out.println(path);
    }
}
