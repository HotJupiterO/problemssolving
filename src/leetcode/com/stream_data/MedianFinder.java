package leetcode.com.stream_data;

import java.util.*;

public class MedianFinder {
    //private final Queue<Integer> priorityQueue;
    private final TreeMap<Integer, Integer> tree;

    public TreeMap<Integer, Integer> getTree() {
        return this.tree;
    }

    public MedianFinder() {
        //this.priorityQueue = new PriorityQueue<>();
        this.tree = new TreeMap<>();
    }


    public void addNum(int num) {
//        this.priorityQueue.add(num);
        if (tree.containsKey(num)) tree.put(num, tree.get(num) + 1);
        else tree.put(num, 1);
    }

    public double findMedian() {
        double median = 0d;

        return median;
    }
}