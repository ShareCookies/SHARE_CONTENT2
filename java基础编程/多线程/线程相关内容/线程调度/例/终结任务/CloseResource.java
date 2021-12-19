/**
 * 
 */
package com.china.hcg.thread.study.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 不能中断正在试图获取synchronized锁或试图执行I/O的线程，
 * 解决该问题的有效方案是关闭任务在其上发生阻塞的底层资源
 * @author Administrator
 * 终结任务之关闭任务资源。
 */
public class CloseResource {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws Exception {
		//服务器连接流
		InputStream serverStream=new Socket("localhost", 8080).getInputStream();

		ExecutorService executorService=Executors.newCachedThreadPool();
		executorService.execute(new IOBlocked(serverStream));
		TimeUnit.MICROSECONDS.sleep(100);
		//把任务线程设为中断状态 //此操作是不会成功的，因为线程正在执行io，线程的中断状态?
		executorService.shutdownNow();
		
		TimeUnit.MICROSECONDS.sleep(1);
		System.out.println("关闭线程的io资源");
		//释放io资源，
		serverStream.close();
		executorService.shutdownNow();
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
		System.out.println("111");
	}

}
class IOBlocked implements Runnable{
	private InputStream in;
	public IOBlocked(InputStream is) {
		// TODO Auto-generated constructor stub
		in=is;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("准备开始io读取");
			in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("interrupt from I/O Blocked 从");
			} else {
				throw new RuntimeException(e);
			}
			
		}
		System.out.println("线程退出");
	}
	
}
