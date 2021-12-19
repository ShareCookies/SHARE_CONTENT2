/**
 * 
 */
package com.china.hcg.thread.study.interrupt;

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
		Thread thread=new Thread(new ReentrantLockInterruptedBlock());
		thread.start();
		//阻塞的ReentrantLock可以抛出中断异常
			//为什么可以被中断。因为ReentrantLock阻塞线程是waiting状态。实现原理了？
		//证明：jps 获取java进程id。jstack进程id 查看进程的线程生命周期情况。
		Thread thread2=new Thread(new ReentrantLockInterruptedBlock());
		thread2.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("中断线程");
		thread.interrupt();
		thread2.interrupt();
	}

}
//可重入锁的可中断持有锁
class ReentrantLockInterruptedBlock implements Runnable{
	private static Lock lock=new ReentrantLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("waiting for f() in blockedmutex");

		try {
			//this will never be available to second task 对第二个任务来说这是无效的
			lock.lockInterruptibly();
			System.out.println(Thread.currentThread().getName()+"获取到锁");
			while (true){
				//在运行的线程是不会被中断的，还是要自己判断中状态 来响应中断。
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName()+"被中断或出现异常");
		} finally {
			lock.unlock();
		}
		System.out.println(Thread.currentThread().getName()+"结束");
	}
	
}
