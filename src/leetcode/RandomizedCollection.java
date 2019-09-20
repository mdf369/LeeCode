package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class RandomizedCollection {

  private List<Integer> list;
  private Map<Integer, Queue<Integer>> map;
  private Random random;

  /** Initialize your data structure here. */
  public RandomizedCollection() {
    list = new ArrayList<>();
    map = new HashMap<>();
    random = new Random(System.currentTimeMillis());
  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
    boolean exist = map.containsKey(val);
    Queue<Integer> queue = exist ? map.get(val) : new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
    list.add(val);
    queue.add(list.size() - 1);
    if (!exist) {
      map.put(val, queue);
    }
    return !exist;
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }

    Queue<Integer> queue = map.get(val);
    int index = queue.poll();
    if (index != list.size() - 1) {
      int lastVal = list.get(list.size() - 1);
      Queue<Integer> lastQueue = map.get(lastVal);
      lastQueue.poll();
      lastQueue.add(index);
      list.set(index, lastVal);
    }
    list.remove(list.size() - 1);
    if (queue.isEmpty()) {
      map.remove(val);
    }
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    return list.get(random.nextInt(list.size()));
  }
}
