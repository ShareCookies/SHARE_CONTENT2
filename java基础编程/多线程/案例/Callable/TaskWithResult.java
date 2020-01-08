/**
 * 
 */
package test;

import java.util.concurrent.Callable;

/**
 * 在任务完成时能够返回一个值，那么可以实现Callable接口
 * Callable：
 * 	具有类型参数的泛型，它的类型参数表示的是从call()中返回的值
 * @author Administrator
 * 从任务中产生值
 */
public class TaskWithResult implements Callable<String>{
	private int id;
	public  TaskWithResult(int id) {
		// TODO Auto-generated constructor stub
		this.id=id;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "result of TaskWithResult"+id;
	}

}
