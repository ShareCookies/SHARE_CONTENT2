组合模式composite pattern：
	定义：
		组合模式允许你将对象组合成树形结构来表现"整体/部分"层次结构。
		组合能让客户以一致的方式处理个别对象以及对象组合。
		附：
			树形结构：
				带子元素的称为节点（node）。
				没有子元素的元素称为叶节点(leaf)。
		hcg：
			组合模式能将个别对象组合形成树形结构的组合对象，
			然后以一致的方式处理个别对象以及对象组合。
	利用组合没计菜单：		
		
	实现思路：
		为个别对象创建一个统一接口，便于形成一个组合对象。
		通过统一接口提供的方法将个别对象组合成一个组合对象，个别对象和组合对象就会形成树形结构。
	例：
		利用组合模式没计菜单：
			创建一个组件接口来作为菜单和菜单项的共同接口。
			通过组件接口的add方法将个别对象组合成树形结构，最后调用组件接口其他方法来对组合对象进行操作，如打印菜单等。
			./例/Test.java
		