package com.china.hcg.thread.study.sync;

/**
 * @autor hecaigui
 * @date 2020-10-2
 * @description
 */
public  class MyTask12 implements Runnable{
    SynchronizedTest synchronizedTest;
    SynchronizedTestForPublicMethod synchronizedTestForPublicMethod;
    MyTask12(SynchronizedTest synchronizedTest){
        this.synchronizedTest = synchronizedTest;
    }
    MyTask12(SynchronizedTestForPublicMethod synchronizedTestForPublicMethod){
        this.synchronizedTestForPublicMethod = synchronizedTestForPublicMethod;
    }
    @Override
    public void run() {
        //SynchronizedTest synchronizedTest = new SynchronizedTest();//不能在run中创建对象，那么synchronized将失效
        //synchronizedTest.executeSynchronized("到同步啦");
        synchronizedTestForPublicMethod.executeSynchronized("到同步啦");
    }
}