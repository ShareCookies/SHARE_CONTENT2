/**
 * 
 */
package test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 介绍：
 * 	读取格式化数据，可使用DataInputStream，是一个面向字节的IO类(不是面向字符的)。
 * 	因此要使用InputStream类而不是Reader类，ByteArrayInputStream是一个适合传递给DataInputStream的InputStream
 * 	用InputStream可，以字节形式读取任何数据（如一个文件），不过这里使用的是字符串
 * @author Administrator
 * @name 格式化的内存输入？
 */
public class FormattedMemoryInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			DataInputStream in=new DataInputStream(
//					new ByteArrayInputStream(
//							BufferedInputFile.read("E://test.txt").getBytes()));
//			while (true) {
//				System.out.println((char)in.readByte());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("end of stream");
//			//e.printStackTrace();
//		}
		try {
			EOF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("没字符读取会出现异常啊");

		}
	}
	/**
	 * 从DataInputStream用readByte()一次一字节读取字符，那么任何字节的值都是合法的结果？，就无法用返回值来检测输入是否结束
	 * 但可以用available来看还有多少个供读取的字符
	 * @throws IOException 
	 */
	public static void EOF() throws IOException{
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream("E://test.txt")));
		while (in.available()!=0) {
		//while (true) {
			System.out.println((char)in.readByte());
		}
	}

}
