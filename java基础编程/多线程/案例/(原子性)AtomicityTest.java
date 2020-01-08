/**
 * 
 */
package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 结果：程序将找到奇数值并终止，与预期不符
 * 
 * 尽管return i是原子性操作，但是缺少同步使其数值可以处于不稳定的中间状态时被读取。
 * 而且i也不是volatile因此还存在可视性问题。
 * ？
 * @author Administrator
 * 
 */
public  class AtomicityTest implements Runnable{

	private  int i=0;//加了volatile，输出结果一直为1。因为i值一改变就被同步到堆中
	public   int getValue() {//加synchronized就能解决这个问题,为啥了？是因为加了synchronized后其域内所有对象都会自动实现同步和可视化吗
		System.out.println(Thread.currentThread().getName());
		long t=4l/2l;//难道是因为加了synchronized后，锁对象的检测是个耗时操作，所以检测完以后evenIncrement都算完了
		return i;
	}
	private synchronized void evenIncrement() {//
		i++;
		i++;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		//System.exit(0);
		while(true) {
			evenIncrement();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Thread.currentThread().getName());
		
		ExecutorService exe=Executors.newCachedThreadPool();
		AtomicityTest test=new AtomicityTest();
		exe.execute(test);
		while (true) {
			int val=test.getValue();
			if (val%2!=0) {
				System.out.println(val);
				System.exit(0);
			}
		}
		
	}
}

/**
void f1();
	Code:
	0:aload_0
	1:dup
	2:getfield //feild i
	5:iconst_1 
	6:iadd
	7:putfield //field i
	10:return 
void f2();
	Code:
	0:aload_0
	1:dup
	2:getfield //feild i
	5:iconst_3 
	6:iadd
	7:putfield //field i
	10:return 
这些jvm指令是如何获取到的？
每条指令都会产生一个getput，它们之间还有一些其他指令。因此在获取和放置之间，另一个任务可能会修改这个域，所以以下操作不是原子性。
 * @author Administrator
 * java变量无法依赖原子性，实现同步
 */
class Atomicity{
	int i;
	void f1() {i++;}
	void f2() {i+=3;}
}