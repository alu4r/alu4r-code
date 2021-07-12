package com.baidu.alu4r.tool;

import java.util.concurrent.CyclicBarrier;

/**
 * 同步屏障
 * 如果把new CyclicBarrier(2)修改成new CyclicBarrier(3)，则主线程和子线程会永远等待，
 * 因为没有第三个线程执行await方法，即没有第三个线程到达屏障，所以之前到达屏障的两个 线程都不会继续执行。
 *
 * @author alu4r
 **/
public class CyclicBarrierShow {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();
        c.await();
        System.out.println(2);
    }
}
