package leetcode;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    private List<Integer> list;
    private int minIndex;

    public MinStack() {
        list = new ArrayList<>();
        minIndex = -1;
    }

    public void push(int x) {
        list.add(x);
        if (minIndex == -1 || x < list.get(minIndex)) {
            minIndex = list.size() - 1;
        }
    }

    public void pop() {
        list.remove(list.size() - 1);
        if (minIndex >= list.size()) {
            updateMinIndex();
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        if (minIndex == -1) {
            return 0;
        } else {
            return list.get(minIndex);
        }
    }

    private void updateMinIndex() {
        minIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (minIndex == -1) {
                minIndex = i;
            } else {
                if (list.get(i) < list.get(minIndex)) {
                    minIndex = i;
                }
            }
        }
    }
}
