/**
 * 
 */
package test;

import java.sql.Time;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock后未解锁，还能lock!
 * 一个线程已经获得了锁，其内部还可以多次申请该锁成功
 * @author Administrator
 * lock测试,
 */
public class lockTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executorService=Executors.newCachedThreadPool();
//		finallyTest test=new finallyTest();
//		executorService.execute(test);
//		TimeUnit.SECONDS.sleep(2);
//		test.signal();
//		
		
		for (int i = 0; i < 5; i++) {
			executorService.execute(new threadTestSynchronized());
		}
	}

}
class finallyTest implements Runnable{
	private Lock lock=new ReentrantLock();
	private Condition con=lock.newCondition();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			await();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			// TODO: handle finally clause
			//System.out.println("挂起也会调用finally吗");//挂起操作不回触发finally
		}
	}
	
	private  void await() throws InterruptedException {
		// TODO Auto-generated method stub
		lock.lock();
		try {
			//wait();//lock下无法使用wait来挂起。所以要使用Condition来挂起
			con.await();
			
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}
	
	public   void signal() {
		System.out.println("验证lock未解开，是否还能在lock");
		lock.lock();
		System.out.println("第二次lock");
		try {
			//notifyAll();
			con.signalAll();
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}
	

}


class threadTestSynchronized implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//synchronizedTest.inNum();
			synchronizedTest.inNum2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class synchronizedTest{
	static Lock lock=new ReentrantLock();
	//每次只有一个线程能访问到，该共享资源
	public  synchronized static void inNum() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		TimeUnit.SECONDS.sleep(5);
	}
	//每次只有一个线程能访问到，该共享资源
	public   static void inNum2() throws InterruptedException {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(5);			
		} finally {
			lock.unlock();
		}
	}
}

