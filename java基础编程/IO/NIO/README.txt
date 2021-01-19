http://ifeve.com/java-nio-all/
https://www.jianshu.com/p/362b365e1bcc
https://www.jianshu.com/p/052035037297
https://github.com/CyC2018/CS-Notes/blob/master/notes/Java%20IO.md
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

			附：
			如何理解NIO是面向块的、非阻塞的：
				流与块
					面向流的 IO 一次处理一个字节数据：一个输入流产生一个字节数据，一个输出流消费一个字节数据。
					面向块的 NIO 一次处理一个数据块，按块处理数据比按流处理数据要快得多。
						例：
							/* 为缓冲区分配 1024 个字节 */
							ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
							一个数据块就是一个缓存区大小吧。
							附：
								
								private static int readIntoNativeBuffer(FileDescriptor var0, ByteBuffer var1, long var2, NativeDispatcher var4) throws IOException {
									int var5 = var1.position();
									int var6 = var1.limit();
									...
									var9 = var4.read(var0, ((DirectBuffer)var1).address() + (long)var5, var7);//read就是native了
									...
								}
								

				非阻塞的：
					NIO通过Selector是可以做到用一个线程来处理多个操作的。
					假设有10000个请求过来,根据实际情况，可以分配50或者100个线程来处理。
					不像之前的阻塞IO那样，非得分配10000个。
		
		附：
			I/O 包和 NIO 已经很好地集成了，即java.io.* 已经以 NIO 为基础重新实现了，所以现在它可以利用 NIO 的一些特性。例如，java.io.* 包中的一些类包含以块的形式读写数据的方法，这使得即使在面向流的系统中，处理速度也会更快。！	
		附：
			流、通道区别：
				流：
					流是一种抽象概念，把对io设备的操作抽象为流（操作的具体实现细节用户无需管因为别人已经帮你写好了），用户可以仅通过流就操作io设备.
				通道：
					我觉的通道也是种抽象概念，通道表示到实体IO的开放连接,通过Channel.read(Buffer)可以把实体数据读到缓存区中，通过Channel.write(Buffer)可以把缓存区数据读到实体IO中.
				总结:
					流与通道相比就是缺失了缓存区这个必要概念，通道一定要读到缓存区中，而流可以直接读到引用对象中。
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
			NIO 常常被叫做非阻塞 IO，主要是因为 NIO 在网络通信中的非阻塞特性被广泛使用。
			NIO 实现了 IO 多路复用中的 Reactor 模型，一个线程 Thread 使用一个选择器 Selector 通过轮询的方式去监听多个通道 Channel 上的事件，从而让一个线程就可以处理多个事件。

			通过配置监听的通道 Channel 为非阻塞，那么当 Channel 上的 IO 事件还未到达时，就不会进入阻塞状态一直等待，而是继续轮询其它 Channel，找到 IO 事件已经到达的 Channel 执行。
			总结：
				通过Selector能够管理多个 Channel。
		使用Selector管理Channel:
			./使用Selector管理Channel.txt
			注：
				只有套接字 Channel 才能配置为非阻塞，而 FileChannel 不能，因为 FileChannel 配置非阻塞也没有意义。	
		附：
			使用Selector好处：
				因为创建和切换线程的开销很大，因此使用一个线程来处理多个事件而不是一个线程处理一个事件，对于 IO 密集型的应用具有很好地性能。
				
例：
	磁盘操作：
		./例/file.java
	网络操作
		Socket服务端和客户端案例：
		./例/ServerAndClientOfSocket/
		