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
		附：?
			JDK 1.4的java.nio.*包中引入了新的JavaI/O类库，其目的在于提高速度。
			实际上,旧的IO包已经使用nio重新实现过，以便充分利用这种速度提高，因此，即使我们不显式地用nio编写代码也能从中受益。
				即java.io.* 已经以 NIO 为基础重新实现了，所以现在它可以利用 NIO 的一些特性。例如，java.io.* 包中的一些类包含以块的形式读写数据的方法，这使得即使在面向流的系统中，处理速度也会更快。！
			速度的提高来自于所使用的结构更接近于操作系统执行I/O的方式:通道和缓冲器。？
	NIO介绍：
		介绍：
            java.nio全称java non-blocking IO，JDK 1.4及以上版本里提供的新api（New IO） 。
            1. Java NIO API主要由以下几个核心部分组成：Channel, Buffer, Selector。
            2. NIO中通常数据从通道被读取到缓冲区中，或者从缓冲区写入到通道中。

		附：
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
		
NIO核心API：
	介绍：
		1. Java NIO API主要由以下几个核心部分组成：Channel, Buffer, Selector。
		2. NIO中通常数据从通道被读取到缓冲区中，或者从缓冲区写入到通道中。

		附：
			nio数据流向：
				通道到缓存：
				通道到通道：
					特殊方法transferTo()和transferFrom()则允许我们将一个通道和另一个通道直接相连
				缓存区到缓存区：
					...
Channel（通道）：
	介绍：
		通道表示到实体（如文件、网络套接字、程序组件、硬件设备）的开放连接。
		通道能够执行多种不同的I/O操作，如读取或写入。
		附：流、通道区别：
			流介绍：
				流是一种抽象概念，把对io设备的操作抽象为流（操作的具体实现细节用户无需管因为别人已经帮你写好了），用户可以仅通过流就操作io设备.
			通道介绍：
				我觉的通道也是种抽象概念，通道表示到实体IO的开放连接,通过Channel.read(Buffer)可以把实体数据读到缓存区中，通过Channel.write(Buffer)可以把缓存区数据读到实体IO中.
			区别：
				1、
				通道的数据总是要先读到一个Buffer中，或从Buffer中写出。
				而流中的数据可以选择性的先读到缓存中。
				2、通道是双向的，流是单向的。
					既可以从通道中读取数据，又可以写数据到通道。
					但流的读写是单向的。
				3、通道可以异步读写，流读写是阻塞的。
					？
		Channel的子类有：
			FileChannel
				一个用来写、读、映射和操作文件的通道。
				附：
				FileChannel生成：
					JavaIO工具.txt#FileChannel的获取
			DatagramChannel
				能通过UDP读写网络中的数据。
			SocketChannel
				能通过TCP读写网络中的数据。
			ServerSocketChannel
				可以监听新进来的TCP连接，像Web服务器那样。
				对每一个新进来的连接都会创建一个SocketChannel。

	附：
		通道之间的数据传输：
			http://ifeve.com/java-nio-channel-to-channel/

