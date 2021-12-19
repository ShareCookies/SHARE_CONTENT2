/**
 * 
 */
package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 *
 */
public class DaemonFromFactoty implements Runnable{

	public void run() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+""+this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executorService=Executors.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0; i < 10; i++) {
			executorService.execute(new DaemonFromFactoty());
		}
		System.out.println("all daemons started");
		TimeUnit.MILLISECONDS.sleep(500);
	}

}
