package com.alu4r.leetcode;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/10/10 9:14
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] A = {"cool","lock","cook"};
        System.out.println(commonChars(A));
        System.out.println((int)'a' - 97);
    }
    public static List<String> commonChars(String[]A) {
        List<String> list = new ArrayList<>();
        int[] chSum = new int[26];
        for (int i = 0; i < A.length; i++) {
            char[] ch = A[i].toCharArray();
            for (char c : ch) {
                chSum[c - 97]++;
            }
        }

        for (int i = 0; i < chSum.length; i++) {
            if(chSum[i] != 0 && chSum[i] % A.length == 0){
                for (int j = 0; j < chSum[i] / A.length; j++) {
                    list.add((char)(i+97) + "");
                }
            }
        }
        return list;
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        while(head != null){
            int hashCode = head.hashCode();
            if(set.contains(hashCode)){
                return head;
            }
            set.add(hashCode);
            head = head.next;
        }
        return null;
    }
}
