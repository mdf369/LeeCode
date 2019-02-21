package top_interview;

import java.util.*;

public class TheSkylineProblem {

    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null) {
            return null;
        }
        if (buildings.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(buildings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[2] == o2[2]) {
                        return ((Integer) o1[1]).compareTo(o2[1]);
                    } else {
                        return ((Integer) o1[2]).compareTo(o2[2]);
                    }
                } else {
                    return ((Integer) o1[0]).compareTo(o2[0]);
                }
            }
        });

        Set<Integer> criticalPointSet = new HashSet<>();
        for (int[] building : buildings) {
            criticalPointSet.add(building[0]);
            criticalPointSet.add(building[1]);
        }
        List<Integer> criticalPointList = new ArrayList<>();
        criticalPointList.addAll(criticalPointSet);
        Collections.sort(criticalPointList);

        Queue<int[]> activeRecs = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return ((Integer) o2[2]).compareTo(o1[2]);
            }
        });
        int nextBuildingIndex = 0;
        int[] heights = new int[criticalPointList.size()];
        for (int i = 0; i < criticalPointList.size(); i++) {
            int x = criticalPointList.get(i);
            List<int[]> temp = new ArrayList<>();
            for (int[] activeRec : activeRecs) {
                if (activeRec[1] == x) {
                    temp.add(activeRec);
                }
            }
            for (int[] one : temp) {
                activeRecs.remove(one);
            }
            while (nextBuildingIndex < buildings.length && buildings[nextBuildingIndex][0] == x) {
                activeRecs.add(buildings[nextBuildingIndex++]);
            }

            if (!activeRecs.isEmpty()) {
                heights[i] = activeRecs.peek()[2];
            }
        }

        List<int[]> res = new ArrayList<>();
        int lastH = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != lastH) {
                res.add(new int[]{criticalPointList.get(i), heights[i]});
                lastH = heights[i];
            }
        }
        return res;
    }
}
