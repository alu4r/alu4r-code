package com.baidu.alu4r.tool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 数据交换
 *
 * @author alu4r
 **/
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // A录入银行流水数据
                    String A = "银行流水A";
                    String B = exgr.exchange(A);
                    System.out.println("A线程收到数据:" + B);
                } catch (InterruptedException e) {
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    // B录入银行流水数据
                    String B = "银行流水B";
                    String A = exgr.exchange(B);
                    System.out.println("B线程收到数据:" + A);
                } catch (InterruptedException e) {
                }
            }
        });
        threadPool.shutdown();
    }
}
