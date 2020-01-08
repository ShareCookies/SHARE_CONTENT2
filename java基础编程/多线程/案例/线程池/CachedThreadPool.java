/**
 * 
 */
package test;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPool在程序执行过程总通常会创建与所需数量相同的线程
 * 它是Executor的首选，只有当这种方式引发问题时，才需切换到FixedThreadPool
 * @author Administrator
 *
 */
public class CachedThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService exec=Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Task());
		}
		exec.shutdown();//线程将在，Executor中的任务完成之后，尽快退出
	}

}
