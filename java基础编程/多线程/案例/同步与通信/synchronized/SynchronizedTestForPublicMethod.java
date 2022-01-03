package com.china.hcg.thread.study.sync;

/**
 * @autor hecaigui
 * @date 2020-10-2
 * @description
 */
public class SynchronizedTestForPublicMethod {

    synchronized public void systemString(String s) {
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
        SynchronizedTestForPublicMethod synchronizedTest = new SynchronizedTestForPublicMethod();
        Runnable runnable = new MyTask12(synchronizedTest);
        Thread thread1 = new Thread(runnable ,"线程1");
        thread1.start();
        //synchronized方法即使为public了。主进程持有了锁，其他线程想进来还是要获得锁啊 否则阻塞
        synchronizedTest.systemString("11");
    }

}
