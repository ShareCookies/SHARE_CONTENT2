https://blog.csdn.net/weixin_44198965/article/details/90083126
附：
	协议是定规范还是实现了功能。？
		实现了功能。(即协议就是代码程序！)
		那为什么叫协议了。
			因为这个功能也是个规范，让大家调用时统一他的规则去调用。
		协议是通过代码实现了功能吧，然后通过api接口(规定好的)给其余部分调用的吧！
	./上网的流程.txt
通信协议分层:
	https://baike.baidu.com/item/%E5%88%86%E5%B1%82%E7%BD%91%E7%BB%9C%E5%8D%8F%E8%AE%AE/11066173?fr=aladdin
	分层网络协议（OSI模型） 是由国际标准化组织ISO创立的一个网络通讯模型。
	这是一个理论模型，并无实际产品完全符合OSI模型。
	制订OSI模型只是为了分析网络通讯方便而引进的一套理论。也为以后制订实用协议或产品打下基础。
	
	OSI7层分层模型:
		传统的开放式系统互连参考模型，是一种通信协议的7层抽象的参考模型,其中每一层执行某一特定任务。该模型的目的是使各种硬件在相同的层次上相互通信。
		7层:
			物理层、数据链路层、网路层、传输层、话路层、表示层和应用层。
	TCP/IP分层模型：
		https://zhidao.baidu.com/question/46882701.html
		TCP/IP通讯协议并不完全符合OSI的七层参考模型。
		而是采用了4层的层级结构，每一层都呼叫它的下一层所提供的网络来完成自己的需求。
		4层:
			应用层(各种应用层协议如HTTP, FTP,SMTP等)、传输层(TCP或UDP)、网络层、网络接口层
	
应用层:(http,ftp...)
	该层向用户提供应用程序
		比如电子邮件、文件传输访问、远程登录等。
		文件传输访问FTP使用FTP协议来提供网络内机器间的文件拷贝功能。
	例：
		写了个web应用，占用80端口，那这就是应用层吧！
		web应用，使用的是http协议，http是应用层协议，那这个功能是java语言等对应语言各自实现的吧！还是web容器实现了？
	附：
		端口：
			...
			端口与tcp和应用层协议之间关系？
	Http协议：
		./html请求.txt
Socket编程：
	https://blog.csdn.net/pashanhu6402/article/details/96428887
	抽象层，它是一组接口。
       Socket是应用层与TCP/IP协议族通信(传输层、网络层)的中间软件抽象层，它是一组调用接口（API），通过Socket，我们可以便捷使用TCP/IP协议。
	   附：
		在设计模式中，Socket其实就是一个门面模式，它把复杂的TCP/IP协议族隐藏在Socket接口后面，对用户来说，一组简单的接口就是全部，让Socket去组织数据，以符合指定的协议。
	socket的使用：
		...	
	
	附：
		这一层是由对应语言实现的吧！抽象出来的一层，便于用户传输数据吧。
		
		socket起源于UNIX BSD的套接字（socket）
			Unix/Linux基本哲学之一就是“一切皆文件”，即所有东西都可以用“打开open –> 读写write/read –> 关闭close”模式来操作,socket也符合这种思想。

		
		https://blog.csdn.net/yttyffggh/article/details/83747350?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_baidulandingword-2&spm=1001.2101.3001.4242
传输层:(tcp,udp)
	用于应用程序之间的通信：
		在此层中，它提供了节点间的数据传送服务。即这一层负责传送数据，并且确定数据已被送达并接收。
		如传输控制协议（TCP）、用户数据报协议（UDP）等，TCP和UDP给数据包加入传输数据并把它传输到下一层中

		其功能包括：
			一、格式化信息流；
			二、提供可靠传输。
				为实现后者，传输层协议规定接收端必须发回确认，并且假如分组丢失，必须重新发送。
				每一次信息传输都要三次握手吗？
		？
			应用程序之间的通信？节点间的数据传送服务？
			
	TCP协议|UDP协议：
		./tcp协议

	附：
		传输层到驱动都是操作系统实现的。
		即tcp是操作系统实现的
			还是jdk了
			应该是操作系统 https://www.cnblogs.com/mosp/p/3891783.html

