package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
*	如果代码中处处使用相同的异常处理器，那么更简单的方式是在Thread类中设置一个静态域，并将这个处理器设置为默认的未捕获异常处理器。
*	这个处理器只有在不存在线程专有的未捕获异常处理器的情况下才会被调用。
*	系统会检查线程专有版本，
*	如果没有发现，则检查线程组是否有其专有的uncaughtExcption方法，
*	如果也没有，再调用defaultUncaughExceptionHandler。
*	即>=5 ->线程专有异常处理器->默认异常处理器
*	<5 ->线程专有异常处理器->线程组...->默认异常处理器
*/
public class SettingDefaultHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		ExecutorService executorService=Executors.newCachedThreadPool();
		executorService.execute(new ExeceptionThreadTask());
	}

}
