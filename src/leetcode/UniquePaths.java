package leetcode;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];
        mem[0][0] = 1;

        return go(m - 1, n - 1, mem);
    }

    private int go(int m ,int n, int[][] mem){
        if (m < 0 || n < 0){
            return 0;
        }

        if (mem[m][n] > 0){
            return mem[m][n];
        }

        mem[m][n] = go(m - 1, n, mem) + go(m, n - 1, mem);
        return mem[m][n];
    }
}
