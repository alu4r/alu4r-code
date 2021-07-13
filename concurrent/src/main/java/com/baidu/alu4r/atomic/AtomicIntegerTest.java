package com.baidu.alu4r.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子操作类
 *
 * @author alu4r
 **/
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
