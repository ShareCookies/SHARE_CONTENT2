/**
 * 
 */
package com.china.hcg.thread.study.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.*;

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
		//1. 测试interrupt()
//		Thread thread=new Thread(new taskForResponseInterrupt());
//		thread.start();
//		Thread.sleep(2);
//		thread.interrupt();


		//2. 测试中断异常
//		Thread thread=new Thread(new sleepTaskForDealInterruptedException());
//		thread.start();
//		Thread.sleep(2000);
//		thread.interrupt();



//附
		//1. 线程池中断测试shutdownNow
//		ExecutorService executorService=new ThreadPoolExecutor(2,10,10,TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
//			   int taskNum = 0;
//			@Override
//			public Thread newThread(Runnable r) {
//				Thread t = new Thread(r);
//				t.setName("线程"+(++taskNum));
//				return  t;
//			}
//		});
//		executorService.execute(new taskForResponseInterrupt());
//		executorService.execute(new Runnable() {
//			@Override
//			public void run() {
//				//该任务不响应中断.自顾自的不断运行
//				while (true) {
//					System.out.println(Thread.currentThread().getName()+"任务能响应中断");
//				}
//			}
//		});
//		Thread.sleep(1);
//		executorService.shutdownNow();

		//2.线程池之等待终结
//		ExecutorService executorService=new ThreadPoolExecutor(2,10,10,TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
//			   int taskNum = 0;
//			@Override
//			public Thread newThread(Runnable r) {
//				Thread t = new Thread(r);
//				t.setName("线程"+(++taskNum));
//				return  t;
//			}
//		});
//		executorService.execute(new taskForResponseInterrupt());
//		executorService.execute(new Runnable() {
//			@Override
//			public void run() {
//				//该任务不响应中断.自顾自的不断运行
//				while (true) {
//					//System.out.println(Thread.currentThread().getName()+"任务能响应中断");
//				}
//			}
//		});
//		Thread.sleep(1);
//		executorService.awaitTermination(2,TimeUnit.SECONDS);
//		System.err.println("该打印2s后才能打印");
	}

}
//关于中断响应的任务
class taskForResponseInterrupt implements Runnable{

	@Override
	public void run() {
		//检测是否中断
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println(Thread.currentThread().getName()+"任务能响应中断");
		}
	}
}
//关于中断异常处理的睡眠任务
class sleepTaskForDealInterruptedException implements Runnable{

	@Override
	public void run() {
		//如果中断则捕获异常
		try {
			System.out.println("睡眠线程运行中");
			TimeUnit.SECONDS.sleep(10);//只有,有可能产生阻塞的代码才能捕获异常
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("睡眠中，线程被中断，就会从睡眠中立刻返回");
		}
		System.out.println("线程结束");
	}
}