/**
 * 
 */
package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用了RandomAccessFile,类似组合使用了DataInputStream和DataOutputStream，因为它实现了相同的接口，DataInput和DataOutput
 * 
 * @author Administrator
 * @name 读写随机访问文件
 */
public class UsingRandomAccessFile {
	static String file="E://test.txt";
	static void display() throws IOException {
		RandomAccessFile rf=new RandomAccessFile(file, "r");
		for (int i = 0; i < 7; i++) {
			System.out.println(rf.readDouble());
		}
		System.out.println(rf.readUTF());
		rf.close();
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		RandomAccessFile rf=new RandomAccessFile(file, "rw");
		for (int i = 0; i < 7; i++) {
			rf.writeDouble(i*1.14);
		}
		rf.writeUTF("end of file");
		rf.close();
		display();
		rf=new RandomAccessFile(file, "rw");
		rf.seek(5*8);//利用seek()可以在文件中到处移动，并修改文件中某个值。double大小8字节，所以用5*8来查找第6个双精度值
		rf.writeDouble(47.00001);
		rf.close();
		display();
	}

}