网络层 ：（IP）
	总之：
		暂时理解为填入地址等报头，制作ip数据包。
	负责相邻计算机之间的通信。
		即负责提供基本的数据封包传送功能，让每一块数据包都能够到达目的主机（但不检查是否被正确接收），如网际协议（IP）。
		其功能包括三方面：
			一、处理输出数据报：处理来自传输层的分组发送请求，收到请求后，将分组装入IP数据报，填充报头，选择去往信宿机的路径？，然后将数据报发往适当的网络接口？。

			二、处理输入数据报：首先检查其合法性，然后进行寻径–假如该数据报已到达信宿机，则去掉报头，将剩下部分交给适当的传输协议；假如该数据报尚未到达信宿，则转发该数据报。

			三、处理路径、流控、拥塞等问题。？
	IP协议：
		IP 是无连接的通信协议。 
		用于计算机之间的通信,它不会占用两个正在通信的计算机之间的通信线路。
			这样，IP 就降低了对网络线路的需求,每条线可以同时满足许多不同的计算机之间的通信需要。
		功能：
			通过IP协议，消息（或者其他数据）被分割为小的独立的包，并通过因特网在计算机之间传送。
				？tcp割，ip又割
			IP 负责将每个包路由至它的目的地。

		附：
			IP地址
				每个计算机必须有一个 IP 地址才能够连入因特网。
				每个 IP 包必须有一个地址才能够发送到另一台计算机。
				IP地址组成：
					...	
			IP 路由器
				当一个 IP 包从一台计算机被发送，它会先到达一个 IP 路由器。
				IP 路由器负责将这个包路由至它的目的地，这个过程会通过其他的路由器一直到目的地。
					附
						路由器负责根据通信量、网络中的错误或者其他参数来进行正确地寻址。
						在一个相同的通信中，一个包所经由的路径可能会和其他的包不同。
				？路由器设备是仅有网络层和网络接口层组成吗
			域名
				ip地址难记，所以用域名来表示ip地址，一个ip对应一个域名。
				域名会被一种 DNS 程序翻译为数字，本地dns程序翻译不了就会去指定的dns服务器翻译，还不行就会异常。
				DNS 服务器负责将域名翻译为 TCP/IP 地址，同时负责使用新的域名信息更新彼此的系统。
					当一个新的域名连同其 TCP/IP 地址一同注册后，全世界的 DNS 服务器都会对此信息进行更新。		

附：
	TCP/IP
		传输控制协议/网间协议（Transmission Control Protocol/Internet Protocol）。
		TCP/IP协议组是一个工业标准的协议集，它是为广域网（WANs）设计的？。
		
		TCP/IP协议组:
			确切地说，TCP/IP协议是一组包括TCP协议和IP协议，UDP（User Datagram Protocol）协议、ICMP（Internet Control Message Protocol）协议和其他一些协议的协议组。
		附：
			TCP/IP协议组之所以流行，部分原因是因为它可以用在各种各样的信道和底层协议（例如T1和X.25、以太网以及RS-232串行接口）之上。？
		
网络接口层：
	这是TCP/IP软件的最低层，负责对实际的网络媒体的管理，定义如何使用实际网络（如Ethernet、Serial Line等）来传送数据。
		即负责接收IP数据包并通过网络发送之，或者从网络上接收物理帧，抽出IP数据包，交给IP层。
	附：
		驱动都是操作系统实现的。
		其余IP层之下这些部分通常由网卡本身来实现，然后通过API接口给上层来调用。
			比如你之所以能在操作系统里看到网卡的MAC地址就是因为操作系统通过网卡驱动的某个接口读到了这个信息…
			那这些接口都是规定好的吧！
附：

	三元组（ip地址，协议，端口）标识网络中的进程：		
		网络层的“ip地址”可以唯一标识网络中的主机，而传输层的“协议+端口”可以唯一标识主机中的应用程序（进程）。
	协议关系图：
		协议关系图.png
附：
HTTP、Socket、TCP之间的关系与区别
	https://blog.csdn.net/qq_44918331/article/details/121294618
	应用层：
		1. 应用层协议是规定了数据的格式，所以你自己也可以定义个属于自己的应用层协议。
		2. 	在java里面，http协议的底层实现方式也是socket吗
			是的，不仅是java，也不仅是http，其他应用层协议的底层也都是socket。
			例2：
				自己动手实现HTTP协议
				https://blog.csdn.net/qq_17776287/article/details/78047450/
				我们知道HTTP协议是应用层解析内容的，只需要按照它的报文的格式封装和解析数据就可以了，具体的传输还是使用的Socket。
			例1：
				对HttpClients代码跟踪能发现其底层也是通过socket实现的
				CloseableHttpClient#execute(new HttpGet(url));
				RetryExec#execute(route, request, context, execAware);
				ProtocolExec#execute(route, request, context, execAware);
				MainClientExec#execute(route, request, context, execAware);
				AbstractConnPool#getPoolEntryBlocking(final T route, final Object state,final long timeout, final TimeUnit timeUnit,final Future<E> future);
				AbstractConnPool#ensureOpen();
				LoggingManagedHttpClientConnection#getSocketOutputStream(final Socket socket)
		http：
			http1.0 http1.1 http2.0 https
		Socket：
			Socket是一组调用接口（API），是应用层与TCP/IP协议族通信(传输层、网络层)的中间软件抽象层。
			通过Socket，我们可以便捷使用TCP/IP协议。Socket把复杂的TCP/IP协议族隐藏在Socket接口后面，对用户来说，一组简单的接口就是全部，让Socket去组织数据，以符合指定的协议。
			java中的Socket编程是通过调用操作系统的对应Socket函数来实现的。
			例：
				\SHARE_CONTENT\java基础编程\IO\通信\Socket\ServerAndClientOfSocket\NIOTcpServer.java
	传输层、网络层：
		传输层、网络层对应协议都是由对应底层系统实现了其功能，传输的数据都是一个包。
		？
			那http文件传输怎么分辨那些数据是这个文件的，或则说文件传输怎么实现的。
	网络接口层：
		定义如何使用实际网络（如Ethernet、Serial Line等）来传送数据，系统通过驱动等来使用网络接口层。



？
    什么抓包工具能抓到tcp包