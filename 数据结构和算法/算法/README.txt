复杂度:
	https://blog.csdn.net/weixin_30340819/article/details/98148676
	https://blog.csdn.net/qq_17534301/article/details/82872357
什么是算法的稳定性：
	https://segmentfault.com/q/1010000014749041
	

递归:
	核心思想:自己调用自己
	例：
		案例1:
			问题：
				有五个人坐在一起，问第五个人多少岁？他说比第四个人大2岁。问第四个人岁数，他说比第三个人大2岁。问第三个人，又说比第二个人大2岁。问第二个人，说比第一个人大2岁。最后问第一个人，他说是10岁。请问第五个人多大。用递归调用的方法设计程序完成本题目。
			实现：    
				当前函数的部分值来自，上个自身函数。
					上个自身函数要有终止的条件
				public int recursionRule(Integer uptoNum){
					if (uptoNum == 1){ return 10;}
					else {
						return recursionRule(uptoNum-1)+2;
					}
				}
				public static void main(String[] args) {
					NumAddRecursion son = new NumAddRecursion();
					System.out.println(son.recursionRule(5));
				}
		案例2：
			./例/递归.txt
排序算法：
	./排序算法.txt

