/**
 * 
 */
package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * 
 */
public class NaiveExceptionHandling {
	
	public static void main(String[] args) {
		try {
			ExecutorService exe=Executors.newCachedThreadPool();
			exe.execute(new ExeceptionThreadTask());
			exe.shutdown();	
		} catch (Exception e) {//main线程中trycathch无法捕获子线程异常。
			// TODO: handle exception
		}
	}
}
