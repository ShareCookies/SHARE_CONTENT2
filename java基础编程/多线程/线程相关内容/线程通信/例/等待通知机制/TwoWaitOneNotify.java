package com.china.hcg.thread;

import java.util.concurrent.TimeUnit;

/**
 * @autor hecaigui
 * @date 2021-9-19
 * @description
 */
public class TwoWaitOneNotify {
    static Object lock = new Object();
    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread waitThread2 = new Thread(new Wait(), "WaitThread2");
        waitThread2.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName()+"线程等待");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName()+"线程醒了");
                } catch (Exception e){

                }
            }
        }
    }
    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("通知lock对象上挂起的线程");
                //只通知一个，只会有一个线程被唤醒，那么整个程序是永久不会结束的。所以要notice2次
                lock.notify();
                //lock.notify();
            }
        }
    }
}
