/**
 * 
 */
package com.china.hcg.thread.study.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock后未解锁，还能lock!
 * 一个线程已经获得了锁，其内部还可以多次申请该锁成功
 * @author Administrator
 * lock测试,
 */
public class ReentrantLockTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		reentrant();

	}
	/**
	 * @description 可重入特性演示
	 */
	static void reentrant(){
		Thread t1 = new Thread(new ReentrantLockRunnable());
		t1.setName("t1");
		Thread t2 = new Thread(new ReentrantLockRunnable());
		t2.setName("t2");
		t1.start();
		t2.start();
	}

	/**
	 * @description 公平性选择特性演示.
	 * 对fairTest()和unFairTest()进行测试会发现： 公平性锁每次都是从同步队列中的 第一个节点获取到锁，而非公平性锁出现了一个线程连续获取锁的情况。
	 * 为什么会出现线程连续获取锁的情况呢？
	 *  nonfairTryAcquire(int acquires)方法，当一个线程请求锁时，只要获取了同步状态即成功获取锁。
	 *      因此刚释放锁的线程再次获取同步状态的几率会非常大，使得其他线程只能在同步队列中等待。
	 *      为什么刚释放的锁的线程在次获得锁几率大了，？
	 *      因为刚释放，还没进入等待队列，又申请锁，jvm就把锁丢给你了 ？ 因为从队列那线程在分配cpu..还要时间，jvm判断你会更快
	 *      这里的分配工作是jvm来了，还是系统来了？应该是jvm
	 * 非公平性锁可能使线程“饥饿”，为什么它又被设定成默认的实现呢：
	 * 	    因为非公平性锁引起的线程上下文切换更少。
	 *      例：
	 * 	    10个线程，每个线程获取100000次锁，通过vmstat统计测 试运行时系统线程上下文切换的次数。
	 * 	    pdf251
	 */
	static void fairTest(){
		 final FairAndUnfairTestClass fairLock = new FairAndUnfairTestClass(true);

		 Thread thread1 = new Thread(new Runnable() {
			 @Override
			 public void run() {
			 	fairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+fairLock.getQueuedThreads());
				 fairLock.unlock();

				 fairLock.lock();
				 System.err.println("lock by"+Thread.currentThread()+"wait thread"+fairLock.getQueuedThreads());
				 fairLock.unlock();
			 }
		 });
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				fairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+fairLock.getQueuedThreads());
				fairLock.unlock();

				fairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+fairLock.getQueuedThreads());
				fairLock.unlock();
			}
		});
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				fairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+fairLock.getQueuedThreads());
				fairLock.unlock();

				fairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+fairLock.getQueuedThreads());
				fairLock.unlock();
			}
		});
		thread1.start();

		thread2.start();

		thread3.start();
	}
	static void unfairTest(){
		// 可重入锁默认非公平
		FairAndUnfairTestClass unfairLock = new FairAndUnfairTestClass(false);
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				unfairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+unfairLock.getQueuedThreads());
				unfairLock.unlock();

				unfairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+unfairLock.getQueuedThreads());
				unfairLock.unlock();
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				unfairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+unfairLock.getQueuedThreads());
				unfairLock.unlock();

				unfairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+unfairLock.getQueuedThreads());
				unfairLock.unlock();
			}
		});
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				unfairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+unfairLock.getQueuedThreads());
				unfairLock.unlock();

				unfairLock.lock();
				System.err.println("lock by"+Thread.currentThread()+"wait thread"+unfairLock.getQueuedThreads());
				unfairLock.unlock();
			}
		});
		thread1.start();

		thread2.start();

		thread3.start();
	}
	private static class FairAndUnfairTestClass extends ReentrantLock {
		public FairAndUnfairTestClass(boolean fair) { super(fair); }
		/**
		 * @description 该类主要公开了getQueuedThreads()方法，
		 * 该方法返回正在等待获取锁的线程列表，由于列表是逆序输出，为了方便观察结果，将其进行反转？
		 */
		@Override
		public Collection<Thread> getQueuedThreads() {
			List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
			Collections.reverse(arrayList);
			return arrayList;
		}
	}
}
class ReentrantLockRunnable implements Runnable{
	private static Lock lock=new ReentrantLock();
	//private  Lock lock=new ReentrantLock();
	int i = 0;
	@Override
	public void run() {

		try {
			lock.lock();
			System.err.println(Thread.currentThread().getName()+"lock:"+i);
			if (++i < 3){
				// 拥有锁的线程可以不断再获取锁
				this.run();
			}
		}
		finally {
				System.err.println(Thread.currentThread().getName()+"调用unlock:"+(i-1));
				lock.unlock();
				lock.unlock();
		}
	}
}
