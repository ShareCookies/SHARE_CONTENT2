package com.rongji.egov.doc.web;

/**
 * @autor hecaigui
 * @date 2020-8-1
 * @description
 */
public class NoParameterConstructorSon  extends NoParameterConstructor{

// 1.未提供任何构造方法，但NoParameterConstructorSon son = new NoParameterConstructorSon();还是能成功，因为java提供了个默认的无参构造方法。
//    NoParameterConstructorSon(){
//    }
// 1.注：提供个有参构造方法，但NoParameterConstructorSon son = new NoParameterConstructorSon();无法调用成功，
// 因为如果你自己有写构造方法（不管是否有参），那么java不会为你隐式提供任何构造方法。
//    NoParameterConstructorSon(String p){
//    }

    NoParameterConstructorSon(){
//        2.如果子类未在构造函数中显示调用父类的构造函数。那么java会隐式默认的为你在构造函数中使用super();来调用父类的无参构造函数。

        // 2.注1： 手动调用父类的有参构造函数，那就不会默认调用super()了。
//        super("11");
        // 2.注2： 如果父类仅提供有参构造函数，那么java也不会为你隐式调用super(),且编译期就会报错。
        // 屏蔽掉父类的无参构造函数来测试
    }
    public static void main(String[] args) {
        NoParameterConstructorSon son = new NoParameterConstructorSon();

    }
}
