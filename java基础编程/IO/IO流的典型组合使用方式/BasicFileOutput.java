/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 介绍：
 * 	FileWriter对象可以向文件写入数据。
 * 	1.创建一个与指定文件连接的FileWriter。
 * 	2.通常用BufferedWriter将其包装起来，用以缓冲输出。（可尝试移除次包装感受对性能的影响）
 * 	3. 本例中，为提供格式化机制？，又被装饰成PrintWriter
 * 	PrintWriter如何提供格式化机制
 * @author Administrator
 * @name 基本的文件输出
 */
public class BasicFileOutput {
	static String file="E://testOuput3.txt";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in=new BufferedReader(
				new StringReader(
						BufferedInputFile.read("E://test.txt")));
		PrintWriter out=new PrintWriter(
				new BufferedWriter(new FileWriter(file)));//用来向文本写入数据，如果文本不存在则创建
		int lineCount=1;
		String string;
		while ((string=in.readLine())!=null) {//读完数据readLine返回null
			out.println(lineCount++ + ":" + string);
		}
		out.close();//刷新清空输出缓冲区
		//show the stored file:
		System.out.println(BufferedInputFile.read(file));
	}

}
