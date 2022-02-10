JavaIO:
	介绍:
		1.Java使用java.io包中的api来进行数据读取和输出。
			附：
				api实现了各种数据源端和接收端之间的通信。
					附：
						端：可指文件、控制台、网络链接等，这些均可以作为源端或接收端。
				还可以使用多种不同的通信方式。如顺序、随机存取、缓冲、二进制、按字符.按行、按字等。
		2.JavaIO(api)中使用了流这个抽象概念。
			什么是流：
				javaIO类库使用了抽象概念：流。
				它用来代表任何能出数据的数据源对象或能接收数据的接收端对象。
			附：
				为什么要用抽象概念流：
					底层IO操作是很复杂的，涉及到大量硬件环节和网络传输等。
						比如磁盘存储，涉及到磁道、扇面等非常底层的信息， 
						比如网络通讯，则涉及到TCP/IP非常复杂的内容。
					具体的传输过程实现由java(或第三方)实现。
						为了掩盖这些复杂的底层信息，让程序员能够从事更加高层的业务编程，JAVA语言用了I/O流来掩盖了底层实现细节。并且java已经编制了大量底层类(具体流实现类)。
					程序员仅需使用流就可以实现任意io操作。
				即:"流"屏蔽了与实际的I/O设备通信处理数据的细节。(流的作用)
			
	流的分类：
		https://zhidao.baidu.com/question/541341140.html?sort=11&rn=5&pn=0#wgt-answers
		介绍：
			1. 流可以根据数据流向不同划分为：输入流和输出流。
		　　2. 流还可以根据处理数据类型的不同划分为：字符流和字节流。
				注：
					字节流可以传送传送任何数据。
					字符流则常用来操作文本数据。
						用字节流传送文字信息，会有可读性差等缺点。
			对javaIO的api作用进行分类，利于使用和理解api。
			附：
				1.任何自Inputstream或Reader派生而来的类都含有名为read()的基本方法,用于读取单个字节或者字节数组。
				2.任何自OutputStream或Writer派生而来的类都含有名为write()的基本方法,用于写单个字节或者字节数组。
				但我们通常不会用到这些方法，它们之所以存在是因为别的类(装饰器类)可以使用它们，以便提供更有用的接口。此处就涉及到了装饰器模式

		根据数据流向来划分流：
			附：
				流的方向是对当前程序来说。
			输入流：(InputStream、Reader)
				InputStream用来表示从不同数据源产生输入的类。（即数据流向了程序）
				1. 数据源包括：
					goto: 数据源
				2. InputStream子类：p534
					介绍：
						每一种数据源都有相应的InputStream子类，这些InputStream子类把对应的数据源转换成InputStream(输入流)。
					InputStream子类:
						ByteArrayInputStream
						StringBufferInputStrear
						FileInputStream
						PipedInputStream
						SequenceInputStream
						？
							其他数据源，对应的InputStream子类在那了，是由别的工具类实现了吗
						FilterInputStream:
							goto: IO装饰器
			输出流：(OutputStream、Writer)
				该类型的类决定了输出所要去往的目标。(即数据流出了程序)
				1. 目标：(就是数据源吧？与上面同样吧)
					字节数组、文件、管道
				2. OutputStream子类：p535
					ByteArrayOutputStream 
						在内存中创建缓冲区。所有送往“流"的数据都要放置在此缓冲区
						？
							讲解下与缓冲装饰器区别：
								ByteArrayOutputStream是把数据放到内存中。
								缓冲装饰器只是临时把数据存到内存中，然后一次性从内存存到磁盘中。
					FileOutputStream
						用于将信息写至文件
					PipedOutputStream？
					FilterOutputStream
						与FilterInputStream同理
					？与inputStream对比少了一些吗

			例：
				java程序用输入流从cmd读取数据，用输出流往cmd写数据。	
		根据数据类型来划分流：
			字节流:
				介绍：
					流传输的数据类型为二进制，即字节流以字节（8bit，一字节8位）为单位。
					类的命名为 xxxInputStream, xxxOutputStream一般即为字节流。
					附：					
						字节流能处理所有类型的数据：
							所有的数据传输最初都是以二进制来传输的，但有些可以转换成字符流来传输。
							例：
								1.如：图片、音乐、视频等媒体介质
								2.键盘输入的数据虽然是二进制形式，但它是ASCII码形式的二进制，具备转成字符流的条件。
								3.摄像头的输入也是二进制的但其不能转换成二进制，因为转换成字符流会乱码。
				附：
					byte[]：
						byte数组专门用来存放二进制数据的。
					Base64 ：	
						https://baike.baidu.com/item/base64/8545775?fr=aladdin
						Base64是网络上最常见的用于传输8Bit字节码的编码方式之一
						附：
							正如UTF-8和UTF-16是将文本数据编码的方式一样。
						?
							为什么二进制字节码要进行编码后传输了
					二进制流转字符串：
						二进制 转 Base64， Base64 再转 字符串
						https://www.cnblogs.com/test-7/p/10678488.html
						注：
							除非该二进制流的来源为字符（如文本）否则时无法转换成字符串的。？
			字符流:
				介绍：
					Reader和Writer类提供面向字符(默认Unicode编码)的I/O功能。
						Reader等实际上还是以二进制流传输数据，只是其读取会以16bit为一单位转换为字符(因为默认16位Unicode编码)。
						即流传输的数据类型为字符，所以称之为字符流。
						附：
							根据码表映射字符。
					
					类的命名为 xxxReader, xxxWriter一般即为字符流。					
					附：	
						1.字符流只能处理字符类型的数据。
						2.Reader和Writer的作用：
							1.国际化(输出输入的默认格式化)
								16位的Unicode字符用于字符国际化，
									Java本身的char也是16位的Unicode
								所以添加Reader和Writer继承层次结构就是为了在所有的IO操作中都支持Unicode。
							2.操作字符更方便
							3.新类库的设计使得它的操作比旧类库更快？
						3.字符字节流转换：
							“适配器”(adapter) 类: InputStreamReader可以把InputStream转换为Reader,而OutputStreamWriter可以把OutputStream转换为Writer
					附：
					字节流字符流对比：
						InputStream中说的数据源(String对象,文件等),字符流(Reader,Writer)中都有对应的接口。p538
						但装饰类(Filter)在字符流中却变了，不在通过装饰器模式来改变流的行为，而是直接提供实现类(例BufferWriter)来改变流的行为。
						(新的Java se5的PrintWriter向正确的方向迈进了一步，但是它只是一个部分的解决方案)。
					附：
						常见api介绍：
							InputStreamReader	
								每次只能转换 二进制流的16个bit为字符。即只能读取一个字符
							BufferedReader		
								用来缓存字符，InputStreamReader转换的字符先放到BufferedReader最后在输给cpu。即一次能读一行数据（回车算一行）
							PrintWriter	
								把字符流转换成二进制流
			附：
				什么时候用字节流什么时候用字符流了：
					读取字符类(如文本)就用字符流。
					其他数据源就只能用字节流(摄像头等).
					附：
						中文一个字节放不下，需要用两个字节来存储，得占16位。
							字符流一个字符一个字符的往里读，所以能便捷的读出来。
							用字节流一个字符一个字符的往里读，把一个汉字拆成一半了，处理不当操作系统不认识，显示都问号
				
				　　附：
						？字节流在操作的时候本身是不会用到缓冲区的，是文件本身的直接操作的；而字符流在操作的时候是会用到缓冲区的，是通过缓冲区来操作文件。
						？有中文数据就用字符流，没有则用字节流。

