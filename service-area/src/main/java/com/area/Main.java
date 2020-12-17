package com.area;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/12/17 9:38
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(f(4));
    }

    public static int f(int n){
        if(n == 1) {
            return 1;
        }
        int next = f(n - 1);

        int temp = n * next;

        return temp;
    }
}
