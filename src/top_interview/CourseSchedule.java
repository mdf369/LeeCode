package top_interview;

import java.util.HashSet;
import java.util.Set;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return true;
        }
        if (numCourses <= 1) {
            return true;
        }

        int[][] graph = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    if (!checkPath(graph, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkPath(int[][] graph, int x, int y) {
        if (x == y) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(x);
        set.add(y);
        graph[x][y] = 0;
        return checkPath(graph, y, set);
    }

    private boolean checkPath(int[][] graph, int x, Set<Integer> set) {
        for (int i = 0; i < graph[x].length; i++) {
            if (graph[x][i] == 1) {
                if (set.contains(i)) {
                    return false;
                } else {
                    set.add(i);
                    if (!checkPath(graph, i, set)) {
                        return false;
                    }
                    set.remove(i);
                }
            }
        }
        return true;
    }
}
