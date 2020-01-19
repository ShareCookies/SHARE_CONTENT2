/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 * JavaSE5在PrintWriter中添加一个辅助构造器，
 * 使得你不必在每次希望创建文本文件并向其写入时，都去执行装饰工作。
 * 该案例中你任是在进行缓存输出，只是你不必自己去实现。
 * 注，java并未为其他常见的写入任务提供快捷方式，因此典型IO仍包含大量冗余文本。
 * @author Administrator
 * @name 文本文件输出的快捷方式
 */
public class FileOutputShortcut {
	static String file="E://testOuput1.txt";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(
				new StringReader(
						BufferedInputFile.read("E://test.txt")));
		PrintWriter out=new PrintWriter(file);
		int lineCount=1;
		String string;
		while ((string=in.readLine())!=null) {
			out.println(lineCount++ + ":" + string);
		}
		out.close();
		System.out.println(BufferedInputFile.read(file));
		
	}

}
