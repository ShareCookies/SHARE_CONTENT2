/**
 * 
 */
package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadExecutor就像是线程数量为1的FixedThreadPool
 * 如果向SingleThreadExecutor提交了多个任务，那么这些任务将排队，
 * 每个任务将会在下一个任务开始前结束，所有任务都使用相同线程。
 * Executor会序列化所遇提交给它的任务，并会维护它自己的悬挂任务队列（隐藏的）。
 * 注：你不需要在共享资源上处理同步
 * @author Administrator
 *
 */
public class SingleThreadExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec=Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Task());
		}
		exec.shutdown();
	}

}
