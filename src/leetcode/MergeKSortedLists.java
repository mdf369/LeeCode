package leetcode;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    private Queue<Pair<Integer, Integer>> candidate;

    public ListNode mergeKLists(ListNode[] lists) {
        candidate = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (int i = 0;i < lists.length;i++){
            update(lists, i);
        }

        ListNode root = new ListNode(-1);
        ListNode point = root;

        while (true){
            Pair<Integer, Integer> pair = candidate.poll();
            if (pair == null){
                return root.next;
            }

            point.next = new ListNode(pair.getKey());
            update(lists, pair.getValue());
            point = point.next;
        }
    }

    private void update(ListNode[] lists, int index){
        ListNode node = lists[index];
        if (node == null){
            return;
        } else {
            candidate.add(new Pair<>(node.val, index));
            lists[index] = node.next;
        }
    }
}
