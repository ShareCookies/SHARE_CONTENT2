package test.aop.jdkProxyUseCase;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @autor hecaigui
 * @date 2020-1-31
 * @description
使用：
通过java反射的Proxy来创建代理
Proxy：
	Proxy provides static methods for creating dynamic proxy classes and instances
	newProxyInstance参数
		1. 目标对象类加载器
		2. 目标对象的接口（目标对象没有实现接口了？或实现多个接口了）
		3. 调用处理器
			介绍：对代理的每个方法的调用都先经过该方法。
附：
java 动态代理 为什么在debug 时会多次执行invoke 内部方法：
	https://blog.csdn.net/Java_HuiLong/article/details/85321828
	debug时候，idea会调用“被代理类”的toString()方法	
 */
public class ProxyTest {
    //生成目标对象的代理
    PersonBean getProxy(final  PersonBean personBean){
        //参数1. 目标对象类加载器 2. 目标对象的接口（目标对象没有实现接口了？或实现多个接口了） 3. 调用处理器
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().startsWith("get")){
                            //执行目标对象方法
                            Object returnValue = method.invoke(personBean, args);
                            return returnValue;
                        }else {
                            System.err.println(method.getName());
                            System.err.println(1111111);
                            return null;
                        }
                    }
                });
    }
    public static void main(String[] args) {
        ProxyTest proxyTest = new ProxyTest();
        PersonBean personBean = new PersonBeanImpl();

        // 获取目标对象代理实例
        PersonBean proxy = proxyTest.getProxy(personBean);
        //调用代理实例方法，转向调用处理器，处理器自己决定是否执行目标对象方法
        //proxy.getName();//能调用成功
        proxy.setName("11");//调用失败
    }

}
