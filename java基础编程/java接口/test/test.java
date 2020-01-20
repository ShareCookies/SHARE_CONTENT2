/**
 * 
 */
package test;

/**
 * @author Administrator
 *
 */
public class test {

	/**
	 * 
	 */
	public test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // 第一步：首先要实例化将接口作为参数的类也就是C类  
	   C   c = new C();  
	   /*第二步：然后实例化实现接口的类也就是B类了 
	     这里面就体现了接口多态的用法 
	   */  
	        B  a  = new B();  
	   //第三步： 接下来也就体现出了  
	       c.nihao((A)new B());  
	}

}
