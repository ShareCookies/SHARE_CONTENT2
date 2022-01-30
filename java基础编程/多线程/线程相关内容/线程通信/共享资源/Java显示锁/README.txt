背景：
	内置锁这么好用，为什么还需多出一个显式锁呢。
	因为有些事情内置锁是做不了的，比如：
		我们想给锁加个等待时间超时时间，超时还未获得锁就放弃，不至于无限等下去；
		我们想以可中断的方式获取锁，这样外部线程给我们发一个中断信号就能唤起等待锁的线程；
		我们想为锁维持多个等待队列，比如一个生产者队列，一个消费者队列，以便提高锁的效率。
	显式锁正是为了解决这些灵活需求而生。

显示锁Lock：（Lock对象实现同步）
	显示锁Lock：
		./Lock接口.txt
	可重入锁:
		ReentrantLock可重入锁.txt
	可重入读写锁：
		ReentrantReadWriteLock读写锁.txt
	附：
	锁实现分析：
		介绍：
			Lock接口的实现类基本都是通过聚合了一个同步器的子类来完成线程访问控制的。
		队列同步器:AbstractQueuedSynchronizer
			大佬已经写好了显示锁的大部分功能，开发只需继承改类并重写部分方法，就可实现自定义的显示锁。
			详：
				队列同步器.txt
				队列同步器原理.txt
		ReentrantLock源码分析：
			ReentrantLock源码分析.java
		ReentrantReadWriteLock源码分析：
			ReentrantReadWriteLock读写锁源码分析.txt
	附：
		LockSupport工具
			介绍：
				1. 队列同步器中，当需要阻塞或唤醒一个线程的时候，都会使用LockSupport工具类来完成相应工作。
				2. 整个并发框架中对线程的挂起操作被封装在 LockSupport类中，LockSupport类中有各种版本park方法.
				但最终都调用了Unsafe.park()方法。
				3. 所以LockSupport成为构建同步组件的基础工具。
			LockSupport提供的阻塞和唤醒方法：
				pdf261

				挂起与恢复:
				挂起：
					调用park后，将一个线程进行挂起，线程将一直阻塞直到超时或者中断等条件出现。
				恢复：
					unpark可以终止一个挂起的线程，使其恢复正常。
						
			源码分析：
				java基础编程\多线程\线程相关内容\线程通信\共享资源\Java显示锁\condition等待原理.txt









废弃：
	显示的Lock对象在加锁和释放锁方面，相对于内建的synchronized锁，还赋予你给更细粒度的控制力。
		例：
			在使用synchronized关键字时，某些事物失败了，那么就会抛出一个异常。如果你不处理那么你没有机会去做任何清理工作，以维护系统使其处于良好状态。?
			而显式的Lock对象，你就可以使用finally进行最后的清理。
			synchronized void m() {
				有个IO资源，如果后面发生异常，那么就将无法得到释放。
				int i = 1/0; //此处抛出异常，锁将被释放。要想不被释放，可以在这里进行catch
			}
			void m() {
				Lock lock=new ReentrantLock();
				lock.lock();//使用了lock和unlock创建了临界资源
				try {
					...
				} finally {
					lock.unlock();//释放锁
					io.close();//释放IO资源
				}
			}