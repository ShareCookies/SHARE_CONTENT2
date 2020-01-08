/**
 * 
 */
package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 *
 */
public class MutexEvenGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lock lock=new ReentrantLock();
		lock.lock();
		try {
		} finally {
			lock.unlock();
		}
	}

}
