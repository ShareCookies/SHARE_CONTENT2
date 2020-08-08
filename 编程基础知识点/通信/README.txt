原文：https://blog.csdn.net/pashanhu6402/article/details/96428887



TCP/IP（Transmission Control Protocol/Internet Protocol）
	即传输控制协议/网间协议，是一个工业标准的协议集，它是为广域网（WANs）设计的。
	附：
		三次握手，四次挥手:
			https://blog.csdn.net/Tomwildboar/article/details/104008537
			https://blog.csdn.net/maoxin604/article/details/81431805

UDP（User Data Protocol）
	用户数据报协议，是与TCP相对应的协议。它是属于TCP/IP协议族中的一种。
	附：
		为什么不说udp/ip ：
			https://www.zhihu.com/question/315014201
附：
	TCP/IP协议族：
		是指tcp/ip包括的东西吧。
		包括运输层、网络层、链路层。
	三元组（ip地址，协议，端口）标识网络中的进程：		
		网络层的“ip地址”可以唯一标识网络中的主机，而传输层的“协议+端口”可以唯一标识主机中的应用程序（进程）。
	协议关系图：
		协议关系图.png
	
	Web协议族：
		万维网WWW（world wide web）世界上规模最大的信息系统，在WWW的背后有一系列的协议和标准支持它，这就是Web协议族。

Socket:
    介绍： 	
		Socket是对TCP/IP协议的封装，Socket本身并不是协议，而是一个调用接口（API），通过Socket，我们才能使用TCP/IP协议。
			复杂点说法：
			Socket是应用层与TCP/IP协议族通信的中间软件抽象层，它只是一组接口。
			在设计模式中，Socket其实就是一个门面模式，它把复杂的TCP/IP协议族隐藏在Socket接口后面，对用户来说，一组简单的接口就是全部，让Socket去组织数据，以符合指定的协议。
		附：
			socket起源于Unix，UNIX BSD的套接字（socket）
			Unix/Linux基本哲学之一就是“一切皆文件”，都可以用“打开open –> 读写write/read –> 关闭close”模式来操作,socket也符合这种思想。
	socket的使用：
		...

Http协议：
	./