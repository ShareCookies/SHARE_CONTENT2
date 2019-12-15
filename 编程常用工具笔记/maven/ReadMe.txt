maven配置文件（settings.xml）：
	mirrors：
		https://blog.csdn.net/liangwenmail/article/details/94555054
		多个mirror的情况下，默认第一个生效。
		镜像地址：
			<!-- 要翻墙 -->
			  <mirror>
				 <id>allrepository</id>
				 <name>allrepository</name>
				 <url>http://repo1.maven.org/maven2</url>
				 <mirrorOf>*</mirrorOf>
			  </mirror>
		
		  <mirror>
			 <id>alimaven</id>
			 <name>aliyun maven</name>
			 <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
			 <mirrorOf>central</mirrorOf>
		  </mirror>
依赖：
	maven依赖查询：
		https://mvnrepository.com/
注：
	1.命令正确，但执行失败，提示未找到一类异常，注意maven镜像。