package test;

/**
 * 线程可以驱动任务，因此你需要一种描述任务的方式，
 * 只需实现Runnable接口，编写run()凡是即可定义任务
 * @author Administrator
 * @name 定义任务
 */
public class Task  implements Runnable{

	protected int countDown =10;
	private static  int taskCount=0;
	private final int id=taskCount++;
	public Task() {
		
	}
	public Task(int countDown) {
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
