package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExeceptionThreadTask implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		throw new RuntimeException();
		//System.err.println("exceptionThread");//出现异常线程后代码无法执行
	}
	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool();
		exe.execute(new ExeceptionThreadTask());
		exe.shutdown();
		for (int i = 0; i < 10; i++) {
			System.out.println("mainThread");//exceptionThread线程异常不会影响到main线程运行
		}
	}
}
