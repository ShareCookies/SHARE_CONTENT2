/**
 * 
 */
package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * PrintWriter可以对数据进行格式化，便于人们阅读。
 * 但是为了输出可供另一个流（DataInputStream），恢复的数据，我们这用DataOutputStream写入数据
 * DataInputStream是面向字节的，因此要用InputStream
 * 
 * 使用DataOutputStream写入数据，java保证我们可以使用DataIutputStream准确的读取数据
 * 无论读和写数据的平台多么不同。
 * 注：
 * 	1.读写字符串时用writeUTF()，使用的是utf-8编码，
 * 	但是这里的utf8编码是java的utf-8变体，用非java读取时要写一些特殊代码才能正确读取。
 * 	2.为保证所有读方法，能正常工作，我们要知道流中数据项所在的正确位置，因为可能将double类型以char后其他数据类型读入。
 * 	可以将额外的信息存到文件，以便确认数据的存放位置。
 * 	对象序列化和xml更适合存储和读取复杂数据结构。
 * 	xml能解决在不同计算平台之间移动数据，而不依赖于java。
 * @author Administrator
 * @name 存储和恢复数据
 */
public class StoringAndRecoveringData {


	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataOutputStream out=new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("E://test.txt")));
		out.writeDouble(3.14159);
		out.writeUTF("this is dd");
		out.writeDouble(2.333);
		out.writeUTF("fd dd");
		out.close();
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream("E://test.txt")));
		System.out.println(in.readDouble());
		//Only readUTF() will recover the Java-UTF String properly
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
	}

}
