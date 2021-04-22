/**
 * 
 */
package com.china.hcg.io.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * 介绍：
 * 	示例中，从BufferedInputFile.read()读入的string结果
 * 	被用来创建一个StringReader
 * 	然后调用read()每次读取一个字符，并在控制台显示
 * 	StringReader？
 * 		A character stream whose source is a string.字符串输入流、其本质就是字符串
 * 		StringReader把字符串输出有意义吗？
 * @author Administrator
 * @name 从内存输入?
 * ？为什么叫从内存输入
 */
public class MemoryInput {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringReader in=new StringReader(ReadTxtFileByBufferedReader.read("MemoryInput.java"));
		int c;
		while ((c=in.read())!=-1) {
			System.out.println((char)c);
		}
	}

}
