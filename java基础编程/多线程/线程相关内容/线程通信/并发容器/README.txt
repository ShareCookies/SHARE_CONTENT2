并发队列：(同步队列)
	介绍：
		1. 队列就是遵从先进先出规则的一种数据结构。
		
		2. 并发队列是线程安全的队列：
			并发队列在任何时刻都只允许一个任务插入或移除元素。
		3. JDK提供了两套并发队列实现，
		一个是以ConcurrentLinkedQueue为代表的高性能非阻塞队列，
			实现方式是使用非阻塞算法。
			使用循环CAS的方式来实现。
		一个是以BlockingQueue接口为代表的阻塞队列。
			实现方式是使用阻塞算法。
			使用一个锁（入队和出队用同一把锁）或两个锁（入队和出队用不同的锁）等方式来实现。

	非阻塞式队列：
		ConcurrentLinkedQueue:
			./ConcurrentLinkedQueue.txt
	阻塞式队列：
		./阻塞队列.txt
其余并发容器:(同步容器)
	ConcurrentHashMap.txt