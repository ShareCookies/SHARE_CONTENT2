/**
 * 
 */
package test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 如果你尝试着在一个对象上调用其synchronized方法,而这个对象的锁已经被其他任务获得，那么调用任务将被挂起(阻塞)，直至这个锁可获得。
	但ReentrantLock上阻塞的任务可以被中断。
 * @author Administrator
 * @name ReentrantLock上阻塞的任务可以被中断。
 */
public class InterruptMutex {

	public static void main(String[] args) throws InterruptedException {
		Thread thread=new Thread(new blocked2());
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("issuing t.interrupt()");
		thread.interrupt();
	}

}
class BlockedMutex{
	private Lock lock=new ReentrantLock();
	public BlockedMutex() {
		// TODO Auto-generated constructor stub
		lock.lock();//获取锁
	}
	public void f() {
		// TODO Auto-generated method stub
		try {
			//this will never be available to second task 对第二个任务来说这是无效的
			lock.lockInterruptibly();
			System.out.println("lock acqiered in f()");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("reentrantLock被中断或出现异常");
		}
	}
}
class blocked2 implements Runnable{
	BlockedMutex blocked2=new BlockedMutex();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("waiting for f() in blockedmutex");
		blocked2.f();
		System.out.println("bronken out of blocked call");
	}
	
}
