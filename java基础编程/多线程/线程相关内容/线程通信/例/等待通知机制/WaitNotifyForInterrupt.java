package com.china.hcg.thread.study;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @autor hecaigui
 * @date 2021-9-19
 * @description
 */
public class WaitNotifyForInterrupt {
    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(5);
        waitThread.interrupt();
        System.err.println("线程是否存活："+waitThread.isAlive());
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread() + " flag is true. wait @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.err.println("等待状态，收到中断了，线程会从等待状态恢复，然后收到中断异常。如果此时对中断异常捕获了，那么就可以继续往下走了");
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
//    static class Notify implements Runnable {
//        @Override
//        public void run() {
//            // 加锁，拥有lock的Monitor
//            synchronized (lock) {
//                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
//                // 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
//                System.out.println(Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
//                lock.notifyAll();
//                flag = false;
//                // 这里不加睡眠，通知会更快，加了 main里的持有会更快
//                // 为什么？
//                //是因为主线程休眠1s太久了，这里都跑完了，主线程估计还是在休眠状态
//                SleepUtils.second(5);
//            }
//        }
//    }
}
