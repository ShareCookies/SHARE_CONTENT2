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
		Lock接口的实现类基本都是通过聚合了一个同步器的子类来完成线程访问控制的。
		队列同步器:
			队列同步器.txt
			队列同步器原理.txt
		ReentrantLock源码分析.java
		ReentrantReadWriteLock读写锁源码分析.txt
		
		
附：
	LockSupport工具？
	Condition接口














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