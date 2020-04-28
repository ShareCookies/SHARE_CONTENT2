package com.china.hcg.eas.business;

/**
 * @autor hecaigui
 * @date 2020-4-24
 * @description
 */
public class Generic<T>{
    private T key;//key这个成员变量的类型为T,T的类型由外部指定
    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }
    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }
    public static void main(String[] args) {
        //Generic<Father> generic = new Generic<Father>(new Son());


//        1.泛型能够将容器的类型错误检测移入到编译期（注不是容器的持有类型）
//        子类泛型不能与父类泛型匹配。
////        Generic<Father> generic = new Generic<Son>(new Son());
////        Incompatible types.
////        Required:Generic<com.china.hcg.eas.business.Father>
////        Found:Generic<com.china.hcg.eas.business.Son>
//        2.此时用通配符，就可达到泛型类型匹配的向上转型关系
//        Generic<? extends  Father> generic = new Generic<Son>(new Son());


        System.out.println(generic.getKey().toString());
    }


}
class Father{

}
class Son extends  Father{

}