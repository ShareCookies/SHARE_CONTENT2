> 本文的开启大纲视图查看更佳

> 链接：https://pan.baidu.com/s/1hPoOn_sXV1cBYZNrPtfhPg 
> 提取码：5es9 
> 本文中提及的工具包



# IDEA 使用准备

### IntelliJ IDEA 激活：

​	使用jetbrains-agent.jar来激活一劳永逸。

### idea 常识：

​	1.
​		idea 文件夹：
​			使用idea编辑过的项目会产生.idea 文件夹
​		iml文件：
​			https://blog.csdn.net/u012627861/article/details/83028437
​			.iml文件是IDEA的项目标识文件，缺少了这个文件，IDEA就无法识别项目。
​	2.idea和webstorm可以说是同一个软件，它们之间的区别只是预安装插件的区别。
​		总之，idea安装插件后就能实现webstorm的功能。
​	3.
​		idea是自动保存的。可关闭

# IDEA 便捷开发

### idea常用快捷键：

1. 搜索窗口：
	https://blog.csdn.net/gnail_oug/article/details/78281354
	Ctrl+Shift+F
	
2. 搜索和替换窗口：
	Ctrl+Shift+R
	
3. Ctrl+X    不选中能剪切当前一整行，

4. Ctrl+Y	删除当前一整行

5. alt+enter 自动修复错误

6. 返回上次查看代码的位置：
	https://blog.csdn.net/u010814849/article/details/76682701/
	ctrl+alt+方向键（左，右）
	注：
		win10要关闭显卡的快捷键功能。
	
7. IDEA开发SpringMVC/SpringBoot快速查找接口地址：
	Ctrl+Shift+alt+N
	
8. 查找类：
	Ctrl+N
	
9. 清理未用到的引用类：
	Ctrl + Alt + O
	
10. 复制错误提示信息：
	alt+鼠标左键，即可把全部错误信息复制到剪切板
	
11. 编译快捷键：Ctrl+Shift+F9

12. 撤销：
	ctrl+z  恢复撤回代码：ctrl+shift+z
	
13. 复制当前行：ctrl+d

### idea插件：

> IDEA官网插件离线下载地址：https://plugins.jetbrains.com/

##### 推荐插件：

* Mybatis Log Plugin: 快速打印SQL语句
	右键->mybatis sql log ,底部导航条就会出现mybatis sql log ，只要控制台有sql打印,我们的mybatis sql log 就会自动帮大家把sql和参数进行拼装。
	注：
		mybatis sql log要处于开启状态，就是那个stop红按钮是亮着的。
* Free Mybatis Plugin: mybatis xml id与接口间跳转
* Maven Helper: maven 依赖查看
* Alibaba Java Coding Guidelines 阿里巴巴开发规范
* JRebel for IntelliJ: JavaWeb项目热部署
	Jrebel破解
		https://blog.csdn.net/qq_40110871/article/details/83420125

##### 云盘里有的其余插件

* CodeGlance: vscod右侧代码地图
	关闭：setting---other setting --- codeglance -- disabled
* Translation 翻译插件
* Rainbow Brackets: 彩虹色括号
* Grep Console: 日志着色控制台显示
* Statistic: 代码量统计
* Markdown Navigator
* RestfulToolkit: 快速定位controller层接口、接口测试
	https://blog.csdn.net/qq_22741461/article/details/81625079
	安装后，右侧会有RestServices侧边栏，点击后会显示当前项目所有请求地址
* GsonFormat: Json转Java类
* Java Bean to Json : Java类转Json
* Lombok 样版代码插件
	lombok的官方地址：https://projectlombok.org/
	lombok的Github地址：https://github.com/rzwitserloot/lombok
	Delombok了解一下啦，可以把lombok的注解替换成实际的源码，懒出新高度。
* EasyCode 根据模板语法，来生成代码
* Key Promoter X: 快捷键提示	
* .ignore: 生成git ignore文件
* Material Theme UI: 美化

##### idea编程辅助

###### 1.idea查看maven中jar包依赖关系：
```
	*maven helper插件：
		idea 中查看 maven 依赖图只会给你一个复杂到极点的图，基本没有啥价值，所以要安装个插件 maven helper，这个插件用了都说好啊。
		https://www.cnblogs.com/a8457013/p/9108698.html?tdsourcetag=s_pctim_aiomsg
	

	idea的maven依赖图：
		https://www.cnblogs.com/xiohao/p/7016730.html
		https://blog.csdn.net/u010003835/article/details/81634604
		介绍：
			1.如果有jar包冲突，idea会用红色标明
				 鼠标点击冲突状态的图标，会有红色虚线标明是跟哪个jar包冲突了，在其上右键Exclude则可以快速的排除依赖。
		操作：	
			1.对应的pom文件上右键diagrams可以看到该pom的依赖
			2.maven工具栏的-》show dependencies 可以看到项目所有的依赖
	附：
		<exclusion>：
			用maven管理库依赖，有个好处就是连同库的依赖的全部jar文件一起下载，免去手工添加的麻烦，但同时也带来了同一个jar会被下载了不同版本的问题。
			好在pom的配置里面允许用<exclusion>来排除一些不需要的依赖。
```
###### 2.idea直接操作数据库：

