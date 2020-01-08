package test;

import java.util.concurrent.ThreadFactory;

/**
 * 通过编写定制的ThreadFactory可以定制由Executor创建的线程的属性。
 * @author Administrator
 *
 */
public class DaemonThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable paramRunnable) {
		// TODO Auto-generated method stub
		Thread thread=new Thread(paramRunnable);
		thread.setDaemon(true);
		return thread;
	}

}
