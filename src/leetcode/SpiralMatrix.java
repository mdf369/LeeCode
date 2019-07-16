package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    private int width;
    private int height;

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0){
            return res;
        }

        height = matrix.length;
        width = matrix[0].length;
        spiral(matrix, 0, 0, res);
        return res;
    }

    private void spiral(int[][] matrix, int x, int y, List<Integer> res){
        int w = width - x * 2 - 1;
        int h = height - y * 2 - 1;

        if (w < 0 || h < 0){
            return;
        } else if (w == 0 && h == 0){
            res.add(matrix[y][x]);
            return;
        } else if (w == 0) {
            for (int i = 0;i <= h;i++){
                res.add(matrix[y + i][x]);
            }
            return;
        } else if (h == 0) {
            for (int i = 0;i <= w;i++){
                res.add(matrix[y][x + i]);
            }
            return;
        } else {
            for (int i = 0; i < w; i++){
                res.add(matrix[y][x + i]);
            }
            for (int i = 0; i < h; i++){
                res.add(matrix[y + i][x + w]);
            }
            for (int i = w; i > 0; i--){
                res.add(matrix[y + h][x + i]);
            }
            for (int i = h; i > 0; i--){
                res.add(matrix[y + i][x]);
            }

            spiral(matrix, x + 1, y + 1, res);
        }
    }
}
