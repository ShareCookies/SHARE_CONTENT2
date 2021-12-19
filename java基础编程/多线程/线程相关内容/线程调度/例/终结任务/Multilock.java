/**
 * 
 */
package com.china.hcg.thread.study.interrupt;

/**
 * 
 * 
 * 由于这个任务已经在第一个对f10的调用中获得了multiL.ock对象锁，因此同一个任务将在对f20的调用中再次获取这个锁，依此类推。
 * 一个任务应该能够调用在同一个对象中的其他的synchronized方法，因为这个任务已经持有锁了。
 * 
 * 那不同任务可以同时调用同一个对象中的多个synchronized方法吗？如何证明不行
 * @author Administrator
 * @name 锁互斥阻塞之，一个任务能够调用在同一个对象中的其他的synchronized方法。
 */
public class Multilock {

	public synchronized void f1(int count) {
		if (count-->0) {
			System.out.println("f1 calling f2 with count "+count);
			//f1(count);//一个任务已经持有锁，那么可以调用同一个对象的任意synchronized方法
			f2(count);
			
		}
	}
	public synchronized void f2(int count) {
		if (count-->0) {
			System.out.println("f2 calling f1 with count "+count);
			f1(count);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Multilock multilock=new Multilock();
		new Thread() {
			public void run() {
				multilock.f1(10);
			};
		}.start();
//		new Thread() {
//			public void run() {
//				while (true) {
//					multilock.f1(10);
////					try {
////						sleep(10000000);
////					} catch (InterruptedException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
//					System.err.println(111);
//				}
//			};
//		}.start();		
//		
//		new Thread() {
//			public void run() {
//				while (true) {
//					multilock.f1(2);
//					System.err.println(222);
//				}
//			};
//		}.start();		
	}

}
