http://ifeve.com/java-nio-all/
https://www.jianshu.com/p/362b365e1bcc
https://www.jianshu.com/p/052035037297
NIO:
	前言（诞生起因）：
		java 传统的I/O系统具有以下特点.
		1.一连接对一个线程:
			如网络io，一个请求对应一个线程。
			一旦有高并发的大量请求,线程不够用, 就算使用了线程池复用线程也无济于事; 
		2.IO流具有阻塞特性：
			进行io操作的时候，如果发生了阻塞情况，那么当前io线程会被挂起等待。
				阻塞情况：
					1.网络I/O堵塞或有网络抖动或网络故障等。
					2.一个线程调用read或 write方法时，该线程将被阻塞，直到有一些数据被读取，或数据完全写入，该线程在此期间不能再干任何事情了。
	
	NIO介绍：
		java.nio全称java non-blocking IO，JDK 1.4及以上版本里提供的新api（New IO） 。
		IO和NIO的区别：
				原有的 IO 是面向流的、阻塞的，NIO 则是面向块的、非阻塞的。

			如何理解NIO是面向块的、非阻塞的：
				面向块的：
					NIO是天生就面向缓冲区的。
					数据将被读取到一个它稍后处理的缓冲区。
						是读一个块的数据（一定量数据为一个块）到缓存区吧！
					甚至可在缓冲区中前后移动，增加了处理过程中的灵活性。
				非阻塞的：
					JavaNIO是非阻塞模式的。
					非阻塞读：
						一个线程请求从某通道读取数据时，它仅能得到目前可用的数据，如果目前没有数据可用时，就什么都不会获取到，不会保持线程阻塞，所以直至数据变的可以读取之前，该线程可以继续做其他的事情。
							非阻塞读，会一直等到当前能读的数据读完吗？
							IO读不到数据会阻塞？那什么情况是读不到了？
					非阻塞写：
						一个线程请求写入一些数据到某通道，可不需要等待它完全写入，线程可以去做别的事情。
							非阻塞写意思是，开启了写后，我可以去干别的事吗？
					
					附：
						即NIO是可以做到用一个线程来处理多个操作的。
						假设有10000个请求过来,根据实际情况，可以分配50或者100个线程来处理。
						不像之前的阻塞IO那样，非得分配10000个。		

		附：
			？为所有的原始类型（boolean类型除外）提供缓存支持的数据容器，使用它可以提供非阻塞式的高伸缩性网络。
			？HTTP2.0使用了多路复用的技术，做到同一个连接并发处理多个请求，而且并发请求的数量比HTTP1.1大了好几个数量级。
