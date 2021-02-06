package com.china.hcg.redis;

import java.util.concurrent.TimeUnit;

/**
 * @autor hecaigui
 * @date 2021-1-25
 * @description
 */
public class DaemonWithThreadRelation implements Runnable{

	@Override
	public void run(){
		Thread daemon = new Thread(new Runnable(){//实现Runnable接口
			@Override
			public void run(){
				while (true){
					System.err.println("后台线程");
				}
			}
		});
		daemon.setName("后台线程1");//must call before start()
		daemon.setDaemon(true);//must call before start()
		daemon.start();
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new DaemonWithThreadRelation());
		thread.setName("子线程1");
		thread.start();
		System.out.println("主线程在");
		TimeUnit.MILLISECONDS.sleep(10000);
		System.out.println("主线程还在");
		TimeUnit.MILLISECONDS.sleep(10000);
		//注：可以通过jvisualvm.exe等来查看线程存活情况
	}

}
