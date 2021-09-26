package com.china.hcg.thread.study;

import java.util.concurrent.TimeUnit;

/**
 * @autor hecaigui
 * @date 2021-8-30
 * @description
1. jps 获取java进程id。
例：运行该示例，打开终端或者命令提示符，键入“jps”，输出如下。
    611
    935 Jps
    929 ThreadState
    可以看到运行示例对应的进程ID是929，
 2. jstack 进程id 获取进程的栈信息。
部分输出如下：
// BlockedThread-2线程阻塞在获取Blocked.class示例的锁上
"BlockedThread-2" prio=5 tid=0x00007feacb05d000 nid=0x5d03 waiting for monitor entry [0x000000010fd58000]
    java.lang.Thread.State: BLOCKED (on object monitor)
// BlockedThread-1线程获取到了Blocked.class的锁
"BlockedThread-1" prio=5 tid=0x00007feacb05a000 nid=0x5b03 waiting on condition [0x000000010fc55000]
    java.lang.Thread.State: TIMED_WAITING (sleeping)
// WaitingThread线程在Waiting实例上等待
"WaitingThread" prio=5 tid=0x00007feacb059800 nid=0x5903 in Object.wait() [0x000000010fb52000]
    java.lang.Thread.State: WAITING (on object monitor)
// TimeWaitingThread线程处于超时等待
"TimeWaitingThread" prio=5 tid=0x00007feacb058800 nid=0x5703 waiting on condition [0x000000010fa4f000]
    java.lang.Thread.State: TIMED_WAITING (sleeping)
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new Runnable_running(), "Runnable_running").start();
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        // 使用两个Blocked线程，一个获取锁成功，另一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
    }
    // 内部类!
    // 该线程不断地进行睡眠
    static class TimeWaiting implements Runnable {
        @Override public void run() { while (true) { SleepUtils.second(100); } }
    }
        // 该线程在Waiting.class实例上等待
    static class Waiting implements Runnable {
        @Override public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 该线程在Blocked.class实例上加锁后，不会释放该锁
    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) { while (true) { SleepUtils.second(100); } }
        }
    }
    static class Runnable_running implements Runnable {
        @Override
        public void run() {
            while (true) {  }
        }
    }
}
//同级类？

