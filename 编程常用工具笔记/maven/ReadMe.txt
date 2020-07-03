链接：
	官网：https://maven.apache.org/
	maven教程：http://www.yiidian.com/maven/maven-life-cycle.html
	maven依赖查询：
		https://mvnrepository.com/
maven是什么：
	1.Maven是一款开源的项目管理工具软件。
	Maven采用了一种被称之为Project Object Model (项目对象模型，简称POM)概念来管理项目，
	所有的项目配置信息都被定义在一个叫做POM.xml的文件中, 
	通过该文件Maven可以管理项目的整个生命周期，包括清除、编译、测试、报告、打包、部署等。
	2.maven不仅是一款优秀的构建工具，而且是一款优秀的依赖管理工具和项目信息管理工具。
	hcg：
		maven是一个工具软件，它能帮你管理java项目的打包和依赖等。
			目前maven仅支持管理java项目。
		但是你的项目想要使用maven来管理，那么就要符合maven的规范才行，即要提供pom.xml(项目配置文件)，和目录要符合maven要求。
			maven项目规约:
				http://www.yiidian.com/maven/maven-standard.html
				maven web项目结构：
					pom.xml                 核心配置
					src/main/java                java源码
					src/main/resources            java配置
					src/main/webapp            myeclipse web项目中 WebRoot目录
						|-- WEB-INF
						|-- web.xml
					src/test                    测试
					target                    maven的输出目录，
	注：
		那么如何构建一个maven项目了，只要你的项目结构符合maven结构规范即可。
Maven如何管理项目:
	Maven生命周期
		Maven的生命周期就是对项目的构建过程进行抽象和统一；
		包括项目清理，初始化，编译，打包，测试，部署等构建步骤。
	maven用命令管理项目各生命周期：
		./maven命令介绍.txt
maven的依赖管理：
	介绍：
		在pom.xml中声明依赖，maven就会自动下载依赖，并引入到当前maven项目。
		总之声明依赖后，什么都不用管，maven都帮你搞定了。
	仓库：
		介绍：
			仓库就是存放依赖和插件的地方。
				Maven在某个统一的位置存储所有项目的共享的构件，这个统一的位置，就称之为仓库。
			附：
				maven会根据pom中依赖配置自动从仓库中自动获取jar包，所以你无需手动引入jar包等。
		仓库分类：
			本地仓库、第三方仓库(私服)、中央仓库。
		从仓库获取jar包过程：
			优先从本地仓库查找，
			没有的话，如果有私服配置从私服找，
			没有的话，从中央仓库获取，然后下载到本地仓库
		本地仓库：
			Maven会将工程中依赖的构件(Jar包和插件)从远程下载到本机一个目录下管理，每个电脑默认的仓库是在 $user.home/.m2/repository下
				例：C:\Users\Administrator\.m2\repository
			附：
			修改本地库位置：
				1.新建一个文件夹作为本地仓库（）
				2.
					方式1.maven安装目录/conf/setting.xml文件中修改
					方式2.idea-》setting-》maven中可以覆盖。
			maven引入本地jar包：
				https://www.cnblogs.com/chywx/p/11563318.html
					
		第三方仓库：
			第三方仓库，又称为内部中心仓库，也称为私服。
			一般是由公司自己设立的，只为本公司内部共享使用。
			有两个作用：
				1.存放一些公司内部的包，供公司人员使用。
				2.作为公用类库镜像缓存，提高jar下载的频率。
			注：
				如果想让maven连接私服获取jar包，那么需要配置私服信息。如果没有配置私服，默认不使用。
			附：
				使用nexus构建私服：
					http://www.yiidian.com/maven/maven-dependence.html
				使用nexus上传下载第三方jar包：	
					https://www.cnblogs.com/chywx/p/11227151.html
				批量上传jar包到私服：
					https://blog.csdn.net/isea533/article/details/77197017
					例：
						./例/Deploy.java
					附:
						-Durl=xxx指定了上传的仓库位置，从nexus的配置 -》repository ->repositories 中可以复制到对应的仓库地址
						2.随便上传到那个仓库都行
		中央仓库：
			这个公共仓库是由Maven自己维护，里面有大量的常用类库，并包含了世界上大部分流行的开源项目构件。目前是以java为主
			Maven内置了远程公用仓库：http://repo1.maven.org/maven2
			附：
				发布Jar包到Maven中央仓库：
					https://www.jianshu.com/p/f726dce40bef
				从中央仓库获取包:
	　　			1.https://maven.aliyun.com/mvn/search
					2.输入关键字查询获得需要内容，确定需要版本
					3.复制获得的坐标即可,获取坐标即三个关键属性值
	注：
		idea的maven工具-》dependences中的依赖未加载成功（有红色波浪线）
			解决方案：
			方式1.maven清缓存，重新刷新依赖
			方式2.看本地仓库中是否存在包，把包删了在重新拉依赖
			方式3.确认私服中是否有包...
maven环境安装：
	https://blog.csdn.net/qq_37497322/article/details/78988378
	1.安装maven
	2.修改maven配置文件：（settings.xml）
		maven默认有个全局的配置：maven安装目录/conf/settings.xml。
		可以在里面设置私服仓库地址，本地依赖保存地址等
	附：
		./maven配置文件.txt
pom.xml介绍:(项目配置文件)
	https://maven.apache.org/pom.html
	./
	附：
		idea中的maven依赖关系图：
			https://blog.csdn.net/yangxiaobo118/article/details/79890124
	

maven多模块管理项目：
	maven能够对一些较大的项目，通过合理的模块拆分，实现代码的复用，便于维护和管理。
	./maven多模块管理项目.txt

附：
	不安装maven，编辑器一样可以使用maven：
		idea自带默认内嵌一个maven。
		附：
			1.
				C:\Users\用户名\.m2\，这个就是默认的m2e的文件夹，里头存放了内嵌的maven配置，下载的jar包都在这里。
			2.为什么要自己安装maven呢:
				IDEA不是自带maven插件了吗，为什么要自己安装maven呢。
				内嵌版本一般是特定版本，最好是下载官方最新版本自行配置，这样既可以很方便地使用命令行进行打包编译等其他操作，对于以后的更新也是方便的。
