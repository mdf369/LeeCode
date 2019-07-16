package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    private Queue<Integer> left;
    private Queue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty()) {
            left.add(num);
            return;
        }

        double median = findMedian();
        if (num <= median) {
            left.add(num);
        } else {
            right.add(num);
        }

        balance();
    }

    private void balance() {
        Queue<Integer> larger, smaller;
        if (left.size() >= right.size()) {
            larger = left;
            smaller = right;
        } else {
            larger = right;
            smaller = left;
        }

        while (larger.size() - smaller.size() > 1) {
            int temp = larger.poll();
            smaller.add(temp);
        }
    }

    public double findMedian() {
        if (right.isEmpty()) {
            return left.peek();
        }

        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else if (left.size() > right.size()) {
            return left.peek();
        } else {
            return right.peek();
        }
    }
}
