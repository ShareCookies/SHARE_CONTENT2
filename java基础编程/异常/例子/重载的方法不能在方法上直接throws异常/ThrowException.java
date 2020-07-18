package com.rongji.egov.zjsgy.platform;

import com.rongji.egov.utils.exception.BusinessException;

/**
 * @autor hecaigui
 * @date 2020-7-10
 * @description
 */
public class ThrowException implements NotThrowExceptionMethod {
    @Override
    public void method(){
        try {
            int i = 1/0;
        }catch (Exception e){
            throw new RuntimeException("");
        }
    }

    public static void main(String[] args) {
        System.out.println("测试");
        ThrowException exception = new ThrowException();
        exception.method();
        //捕获掉,就能继续运行了。
//        try {
//            exception.method();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        System.out.println("测试");
    }
}
