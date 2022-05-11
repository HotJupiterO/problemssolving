package leetcode.com.stream_data;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(12);
        mf.addNum(7);
        mf.addNum(11);
        mf.addNum(11);
        mf.addNum(11);
        TreeMap<Integer, Integer> q = mf.getTree();
        int l = 0;
        for (int i : q.values()) {
            l += i;
        }
        //int m = 0;
        int index  = l;
        for (int i : q.keySet()) {
            index-=q.get(i);
            if (index == l / 2) {
                System.out.println("MY MEDIAN IS: ");
                System.out.println(q.get(i));
            }
        }
        System.out.println(q);
        System.out.println("tree length = " + l);
        System.out.println("=========================================\n");


    }
}
