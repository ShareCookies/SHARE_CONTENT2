/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;




/**
 * @author Administrator
 *
 */
public class CallaleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CallaleDemo demo=new CallaleDemo();
		//demo.executorCallable();\
		demo.threadCallable();
	}
	/**
	 * 1.使用Executor启动Callable任务，
	 * 要使用submit()方法调用任务。
	 * submit()会产生Future对象，
	 * 	Future用Callable返回结果的特定类型进行了参数化。
	 * 不用isDone()进行检查就直接调用get(),get()将阻塞直至结果准备就绪。
	 */
	public void executorCallable() {
		ExecutorService exec=Executors.newCachedThreadPool();
		ArrayList<Future<String>> results=new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskWithResult(i)));//
		}
		for (Future<String> future : results) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				exec.shutdown();
			}
		}		
	}
	/**
	 * 2.使用Thread启动Callable任务，
	 * 任务要先用FutureTask修饰。
	 */
	public void threadCallable() {
		TaskWithResult td = new TaskWithResult(0);
	    //1.执行 Callable方式，需要 FutureTask(FutureTask是 Future接口的实现类)的支持，用于接收运算结果。
        FutureTask<String> result = new FutureTask<String>(td);
 
        new Thread(result).start();
 
        //2.接收线程运算后的结果
        try {
            String sum = result.get();//FutureTask可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
            System.out.println(sum);
            System.out.println("------------------------------------");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
		
	}
	
}
