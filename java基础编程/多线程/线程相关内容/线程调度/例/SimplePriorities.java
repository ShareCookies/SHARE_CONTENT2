/**
 * 
 */
package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 优先级是在run()开头部分设置，在构造器中设置不会有任何好处，因为Executor还没有开始执行任务。
 * 
 * @author Administrator
 * ???
 */
public class SimplePriorities implements Runnable{

	private   int countDown=5;
	private volatile double d;//no optimization 未最佳化
	private int priority;
	
	public SimplePriorities(int priority) {
		// TODO Auto-generated constructor stub
		this.priority=priority;
	}

	@Override
	public String toString() {
		return Thread.currentThread()+":"+countDown;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread.currentThread().setPriority(priority);
		while (true) {
			for(int i=1;i<10000;i++) {
				d+=(Math.PI+Math.E)/(double)i;
				if(i%1000==0)Thread.yield();
				
			}
			System.out.println(this);
			//System.out.println(countDown);
			if (--countDown==0) return;
		}
	}
	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exe.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		}
		exe.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		exe.shutdown();
	}
}