NIO核心API：
	介绍：
		在NIO中，数据从通道被读取到缓冲区中或者从缓冲区写入到通道中。
		Java NIO API主要由以下几个核心部分组成：Channel, Buffer, Selector。
		NIO中，基本上所有IO都从一个Channel 开始。Channel 有点象流，数据可以从Channel读到Buffer中，也可以从Buffer 写到Channel中。
	Channel（通道）：
		介绍：
			通道表示到实体（如硬件设备、文件、网络套接字或程序组件）的开放连接，通道能够执行多个不同的I/O操作，如读取或写入。
			NIO的通道类似流，但又有些不同：
				3、通道的数据总是要先读到一个Buffer中，或从Buffer中写入。而流中的数据可以选择性的先读到缓存中。
				1、通道是双向的，流是单向的。
					既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。
				2、通道可以异步读写，流读写是阻塞的。
					...！
			Channel的实现类有：
				FileChannel
					一个用来写、读、映射和操作文件的通道。
				DatagramChannel
					能通过UDP读写网络中的数据。
				SocketChannel
					能通过TCP读写网络中的数据。
				ServerSocketChannel
					可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。			
		例：
			RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
			FileChannel inChannel = aFile.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(48);
			int bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {
				System.out.println("Read " + bytesRead);
				buf.flip();//注意 buf.flip() 的调用，首先读取数据到Buffer，然后反转Buffer,接着再从Buffer中读取数据。
				while(buf.hasRemaining()){
					System.out.print((char) buf.get());
				}
				buf.clear();
				bytesRead = inChannel.read(buf);
			}
			aFile.close();
		附：
			通道之间的数据传输：
				http://ifeve.com/java-nio-channel-to-channel/
	Buffer缓存区：
		介绍：
			缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。
				
			Java NIO中的Buffer用于和NIO通道进行交互。
				数据是从通道读入缓冲区，从缓冲区写入到通道中的。
			附：
				Buffer对象构成：
					一个缓存区对象，内部使用**数组存储数据，并维护几个特殊变量，实现数据的反复利用。
						具体什么数组由具体实现类决定，如ByteBuffer 则用 byte[]
					Buffer标志（特殊变量）:
						Capacity：缓存区大小
							缓存数组大小
						Position：当前读/写的位置 ​
							初始值为0
							position表示当前可以写入或读取数据的位置，当写入或读取一个数据后，position向前移动到下一个位置；
						limit：信息末尾的位置
							在写模式下，缓冲区的limit表示你最多能往Buffer里写多少数据； 
							读模式下，意味着你还能从缓冲区获取多少数据。
						mark：初始值为-1，用于备份当前的position;			
				Buffer常用方法：
					mark()：把当前的position赋值给mark
					reset()：把mark值还原给position
					clear()：
						clear会恢复标志至状态值。（清空整个缓冲区）
						注：
							此方法实际上不会擦除缓冲区中的数据。
					compact()：
						compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
					flip()：	
						https://www.cnblogs.com/woshijpf/articles/3723364.html
						通过flip()方法将Buffer从写模式切换到读模式。
						将position值重置为0，limit的值设置为之前position的值；
						此时就可以读取之前写入到buffer的所有数据
					rewind()：
						重置position为0，从头读写数据。
				Buffer的主要实现类：
					ByteBuffer ,CharBuffer ,DoubleBuffer ,FloatBuffer ,IntBuffer ,LongBuffer ,ShortBuffer
					这些Buffer覆盖了你能通过IO发送的基本数据类型：byte, short, int, long, float, double 和 char。
		Buffer的基本用法
			使用Buffer读取和写入数据通常遵循以下方式：
			缓存区申请（Buffer的分配）：
				要想获得一个Buffer对象首先要进行分配。 每一个Buffer类都有一个allocate方法。
				例：
					1.这是分配一个可存储1024个字符的CharBuffer：
					CharBuffer buf = CharBuffer.allocate(1024);

			1. 写数据到缓冲区；
				附：
				1.当向buffer写入数据时，buffer会记录下写了多少数据
				2.写缓冲区方式：
				    1. 从Channel写到Buffer
						channel.write(Buffer)；
	    			2. 通过Buffer的put方法写到Buffer中；
			2.调用flip()方法
				flip方法将Buffer从写模式切换到读模式。
				重置buffer标志。将position值重置为0，limit的值设置为之前position的值；此时就可以读取之前写入到buffer的所有数据。
			3. 从缓冲区中读取数据；
				附：
				读缓冲区数据方式：
				    1. 从Buffer中读取数据到Channel；
						channel.read(buffer);
				    2. 通过Buffer的get方法从Buffer中读取数据；
				？读一半，在写，在想读了
			4. 调用clear()等方法
				从缓存区读完数据后，通常要调用buffer.clear()等方法，清空缓冲区，让其便于再次被写入。

		
	Selector选择器:
		http://ifeve.com/selectors/
		介绍：
			通过Selector能够管理多个 Channel。
			Selector组件能够检测（知晓）一到多个通道是否为诸如读写事件做好准备的组件。
			Selector允许单线程处理多个 Channel。
		使用Selector管理Channel:
			要使用Selector，得向Selector注册Channel。然后调用它的select()方法，这个方法会一直阻塞到某个注册的通道有事件就绪。一旦这个方法返回，线程就可以处理这些事件，事件的例子有如新连接进来，数据接收等。

			./使用Selector管理Channel.txt
		附：
			使用Selector好处：
				仅用单个线程来处理多个Channels的好处是，只需要更少的线程来处理通道。
				对于操作系统来说，线程之间上下文切换的开销很大，而且每个线程都要占用系统的一些资源（如内存）。因此，使用的线程越少越好。

				但是，现代的操作系统和CPU在多任务方面表现的越来越好，所以多线程的开销随着时间的推移，变得越来越小了。实际上，如果一个CPU有多个内核，不使用多任务可能是在浪费CPU能力。
案例：
	Socket服务端和客户端案例：
		有问题
		https://blog.csdn.net/u010889616/article/details/80686236
		./例/ServerAndClientOfSocket/
		