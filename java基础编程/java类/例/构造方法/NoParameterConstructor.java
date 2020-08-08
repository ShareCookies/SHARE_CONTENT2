package com.rongji.egov.doc.web;

/**
 * @autor hecaigui
 * @date 2020-8-1
 * @description
 */
public class NoParameterConstructor {
    public NoParameterConstructor(){
        // 覆盖掉了默认的无参构造函数
        System.out.println("覆盖掉了默认的无参构造函数");
    }
    public NoParameterConstructor(String  string){
        // 覆盖掉了默认的无参构造函数
        System.out.println("父构造函数参数"+string);
    }
}
