/**
 * 
 */
package test;

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
		// TODO Auto-generated method stub
		ServerSocket serverSocket=new ServerSocket(8181);
		InputStream serverStream=new Socket("localhost", 8181).getInputStream();
		
		
		ExecutorService executorService=Executors.newCachedThreadPool();
		executorService.execute(new IOBlocked(serverStream));
		//executorService.execute(new IOBlocked(System.in));
		TimeUnit.MICROSECONDS.sleep(100);
		System.out.println("shutting down all threads");
		executorService.shutdownNow();//把任务线程设为中断状态
		
		TimeUnit.MICROSECONDS.sleep(1);
		System.out.println("closing"+serverStream.getClass().getName());
		serverStream.close();//release blocked resources //释放特殊任务资源，
		executorService.shutdownNow();
		TimeUnit.MICROSECONDS.sleep(1);
		//System.out.println("closing"+System.in.getClass().getName());
		//System.in.close();//release blocked resources  io输入流中断失败
		
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
			System.out.println("waiting for read");
			in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("interrupt from I/O Blocked");
			} else {
				throw new RuntimeException(e);
			}
			
		}
		System.out.println("exiting I/O Blocked run ");
	}
	
}
