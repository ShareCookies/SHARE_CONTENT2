package com.china.hcg.threads.concurrent;

/**
 * @autor hecaigui
 * @date 2020-10-2
 * @description
 */
public class SynchronizedTest {
    synchronized private void systemString(String s) {
        System.out.println(Thread.currentThread().getName()+"====="+"到同步啦，别的线程进不来咯");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"====="+"结束啦，别的线程可以进来咯");
    }
    public void executeSynchronized(String s){
        this.systemString(s);
    }
    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Runnable runnable = new MyTask12(synchronizedTest);
        Thread thread1 = new Thread(runnable ,"线程1");
        thread1.start();
        Thread thread2 = new Thread(runnable ,"线程2");
        thread2.start();
        //synchronizedTest.executeSynchronized("");//主线程下，掉synchronized也是进不去的
        // 如果synchronized方法为public了
        synchronizedTest.systemString("11");
    }

}
