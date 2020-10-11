package com.china.hcg.threads.concurrent;

/**
 * @autor hecaigui
 * @date 2020-10-2
 * @description
 */
public  class MyTask12 implements Runnable{
    SynchronizedTest synchronizedTest;
    MyTask12(SynchronizedTest synchronizedTest){
        this.synchronizedTest = synchronizedTest;
    }
    @Override
    public void run() {
        //SynchronizedTest synchronizedTest = new SynchronizedTest();//不能在run中创建对象，那么synchronized将失效
        synchronizedTest.executeSynchronized("到同步啦");
    }
}