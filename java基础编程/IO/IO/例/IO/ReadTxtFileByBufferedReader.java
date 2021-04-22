package com.china.hcg.io.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * @description 读取文本文件
 * @author hecaigui
 * @date 2021-4-16
 * @param
 * @return
 * <p>
 * 作用：读取一文件字符串
 * 介绍：
 * 	使用string或file对象生产FileReader，
 * 	将产生的引用传给BufferedReader构造器，对文件进行缓冲以便提高速度。
 * 	BufferedReader的readLine()是进行读取的接口，当readLine返回null时，就到达文件的末尾。
 * BufferedReader缓冲字符输入流：
 * 	该类是一个包装类，它可以包装字符流，将字符流放入缓存里，
 * 	先把字符读到缓存里，到缓存满了或者你flush的时候，再读入内存，
 * 	就是为了提供读的效率而设计的。 * </p>
 * @author Administrator
 */
public class ReadTxtFileByBufferedReader {

	public static String read(String fileName) throws IOException{
		//为了提高速度，将所产生的引用传给一个BufferedReader构造器，对那个文件进行缓冲。
		BufferedReader in=new BufferedReader(new FileReader(fileName));
		String string;
		StringBuilder sb=new StringBuilder();
		//BufferedReader提供了readLine0方法，当readLine0将返 回nul时，你就达到了文件的末尾。
		// 所以这是我们的最终对象和进行读取的接口。
		while ((string=in.readLine())!=null) {
			//包括必须添加的换行符,因为readLine0已将它们删掉
			sb.append(string+"\n");
		}
		in.close();
		return sb.toString();
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(read("E://test.txt"));
	}

}
