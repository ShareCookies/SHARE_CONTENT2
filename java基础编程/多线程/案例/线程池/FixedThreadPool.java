/**
 * 
 */
package test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool使用了有限的线程集来执行所提交的任务，
 * 一次性预先执行代价高昂的线程分配，因而可以限制线程数量和节约创建线程时间。、
 * 
 * @author Administrator
 * 
 */
public class FixedThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Date date=new Date();
		ExecutorService exec=Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			exec.execute(new Task());
		}
		exec.shutdown();
//		Date date2=new Date();
//		System.out.println(date2.getTime()-date.getTime());
	}

}
