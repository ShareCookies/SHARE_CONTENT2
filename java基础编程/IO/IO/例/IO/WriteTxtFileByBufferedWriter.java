/**
 * 
 */
package com.china.hcg.io.io;

import java.io.*;

/**
 * 介绍：
 * 	FileWriter对象可以向文件写入数据。
 * 	1.创建一个与指定文件连接的FileWriter。
 * 	2.通常用BufferedWriter将其包装起来，用以缓冲输出。（可尝试移除次包装感受对性能的影响）
 * 	3. 本例中，为提供格式化机制？，又被装饰成PrintWriter
 * 	PrintWriter如何提供格式化机制
 * @author Administrator
 * @name 向文本写入数据，如果文本不存在则创建
 */
public class WriteTxtFileByBufferedWriter {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		write("写入文本测试","dd://test.txt");
		// TODO Auto-generated method stub
		//1.创建一个与指定文件连接的FileWriter。
		//2.通常用BufferedWriter将其包装起来，用以缓冲输出。（可尝试移除次包装感受对性能的影响）
		//PrintWriter作用？//为了提供格式化机制，它被装饰成了PrintWriter。按照这种方式创建的数据文件可作为普通文本文件读取。
//		PrintWriter out=new PrintWriter(
//				new BufferedWriter(new FileWriter(file)));//用来向文本写入数据，如果文本不存在则创建
//		Writer out=
//				new BufferedWriter(new FileWriter(file));//用来向文本写入数据，如果文本不存在则创建
//		int lineCount=1;
//		String string;
//        out.append("写入文本测试");
//		out.close();//刷新清空输出缓冲区
		//show the stored file:
		//System.out.println(ReadTxtFileByBufferedReader.read(file));
	}
	static boolean write(String content,String file) {
		try {
			//用来向文本写入数据，如果文本不存在则创建
			Writer out = new BufferedWriter(new FileWriter(file));
			out.append(content);
			out.close();//刷新清空输出缓冲区
			return false;
		} catch (IOException  ioException){
			ioException.printStackTrace();
		}
		return true;
	}
}
