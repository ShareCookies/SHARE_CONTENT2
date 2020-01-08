/**
 * 
 */
package test;

/**
 * 介绍：
 * 	输出说明不同任务的执行在线程被换进换出时混在一起。
 * 	这种交换是由线程调度器自动控制的。如果你的机器有多个处理器，线程调度器将会在这些处理器之间默默地分发线程。
 * @author Administrator
 * @name 线程调度器,java线程调度器自动为线程分配时间论证
 */
public class MoreBasicThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			new Thread(new task()).start();
		}
	}

}
class task implements Runnable{
	protected int countDown =10;
	private static  int taskCount=0;
	private final int id=taskCount++;
	public task() {
		
	}
	public task(int countDown) {
		this.countDown=countDown;
	}
	public String status() {
		return "#"+id+"("+(countDown>0? countDown : "Off!")+"),";
	}
	@Override
	public void run() {
		while (countDown-- >0) {
			System.out.println(status());
			//Thread.yield();
		}
	}
	
}
