package leetcode;

import javafx.util.Pair;

import java.util.*;

public class LRUCache {

    private int capacity;
    private Map<Integer, Pair<Long, Integer>> map;
    private long counter = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity + 1);
    }

    public int get(int key) {
        Pair<Long, Integer> pair = map.get(key);
        if (pair == null) {
            return -1;
        }
        int value = pair.getValue();
        map.put(key, new Pair<>(counter++, value));
        return value;
    }

    public void put(int key, int value) {
        map.put(key, new Pair<>(counter++, value));
        if (map.size() > capacity) {
            removeLRU();
        }
    }

    private void removeLRU() {
        int minKey = 0;
        long minTime = Long.MAX_VALUE;
        for (Map.Entry<Integer, Pair<Long, Integer>> entry : map.entrySet()) {
            if (entry.getValue().getKey() < minTime) {
                minKey = entry.getKey();
                minTime = entry.getValue().getKey();
            }
        }
        map.remove(minKey);
    }
}
