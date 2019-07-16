package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString(){
            return "[" + start + ", " + end + "]";
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0){
            return res;
        }

        for (Interval interval : intervals){
            if (res.size() == 0){
                res.add(interval);
                continue;
            }

            int index = search(res, interval, 0, res.size());

            if (index >= res.size()){
                res.add(interval);
                continue;
            }

            Interval target = res.get(index);
            if (isOverLapped(interval, target)){
                int start = index;
                while (start >= 0 && interval.start <= res.get(start).end){
                    start--;
                }
                int end = index;
                while (end < res.size() && interval.end >= res.get(end).start){
                    end++;
                }
                start++;
                end--;

//                start = Math.max(start, 0);
//                end = Math.min(end, res.size() - 1);
                int s = Math.min(interval.start, res.get(start).start);
                int e = Math.max(interval.end, res.get(end).end);
                Interval newInterval = new Interval(s, e);

                for (int i = end; i >= start;i--){
                    res.remove(i);
                }
                res.add(start, newInterval);
            } else if (interval.end < target.start){
                res.add(index, interval);
            } else {
                res.add(index + 1, interval);
            }
        }

        return res;
    }

    private int search(List<Interval> intervalList, Interval target, int start, int end){
        if (start >= end){
            return start;
        }

        int middle = (start + end) / 2;
        Interval interval = intervalList.get(middle);
        if (isOverLapped(interval, target)){
            return middle;
        } else if (interval.start > target.end){
            return search(intervalList, target, start, middle);
        } else {
            return search(intervalList, target, middle + 1, end);
        }
    }

    private boolean isOverLapped(Interval interval1, Interval interval2){
        if (interval1.start > interval2.end || interval1.end < interval2.start){
            return false;
        } else {
            return true;
        }
    }
}
