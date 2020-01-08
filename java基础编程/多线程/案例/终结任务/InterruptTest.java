/**
 * 
 */
package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @name 中断测试
 */
public class InterruptTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executorService=Executors.newCachedThreadPool();
		executorService.execute(new task());
		Thread.sleep(2);
		executorService.shutdownNow();
		
		Thread thread=new Thread(new task());
		thread.start();
		//Thread.sleep(2);
		//thread.interrupt();
		thread.stop();//也是把线程状态设置为中断
	}

}
class task implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
//		while (true) {
//			System.out.println(111);
//		}
		
		//检测是否中断
//		while (!Thread.currentThread().isInterrupted()) {
//			System.out.println("该线程运行中");
//		}
		
		//如果中断则捕获异常
		try {
//		while (!Thread.currentThread().isInterrupted()) {
			while (true) {
				System.out.println("该线程运行中");
				TimeUnit.MILLISECONDS.sleep(1);//只有,有可能产生阻塞的代码才能捕获异常
			}	
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("睡眠中，线程被中断");
		}
		System.out.println("线程结束");
	}
	
}