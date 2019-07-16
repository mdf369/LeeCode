package leetcode;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) {
            return new int[numCourses];
        }

        int[] res = new int[numCourses];
        if (prerequisites == null) {
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }

        int[][] graph = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]][prerequisite[0]] = 1;
        }

        int[] mem = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            int nextV = nextV(graph, mem, numCourses);
            if (nextV == -1) {
                return new int[0];
            }

            res[i] = nextV;
            for (int j = 0; j < numCourses; j++) {
                graph[nextV][j] = 0;
            }
        }
        return res;
    }

    private int nextV(int[][] graph, int[] mem, int numCourses) {
        for (int i = 0; i < numCourses; i++) {
            if (mem[i] == 1) {
                continue;
            }

            boolean flag = false;
            for (int j = 0; j < numCourses; j++) {
                if (graph[j][i] == 1) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                mem[i] = 1;
                return i;
            }
        }
        return -1;
    }
}