Buffer缓存区：
	介绍：
		1. NIO中的Buffer通常和通道进行交互，用于存储从通道获取的数据或往通道传输数据。
			数据是从通道读入缓冲区，从缓冲区写入到通道中的。
		2. 缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。
		这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。
			
			
	附：
		Buffer对象构成：
			一个缓存区对象，内部使用数组存储数据，并维护几个特殊变量，实现数据的反复利用。
				附：具体什么数组由具体实现类决定，如ByteBuffer 则用 byte[]
			Buffer标志（特殊变量）:
				Capacity：缓存区大小
					缓存数组大小
				position：
					当前的下标位置，表示进行下一个读写操作时的起始位置；
				
				limit：信息末尾的位置
					结束标记下标，表示进行下一个读写操作时的（最大）结束位置；
					当flip切换后limit是会随之变动的
				mark：
					自定义的标记位置；
					？可用于用于备份当前的position;
				附：
					实战解释p562
		Buffer常用方法：
			reset()：把mark值还原给position
			clear()：
				清空缓冲区。
				本质：
					将position设置为0, limi设置为容量。
				附：
					此方法实际上不会擦除缓冲区中的数据。
			compact()：
				compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
			flip()：
				本质：
					将position值重置为0，limit的值设置为之前position的值；
				附：
					此方法用于准备从缓冲区读取已经写入的数据
					
			rewind()：
				重置position为0，返回到数据开始部分。(常用于从新开始？)
			capacity():
				返回缓冲区容量

			mark()：
				把当前的position赋值给mark
			remaining():
				返回(imit - position)
			hasRemaining():
				若有介于position和limit之间的元素，则返回true
				
				
		Buffer的主要实现类：
			介绍：
				ByteBuffer ,CharBuffer ,DoubleBuffer ,FloatBuffer ,IntBuffer ,LongBuffer ,ShortBuffer
				这些Buffer覆盖了你能通过IO发送的基本数据类型：byte, short, int, long, float, double 和 char。
			ByteBuffer
				唯一直接与通道交互的缓冲器是ByteBuffer(存储未加工字节的缓冲器)。
				尽管ByteBuffer只能保存字节类型的数据，但是它具有可以从其所容纳的字节中产生出各种不同基本类型值的方法。
				例：
					bb.asCharBuffer().put("Howdy!"):
			视图缓冲器：(view buffer)
				CharBuffer ,DoubleBuffer ,FloatBuffer ,IntBuffer ,LongBuffer ,ShortBuffer
				介绍：ByteBuffer与视图缓冲器关系
					
					1.实际存储数据的地方依然是ByteBuffer，既ByteBuffer“支持”着前面的视图，因此对视图的任何修改都会映射成为对ByteBuffer中数据的修改。
					2.ByteBuffer是将数据移进移出通道的唯一方式，然而我们可以经由视图缓冲器(使用“as”方法从ByteBuffer中获得的基本类型缓冲器)将基本类型数据移进移出ByteBuffer。
					附：
						1.
						虽然可以创建一个独立的基本类型缓冲器，但我们是无法把基本类型的缓冲器转换成ByteBuffer的。
						所以我们总是以操纵ByteBuffer为目标，因为它可以和通道进行交互。
						2. ./ByteBuffer与视图缓冲器对照图.png
				例：
					通过IntBuffer操纵ByteBuffer中的int型数据:
					public class IntBufferDemo {
						private static final int BSIZE = 1024;
						public static void main(String[] args) {
							ByteBuffer bb = ByteBuffer.allocate(BSIZE);
							IntBuffer ib = bb.asIntBuffer();
							ib.put(new int[]{ 11,2 ,33});
							System.out.println(ib.get(1));
							ib.put(1,1811);
							ib.flip();
							while(ib.hasRemaining()) {
								int i = ib.get();
								System.out.println(i);
							}
						}
					}
					先用重载后的put()方法存储一个整数数组。接着get(和put0方法调用直接访问底层ByteBuffer中的某个整数位置。注意，这些通过直接与ByteBuffer对话访问绝对位置的方式也同样适用于基本类型。
			

		字节存放次序p559?
			不同的机器可能会使用不同的字节排序方法来存储数据。“big endian" (高位优先)将最重要的字节存放在地址最低的存储器单元。而"itte endian”(低位优先)则是将最重要的字节放在地址最高的存储器单元。
			当存储量大于一个字节时，像int、 float等， 就要考虑字节的顺序问题了。
			ByteBuffer是以高位优先的形式存储数据的，并且数据在网上传送时也常常使用高位优先的形式。
			我们可以使用带有参数ByteOrder.BIG ENDIAN或ByteOrder.LITTLE_ ENDIAN的order0方法改变ByteBuffer的字节排序方式。
			?
				io中就不用管字节存放次序的概念吗

	Buffer的基本用法：(NIO的基本用法)
		使用Buffer读取和写入数据通常遵循以下步骤：
		1. 缓存区申请（Buffer的分配）：
			要想获得一个Buffer对象首先要进行分配。
			1、 allocate方法：
				例：
					1.这是分配一个可存储1024个字符的CharBuffer：
					CharBuffer buf = CharBuffer.allocate(1024);
			2、 allocateDirect():
				...
				allocateDirect会产生一个与操作系统有更高耦合性的“直接"缓冲器？。
				但是,这种分配的开支会更大，并且具体实现也随操作系统的不同而不同，因此必须再次实际运行应用程序来查看直接缓冲是否可以使我们获得速度上的优势。
			3、 wrap():
				使用warp方法将已存在的字节数组“包装”到ByteBuffer中。
				一旦如此，就不再复制底层的数组?，而是把它作为所产生的ByteBuffer的存储器，我们称之为数组支持的ByteBuffer。

				?将字节存放于ByteBuffer的方法之-是:使用- -种“put" 方法直接对它们进行填充，填人
				-一个或多个字节，或基本数据类型的值。
			附：
				nio的目标是快速移动大量数据，因此ByteBuffer的大小就显得尤为重要

		2. 读数据到缓冲区；
			数据从Channel读取到Buffer
				例：channel.read(Buffer)；
			注：当向buffer写入数据时，buffer会记录下写了多少数据
			附：数据也可以通过Buffer的put方法写到Buffer中；
		3. 调用flip()方法：(Buffer模式切换)
			模式翻转。
				例：
					读数据到缓冲区后。
					调用flip()将使Buffer从写模式切换到读模式。
			flip()本质：
				重置buffer标志。
				limit的值设置为之前position的值；
				将position值重置为0。
				此时就可以读取之前写入到buffer的所有数据。
		4. 从缓冲区中写出数据到通道：
			数据从Buffer中读取数据到Channel；
				例：channel.write(buffer);
			附：数据也可以通过Buffer的get方法从Buffer中读取数据；
			？读一半，在写，在想读了
		5. 调用clear()等方法：(Buffer清空，便于读取数据到缓冲区)
			从缓冲区中写出数据到通道后，通常要调用buffer.clear()等方法，清空缓冲区，让其便于再次读取数据到缓冲区。
			clear()本质：
				...
		例：
			p553
		附：
			缓冲器容纳的是普通的字节，为了把它们转换成字符，我们要么在输入它们的时候对其进行编码(这样，它们输出时才具有意义)，要么在将其从缓冲器输出时对它们进行解码。
			可以使用java.nio.charset.Charset类实现这些功能，该类提供了把数据编码成多种不同类型的字符集的工具。


Selector选择器:
	http://ifeve.com/selectors/
	介绍：
		1. NIO 常常被叫做非阻塞 IO，主要是因为网络通信中的非阻塞特性在NIO中被广泛使用。
		2. NIO 实现了 IO 多路复用中的 Reactor 模型。
		所以一个线程 Thread 可以使用一个选择器 Selector 通过轮询的方式去监听多个通道 Channel 上的事件，从而让一个线程就可以处理多个事件。
			即：通过Selector找到 IO 事件已经到达的 Channel 执行。
		
	使用Selector管理Channel:
		通过Selector能够管理多个 Channel，应用非阻塞特性实现非阻塞IO。
		详：
			./使用Selector管理Channel.txt
		注：AbstractSelectableChannel：
			与Selector一起使用时，Channel必须处于非阻塞模式下。
			只有套接字 Channel 才能配置为非阻塞，而 FileChannel 不能。
			而且 FileChannel 配置非阻塞也没有意义。	
	附：
		使用Selector好处：
			因为创建和切换线程的开销很大，因此使用一个线程来处理多个事件而不是一个线程处理一个事件，对于 IO 密集型的应用具有很好地性能。
	
例：
	磁盘操作：
		./例/file.java
	网络操作
		Socket服务端和客户端案例：
		./例/ServerAndClientOfSocket/
		
		
		




附：
	？为所有的原始类型（boolean类型除外）提供缓存支持的数据容器，使用它可以提供非阻塞式的高伸缩性网络。
	？HTTP2.0使用了多路复用的技术，做到同一个连接并发处理多个请求，而且并发请求的数量比HTTP1.1大了好几个数量级。
通过内存来映射文件：
	通过内存来映射文件允许我们创建和修改那些因为太大而不能放入内存的文件。
	有了内存映射文件，我们就可以假定整个文件都放在内存中，而且可以完全把它当作非常大的数组来访问。这种方法极大地简化了用于修改文件的代码。
	例：
	public class MappedFile {
		static int length = 0x8FFFFFF; // 128 MB
		public static void main(String[] args) throws Exception{
			//为了既能写又能读，我们先由RandomAccessFile开始，获得该文件上的通道，然后调用map0产生MappedByteBuffer, 这是一种特殊类型的直接缓冲器。
				//MappedByteBuffer由ByteBuffer继承而来，因此它具有ByteBuffer的所有方法。如asCharBuffer0等这样的用法。
			// 注意我们必须指定映射文件的初始位置和映射区域的长度，这意味着我们可以映射某个大文件的较小的部分。
			//似乎我们可以一次访问到整个文件，因为只有一部分文件放入了内存，文件的其他部分被交换了出去？。用这种方式，很大的文件(可达2GB)也可以很容易地修改。（是每次都载入一部分吗？）
			MappedByteBuffer out =
			new RandomAccessFile("test.txt","rw").getChannel().
					map(FileChannel.MapMode.READ_WRITE,0,length);
			for(int i=0; i < length; i++)
						out.put((byte)'x');
				print("Finished Writing");
			for(int i = length/2; i < length/2 + 6; i++)
				printnb((char)out.get(1));
		}
	}
	性能：
		尽管“旧”的I/O流在用nio实现后性能有所提高，但是“映射文件访问”往往可以更加显著地加快速度。
		下面的程序进行了简单的性能比较。p564
文件加锁
	JDK 1.4引入了文件加锁机制，它允许我们同步访问某个作为共享资源的文件。
	文件锁对其他的操作系统进程是可见的，因为Java的文件加锁直接映射到了本地操作系统的加锁工具。
		因此竞争同一文件的两个线程可以在不同的Java虚拟机上:或者一个是Java线程，另一个是操作系统中其他的某个本地线程。
	例：
		getChannel().tryLock();
		release()
		对映射文件部分加锁：
			...