package com.china.hcg.thread.study.sync.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
	private static ThreadLocal<Apple> appleThreadLocal = new ThreadLocal<>();
	private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
	private static ThreadLocal<String> stringThreadLocal3 = new ThreadLocal<>();
	private static ThreadLocal<String> stringThreadLocal55 = new ThreadLocal<>();
	private static ThreadLocal<String> stringThreadLocal66 = new ThreadLocal<>();
	public static void main(String[] args) throws Exception{
		ThreadLocalTest threadLocalTest = new ThreadLocalTest();
		threadLocalTest.ThreadLocalUse();
	}
	/**
	 * @description ThreadLocal的简单使用，在不同的线程里使用ThreadLocal的get，set，都会把值存到对应的线程中。
	 * @author hecaigui
	 * @date 2022-1-8
	 * @param  * @param
	 * @return
	 */
	void ThreadLocalUse() throws Exception{
		class RunApple implements Runnable{
			private final int id;
			RunApple(int id){
				this.id = id;
			}
			@Override
			public void run(){
				while(!Thread.currentThread().isInterrupted()){
					appleThreadLocal.set(new Apple(id));
					//stringThreadLocal.set("test"+id);
					Thread.yield();
					System.out.println(this);
				}
				Thread.yield();
				System.out.println(this);
			}
			@Override
			public String toString(){
				//你会发现每个线程都只能拿到其本身的值
				return Thread.currentThread().getName()+ ":" + appleThreadLocal.get().getId();
			}
		}
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<3;i++){
			exec.execute(new RunApple(i));
		}
		TimeUnit.SECONDS.sleep(1);
		exec.shutdownNow();
	}
	void testThreadLocalMapNum() throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		class RunApple2 implements Runnable{
			@Override
			public void run(){
				appleThreadLocal.set(new Apple(2));
				Thread.yield();
				System.out.println(this);
			}
			@Override
			public String toString(){
				//你会发现每个线程都只能拿到其本身的值
				return Thread.currentThread().getName()+ ":" + appleThreadLocal.get().getId();
			}
		}

		exec.execute(new RunApple2());
		TimeUnit.SECONDS.sleep(1);
		exec.shutdownNow();
	}
}
class Apple{
	int id;

	public Apple(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}