/**
 * 
 */
package com.china.hcg.io.io;

import java.io.*;

/**
 * 介绍：
 *
 * 如果我们使用DataOutputStream写入数据，Java保证我们可以使用DataInputStream谁确地读取数据一无论读和写数据的平台 多么不同。这-点很有价值，因为我们都知道，人们曾经花费了大量时间去处理特定于平台的数据问题。只要两个平台上都有Java,这种问题就不会再发生。
 * 当我们使用DataOutputStream写字符串时，让DataInputStream能够恢复它的唯一可靠的做法就是使用UTF-8编码，在这个示例中是用writeUTF0和readUTF0来实现的。
 * 附：
 * UTF-8：
 * UTF-8是-种多字节格式，其编码长度根据实际使用的字符集会有所变化。
 * 如果我们使用的只是ASCII或者几乎都是ASCII字符(只占7位)，那么就显得极其浪费空间和带宽，所以UTF-8将ASCII字符编码成单-字节的形式，而非ASCII字符则编码成两到三个字节的形式。
 * 另外，字符串的长度存储在UTF-8字符串的前两个字节中。
 * java UTF-8：
 * 但是，writeUTFO和readUTF0使用的是适合于Java的UTF-8变体(JDK文档中有这些方法的详尽描述)，
 * 因此如果我们用一个非Java程序读取用writeUTF0所写的字符串时，必须编写-些特殊代码才能正确读取字符串。
 *
 * ？
 * 有了writeUTF和readUTF,我们就可以用DataOutputStream把字符串和其他数据类型
 * 相混合，我们知道字符串完全可以作为Unicode来存储，并且可以很容易地使用DataInput-
 * Stream来恢复它。
 * writeDouble0将double类型的数字存储到流中，并用相应的readDoubleO恢复它(对于其他
 * 的数据类型，也有类似方法用于读写)。
 * 但是为了保证所有的读方法都能够正常工作，我们必须知道流中数据项所在的确切位置，因为极有可能将保存的double数据作为一个简单的字节序列、char或其他类型读入。
 * 因此，我们必须:要么为文件中的数据采用固定的格式;要么将额外的
 * 信息保存到文件中，以便能够对其进行解析以确定数据的存放位置。注意，对象序列化和XML
 * (本章稍后都会介绍)可能是更容易的存储和读取复杂数据结构的方式。
 *
 * @author Administrator
 * @name 格式化输入输出(通常用于文本？)
 * DataOutputStream格式化输出。
 * DataInputStream格式化输入。
 */
public class FormattedInputOutputDemo {

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
			demo();
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
	public static void demo() throws IOException{
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("E://test.txt")));
        out.writeDouble(3.1415926);
        out.writeUTF("地方就是发哪里发");
        out.close();



		DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream("E://test.txt")));
		//？如何实现只读取到double数据的。
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
//		while (in.available()!=0) {
//		//while (true) {
//			System.out.println((char)in.readByte());
//		}
	}

}
