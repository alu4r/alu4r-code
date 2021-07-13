package com.baidu.alu4r.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子更新引用类型
 *
 * @author alu4r
 **/
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicUserRef = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("user", 15);
        atomicUserRef.set(user);
        User updateUser = new User("updateUser", 17);
        atomicUserRef.compareAndSet(user, updateUser);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
    }

    static class User {
        private final String name;
        private final int old;

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
