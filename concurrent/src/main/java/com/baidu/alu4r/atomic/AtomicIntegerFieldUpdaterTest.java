package com.baidu.alu4r.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 原子更新字段
 *
 * @author alu4r
 **/
public class AtomicIntegerFieldUpdaterTest {
    /**
     * 创建原子更新器,并设置需要更新的对象类和对象的属性
     */
    private static final AtomicIntegerFieldUpdater<User> ATOMIC = AtomicIntegerFieldUpdater
            .newUpdater(User.class, "old");

    public static void main(String[] args) {
        // 设置柯南的年龄是10岁
        User conan = new User("conan", 10);
        // 柯南长了一岁,但是仍然会输出旧的年龄
        System.out.println(ATOMIC.getAndIncrement(conan));
        // 输出柯南现在的年龄
        System.out.println(ATOMIC.get(conan));
    }

    public static class User {
        private final String name;
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}
