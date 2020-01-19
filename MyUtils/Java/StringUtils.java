/**
 * 
 */
package com.hecaigui.EAS.utils;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *
 */
public class StringUtils {
	/**
	 * 生成唯一标识符
	 * @return
	 */
	public static String uuidString(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * 字符串转为二进制流
	 * @param string
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static ByteArrayInputStream toStream(String string) throws UnsupportedEncodingException {
		return new ByteArrayInputStream(string.getBytes("utf-8"));
	}
	/**
	 * 第一个字符大写
	 * @param fildeName
	 * @return
	 * @throws Exception
	 */
    public static String firstCapital(String fildeName) throws Exception{  
        byte[] items = fildeName.getBytes();  
        items[0] = (byte) ((char) items[0] - 'a' + 'A');  
        return new String(items);  
    }  
	/**
	 * 第一个字符小写
	 * @param fildeName
	 * @return
	 * @throws Exception
	 */
    public static String firstLower(String fildeName) throws Exception{  
        byte[] items = fildeName.getBytes();  
        items[0] = (byte) ((char) items[0]+32);  
        return new String(items);  
    }    
    /**
     * 获取文件后缀名
     * @param fileName
     * @return
     */
    public static String fileSuffix(String fileName) {
		String[] strings=fileName.split("\\.");
		if (strings.length>=2) return strings[strings.length-1];
    	return null;
	}
    /**
     * 获取文件前缀名
     * @param fileName
     * @return
     */
    public static String filePrefix(String fileName) {
		String[] strings=fileName.split("\\.");
		String name="";
		if (strings.length>=2) {
			for (int i = 0; i < strings.length-1; i++) {
				name+=strings[i];
			}
			return name;
		}
    	return null;
	}
    /**
     * 字符串为null或leng为0 返回true
     * @return
     */
    public static boolean isNull(String string) {
		if(string==null||string.length()==0)return true;
		return false;
	}
    /**
     * 子字符串在父字符串内，返回true。区分大小写
     * @param parentStr
     * @param sonStr
     * @return
     */
    public static Boolean isContain(String parentStr,String sonStr) {
    	if (parentStr==null||sonStr==null) {
			return null;
		}
        if(parentStr.indexOf(sonStr)!=-1){ 
        	//System.out.println("包含"); 
        	return true;
        }else{ 
        	//System.out.println("不包含"); 
        	return false;
        }     	
    }
    public static String delHTMLTag(String htmlStr){ 
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤  
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

        return htmlStr.trim(); //返回文本字符串 
    } 
    public static String delSpace(String htmlStr){ 
        htmlStr = htmlStr.replaceAll("\n", "");
        htmlStr = htmlStr.replaceAll("\t", "");
        return htmlStr.trim(); //返回文本字符串 
    }
	/*
	字符串截取：
		https://blog.csdn.net/zjx2016/article/details/74557301

		String sb = "bbbdsajj,d,s";
		1.
			sb.substring(2);//结果：bdsajj,d,s。从索引号为2开始截取，一直到字符串末尾
			sb.substring(2, 4);//结果：bd 。索引号2开始到索引好4结束
	字符串分割：
		String[]  strs=sb.split(",");//结果：bbbdsajj    d    s
		将正则传入split()。返回的是一个字符串数组类型。不过通过这种方式截取会有很大的性能损耗，因为分析正则非常耗时。
		注：
			1.无法分割点，.是正则表达式里的一个关键字，
			如果没有经过转义split会把它当作一个正则表达式来处理的，
			所以str.split("\\.");
			2.sb为"",好像会切割为[]。 !
	字符串替换
		http://c.biancheng.net/view/836.html
		例：
			../正则.txt
	字符串转字符数组：
	    char ss[] = "rgrgd rgre 444".toCharArray();//利用toCharArray方法转换
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i]);
        }
	*/
}
