package com.china.hcg.threads;

/**
 * @autor hecaigui
 * @date 2020-10-1
 * @description
 */
public class Test extends AccessModifier{
    void t(){
        super.defaultMethod();
    }
    public static void main(String[] args) {
        AccessModifier t = new AccessModifier();
        //t.privateMethod();//调用失败报异常
        //AccessModifier.staticPrivateMethod();//调用失败报异常
        t.protectedMethod();
    }
}
