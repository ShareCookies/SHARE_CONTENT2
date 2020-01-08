/**
 * 
 */
package test;

import java.util.concurrent.ThreadFactory;

/**
 * @author Administrator
 *
 */
public class HandlerThreadFactory implements ThreadFactory {

	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable paramRunnable) {
		// TODO Auto-generated method stub
		System.out.println(this+"creating new thread");
		Thread thread=new Thread(paramRunnable);
		System.out.println("created"+thread);
		thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh="+thread.getUncaughtExceptionHandler());
		return thread;
	}

}
