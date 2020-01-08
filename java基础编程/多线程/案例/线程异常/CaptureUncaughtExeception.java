/**
 * 
 */
package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 为了解决捕获线程异常的问题，我们要修改Executor产生线程的方式。
 * Thread.UncaughtExceptionHandler是JavaSE5中的新接口，它允许你在每个Thread对象上都附着一个异常处理器。
 * Thread.UncaughtExceptionHandler.uncaughtException()会在线程因未捕获的异常而临近死亡时被调用。
 * 为了使用它，我们创建了一个新类型的ThreadFactory,它将在每个新创建的Thread对象上附着一个Thread.UncaughtExceptionHandler。
 * 我们将这个工厂传递给Executors用来创建ExecutorService的方法。
 * @author Administrator
 *
 */
public class CaptureUncaughtExeception {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec=Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExeceptionThreadTask());
	}

}
