链接：
	官网：https://maven.apache.org/
	maven教程：http://www.yiidian.com/maven/maven-life-cycle.html
	maven依赖查询：
		https://mvnrepository.com/
maven是什么：
    maven是什么:
        Maven是一款开源的项目管理工具软件，可实现项目构建，依赖管理和项目信息管理。
	maven是什么-hcg：
		maven是一个工具软件，它能帮你管理java项目的打包和依赖等。目前maven仅支持管理java项目。
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
        即：
            那么如何构建一个maven项目了，只要你的项目结构符合maven规范即可。

maven环境安装：
	https://blog.csdn.net/qq_37497322/article/details/78988378
	1.安装maven
	2.修改maven全局配置文件
    附：
        不安装maven，编辑器一样可以使用maven：
            idea自带默认内嵌一个maven。
        为什么要自己安装maven呢:
            IDEA不是自带maven插件了吗，为什么要自己安装maven呢。
            内嵌版本一般是特定版本，最好是下载官方最新版本自行配置，这样既可以很方便地使用命令行进行打包编译等其他操作，对于以后的更新也是方便的。

配置文件：
    全局配置文件：
        maven默认有个全局的配置：maven安装目录/conf/settings.xml。
        可以在里面设置  本地仓库地址、私服仓库地址等
        ./maven配置文件.txt
        附：
            修改本地库位置：
                1.新建一个文件夹作为本地仓库
                2.
                    方式1.maven安装目录/conf/setting.xml文件中修改
                    方式2.idea-》setting-》maven中可以覆盖。
    项目配置文件：
        pom.xml介绍:
            https://maven.apache.org/pom.html
            Maven采用了一种被称之为Project Object Model (项目对象模型，简称POM)概念来管理项目，所有的项目配置信息都被定义在一个叫做POM.xml的文件中,
            通过该文件Maven可以管理项目的整个生命周期，包括清除、编译、测试、报告、打包、部署等。
        附：
            依赖关系：
                idea中可使用Maven Helper插件来查看依赖关系。
            maven引入本地jar包：
                https://www.cnblogs.com/chywx/p/11563318.html
                <dependency>
                    <groupId>...</groupId>
                    <artifactId>...</artifactId>
                    <version>1.0-SNAPSHOT</version>
                    <scope>system</scope>
                    <systemPath>${basedir}/src/main/resources/lib/....jar</systemPath>
                </dependency>
maven基础概念：
    ./maven基础概念.txt

maven多模块管理项目：
	maven能够对一些较大的项目，通过合理的模块拆分，实现代码的复用，便于维护和管理。
	./maven多模块管理项目.txt

