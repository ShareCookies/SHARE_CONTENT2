/**
 * 
 */
package test;




/**
 * 
 * synchronized块必须给定一个在其上进行同步的对象，并且最合理的方式是，使用其方法正在被调用的当前对象: synchronized(this)。
 * 在这种方式中，如果获得了synchronized块上的锁，那么该对象其他的synchronized方法和临界区就不能被调用了。因此，如果在this上同步，临界区的效果就会直接缩小在同步的范围内。
 * @author Administrator
 * 在其他对象上同步。两个任务可以同时进入一个对象，只要这个对象的方法是在不同的锁上同步的即可。 
 */
public class DualSynch {
	private Object synchObject =new Object();
	public synchronized void f() {//f()在this同步（通过同步整个方法），
		for (int i = 0; i < 5; i++) {
			//System.out.println(Thread.currentThread()+"f");
			System.out.println("f");
			Thread.yield();
		}
	}
	public void g() {
		synchronized (synchObject) {//在syncObject上同步的synchronized块。所以与f同步是相互独立的
			for (int i = 0; i < 5; i++) {
				//System.out.println(Thread.currentThread()+"g");\
				System.out.println("g");
				Thread.yield();				
			}
		}
	}

	public static void main(String[] args) {
		final DualSynch dualSynch=new DualSynch();//fianl作用，去掉final？
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				dualSynch.f();//线程调用
			}
		}.start();
		dualSynch.g();//main线程调用
	}
}
