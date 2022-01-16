package com.china.hcg.thread.study.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @autor hecaigui
 * @date 2021-10-24
 * @description
 */
public class ReentrantReadWriteLockTest {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //readWriteLockTest();
        holdReadLockCantUseWriteLock();
    }
    /**
     * @description 读写锁使用。
     *         //1. 多个读线程可以同时运行的证明
     *         readT1.start();
     *         readT2.start();
     *         //2. 写线程是排他锁的证明
     *         wT.start();
     */
    static void readWriteLockTest(){
        Thread readT1 = new Thread(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                Object o = CacheImplByReadlockAndWriteLock.get("test");
                System.err.println(Thread.currentThread().getName()+i+":"+o);
                if (i++ < 30){
                    this.run();
                }
            }
        });
        readT1.setName("读线程一：");
        Thread readT2 = new Thread(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                Object o = CacheImplByReadlockAndWriteLock.get("test");
                System.err.println(Thread.currentThread().getName()+i+":"+o);
                if (i++ < 30){
                    this.run();
                }
            }
        });
        readT2.setName("读线程二：");
        Thread wT = new Thread(new Runnable() {
            @Override
            public void run()  {
                Object o = CacheImplByReadlockAndWriteLock.put("test","写入的新内容，并让写锁暂停了3s，所以读锁会失去锁等3s");
            }
        });
        wT.setName("写线程");
        //1. 多个读线程可以同时运行的证明
        readT1.start();
        readT2.start();
        //2. 写线程是排他锁的证明
        wT.start();
    }
    /**
     * @description 有读锁存在时，写线程也会被阻塞，直到读锁释放。
     * @return
     */
    static void holdReadLockCantUseWriteLock(){
        Thread readT1 = new Thread(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                Object o = CacheImplByReadlockAndWriteLock.getExclusiveLock("test");

                System.err.println(Thread.currentThread().getName()+i+":"+o);
                if (i++ < 30){
                    this.run();
                } else {
                    CacheImplByReadlockAndWriteLock.getExclusiveUnLock("test");
                }
            }
        });
        readT1.setName("读线程一：");

        Thread wT = new Thread(new Runnable() {
            @Override
            public void run()  {
                Object o = CacheImplByReadlockAndWriteLock.put("test","写入的新内容，并让写锁暂停了3s，所以读锁会失去锁等3s");
            }
        });
        wT.setName("写线程");
        //1. 读线程持有读锁不释放，写锁是进不来的
        readT1.start();

        //2. 3ms后释放读锁，写锁就进来了
        wT.start();
    }
}
/**
 * @description 通过读写锁实现的缓存
 * @author hecaigui
 * @date 2022-1-16
 * @param  * @param null
 * @return
 */
class CacheImplByReadlockAndWriteLock {
    static Map<String, Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    //获取读锁
    static Lock readLock = reentrantReadWriteLock.readLock();
    //获取写锁
    static Lock writeLock = reentrantReadWriteLock.writeLock();

    public static final Object get( String key) {

        readLock.lock();
        try { return map.get(key); }
        finally { readLock.unlock(); }
    }
    public static final Object put(String key, Object value) {
        writeLock.lock();
        try {
            Thread.sleep(3000);
            return map.put(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally { writeLock.unlock(); }
    }
    public static final Object getExclusiveLock( String key) {
        //要判断是否已持有锁
        readLock.lock();
        try { return map.get(key); }
        catch (Exception e){ readLock.unlock(); }
        finally {
            return null;
        }
    }
    public static final boolean getExclusiveUnLock() {
        try {
            readLock.unlock();
        }catch (Exception e){}
        return true;
    }
}

