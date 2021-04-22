package com.china.hcg.test;

/**
 * @autor hecaigui
 * @date 2021-3-13
 * @description
 */
public class SubClass extends SuperClass {
    public String subPro = "子类的属性";
    static {
        System.out.println("SubClass init!");
    }
    @Override
    public void print(){
        System.err.println(this.subPro);
    }
}