​	https://www.cnblogs.com/Ran-Chen/p/9646187.html
​	https://blog.csdn.net/Colton_Null/article/details/78857855

###### 3.常用设置：

​	https://www.cnblogs.com/jajian/p/8108690.html#autoid-0-0-0
​	查看类之间的关系：
​		选中类-》右键Diagram

###### 4.设置代码提示不区分大小写：

​	https://blog.csdn.net/yuanmomoya/article/details/86559607
​	https://blog.csdn.net/qq_22904145/article/details/78857948

###### 5.IDEA包分层显示：

​	https://blog.csdn.net/u014604864/article/details/76577982

###### 6.全局内容搜索和替换：

​	https://blog.csdn.net/gnail_oug/article/details/78281354
​	Edit–>Find–>Find in path或快捷键Ctrl+Shift+F

###### 7.idea查看类属性与方法：

​	https://blog.csdn.net/weixin_36210698/article/details/78564252
​	View-》Tool Windows-》Structure

###### 8.idea查看jar包中代码：

​	https://blog.csdn.net/qq_39704682/article/details/86610092

###### 9.热部署：
```
	编译快捷键：Ctrl+Shift+F9
	https://my.oschina.net/u/4006148/blog/3173833
	idea插件实现热部署：
		https://www.cnblogs.com/flyrock/archive/2019/09/23/11574617.html
		实时编译：
			https://blog.csdn.net/qq38397892/article/details/49759207
			

	附：
		IDEA之SpringBoot自带服务器热部署:
			https://blog.csdn.net/tree_ifconfig/article/details/79689304#commentBox
			https://blog.csdn.net/weixin_39330443/article/details/81739271
			DevTools是SpringBoot提供的开发工具，在激活了开发者工具以后，classpath 里对文件进行任何操作都会触发应用程序重新启动。
			SpringBoot开发者工具在重新启动时会排除 /META-INF/resources 、/resources 、/static 、/public 和/templates ； 
			可以设置Spring.devtools.restart.exclude 属性来覆盖默认的重启排除目录 ；
			注：
				该方式实现的springBoot的热部署，要在项目的pom中安装插件，麻烦且有代码耦合。
		idea之Tomcat热部署:
			https://blog.csdn.net/z15732621582/article/details/79439359
			https://blog.csdn.net/csdn_kenneth/article/details/78499750  
			tomcat配置-》server-》On frame deactivation-》update class and resources
		注：
			热部署即debug下有代码改变就自动重新编译代码
```
###### 10.IDEA同一个工程启动多个实例：

​	run/debug configuration -》新增application实例即可。


# IDEA 。。。

### idea设置：
###### idea注释模板:
	```
			https://blog.csdn.net/sikefeng/article/details/80557265
			$params$
				groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); for(i = 0; i < params.size(); i++) {result+=' * @param ' + params[i] + ((i < params.size() - 1) ? '\\n':'')}; return result", methodParameters())
	```
###### idea修改选中单词颜色：
	```
		https://blog.csdn.net/qq_23146763/article/details/78722932
		上面是同名单词背景色,
		选中单词背景色：
			...->Editor->selection bacground
		颜色：
			33 66 131
	```
###### IDEA | 更改idea打开新项目默认配置
	```
		idea 打开一个新的项目，maven都需要重新配置，解决方案
		https://blog.csdn.net/evan_leung/article/details/81505064
		File->Other Settings ->...
	```
### 遇到的idea异常：
###### 不能显示项目里的文件结构
		方法一：
			关闭IDEA，
			然后删除项目文件夹下的.idea文件夹
			重新用IDEA工具打开项目
		方法二：
			idea刷新项目、清除项目缓存
###### 新建文件为红色：
		https://blog.csdn.net/qq_24309787/article/details/79820818
		原因：
			是因为未提交到git版本库
###### 占用内存过大：
		https://blog.csdn.net/mediocre117/article/details/54925038
		建议关闭不必要的插件
###### idea解决Command line is to long	
		https://blog.csdn.net/jerry11112/article/details/94844616


### idea操作：
###### idea刷新项目、清除项目缓存：
		点击File -> Invalidate caches ，点击之后在弹出框中点击确认，之后软件就自动重启了
###### idea导入maven项目：
	```
		注:
			1.pom红波浪提示错误，这是因为项目中缺少包的原因。
				点击maven命令的clean，在点击install，再点击一下运行按钮。
				所有的jar包就会下载到本地的默认路径下（C:/Users/自己电脑的用户名/.m2），可能会有点久  稍微需要等一下，下载好了再运行项目就可以啦~~
					
				快捷键自动修复
		idea配置maven：
			File-Settings-Build...-BuildTools-maven:
				设置maven home directory和user settings file
			未设置的话要导一次项目要设置一次！
	```
###### IDEA修改项目名称：
		project structure -》 project AND modules
###### 插件安装：
		setting -》 marketplace（market市场）  可在线安装插件、
###### 任务标记：
		https://blog.csdn.net/weixin_39835887/article/details/84834934
###### 看代码是谁提交的：
		idea 对应行上右击，选 annotate，可看到代码是谁提交的。