附：
	数据源：
		1.字节数组
		2.string对象
		3.文件
		4."管道"
			从一端输入从另一端输出。
			管道操作:A的结果是B操作的数据来源,B的结果是C操作的数据来源。
			？
				PipedInputStream、. PipedOutputStream、 PipedReader及 PipedWriter。
				管道流用于任务之间的通信。
				它们的价值只有在我们开始理解多线程之后才会显现。
		5.一个由其他种类的流组成的序列，一边我们把它们收集合并到一个流中。？
		6.其他数据源，如Internet连接等。

	文件的概念：
		狭义文件：
			磁盘的具体文件。
			注：目录是一种特殊的具体文件，目录其实是一个文本文件，其中包含了这个目录下所有文件的信息。
		广义文件概念：
			任何非CPU的介质和外设，我们都可以称其为文件，和其通讯。
			比如：显示器，打印机，扫描仪等。
	序列化：
		介绍：
			对象流就是将对象的内容进行流化。
			流化作用：
				流化后的对象可以进行读写操作，
				也可将流化后的对象传输于网络之间。
				序列化除了能够实现对象的持久化之外，
				还能够用于对象的深度克隆
				...
		例：
			要实现序列化，需要让一个类实现Serializable接口，该接口是一个标识性接口，标注该类对象是可被序列化的。
			然后使用一个输出流来构造一个对象输出流并通过writeObject(Object)方法就可以将实现对象写出（即保存其状态）；
			如果需要反序列化则可以用一个输入流建立对象输入流，然后通过readObject方法从流中读取对象。
IO装饰器:(FilterInputStream子类)
	介绍： 
		FilterInputStream也属于一种InputStream,其作用与其他InputStream子类略有不同，其为“装饰器”类提供基类。
			即FilterInputStream派生自InputStream，为被修饰的对象提供通用接口(是装饰器的必要条件)。
		附：
			为什么这里要有个FilterInputStream作为装饰器基类了
				
				1. 装饰器类都要继承FilterInputStream，以便表明这是个装饰器类。
				2. FilterInputStream实现了抽象类InputStream的方法，减少了些子类的工作。
				附：
					装饰器必须具有和它所装饰的对象相同的接口
						即和InputStream具有同样的接口，这样子别人才可以正常把它当作InputStream使用
					但它也可以扩展接口
			FilterOutputStream与FilterInputStream同理
	FiterInputStream子类：
		DataInputStream:
			1. 从流中读取数据，并格式化成指定的基本类型数据(int, char, long等)(或String对象)。
			2.DataInputStream通常与DataOutputStream搭配使用。
			附：
				DataOutputStream同理，只是它是写出到流中
				DataOutputStream：
					它可以将各种基本数据类型以及String对象格式化输出到“流”中。
					这样以来，任何机器上的任何DataInputStream都能够(以对应的格式)读取它们。
		其他ilterInputstream类则在内部修改InputStream的行为方式。
			例:是否缓冲(BufferedInputStream)，是否保留它所读过的行等
			
		BufferedInputStream
			1.使用缓冲区。使用它可以防止每次读取时都得进行实际写操作。
			2.它对数据流使用缓冲技术，每次向流读取时，不必每次都进行实际的物理写动作。
	附：
		？
		装饰器类的实现
			比如BufferedInputStream是如何为各种数据源实现缓存的？								
		？
			DataInputStream功能是不是与InputStream(数据源)子类功能重叠了，其实现了它们的一些功能，就是把其他数据源转换为InputStream。
