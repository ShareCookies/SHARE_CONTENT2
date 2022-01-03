package com.china.hcg.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
	private static ThreadLocal<Apple> appleThreadLocal = new ThreadLocal<>();
	private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
	public static void main(String[] args) throws Exception{
		class RunApple implements Runnable{
			private final int id;
			RunApple(int id){
				this.id = id;
			}
			@Override
			public void run(){
				while(!Thread.currentThread().isInterrupted()){
					appleThreadLocal.set(new Apple(id));
					stringThreadLocal.set("11");
					Thread.yield();
					System.out.println(this);
				}
			}
			@Override
			public String toString(){
				return "#" + id + ":" + appleThreadLocal.get().getId();//只能拿到一个共享值，能拿到别的吗？
			}
		}
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new RunApple(i));
		}
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