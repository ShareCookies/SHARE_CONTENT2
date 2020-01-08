/**
 * 
 */
package test;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * @author Administrator
 *
 */
public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	/* (non-Javadoc)
	 * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread, java.lang.Throwable)
	 */
	@Override
	public void uncaughtException(Thread paramThread, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println("caught"+e);
	}

}
