package top_interview;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < Math.ceil(n / 2.0); i++) {
            int len = n - 1 - i * 2;
            for (int j = 0;j < len;j++){
                rotate4(matrix, new Pair<>(i, i + j), n - 1);
            }
        }
    }

    private void rotate4(int[][] matrix, Pair<Integer, Integer> loc, int len){
        List<Pair<Integer, Integer>> locList = new ArrayList<>();

        Pair<Integer, Integer> next = new Pair<>(loc.getValue(), len - loc.getKey());
        locList.add(loc);
        locList.add(next);
        locList.add(new Pair<>(len - loc.getKey(), len - loc.getValue()));
        locList.add(new Pair<>(len - next.getKey(), len - next.getValue()));

        Pair<Integer, Integer> tempLoc = locList.get(locList.size() - 1);
        int tempV = matrix[tempLoc.getKey()][tempLoc.getValue()];
        for (int i = locList.size() - 1; i > 0; i--) {
            replace(matrix, locList.get(i - 1), locList.get(i));
        }

        tempLoc = locList.get(0);
        matrix[tempLoc.getKey()][tempLoc.getValue()] = tempV;
    }

    private void replace(int[][] matrix, Pair<Integer, Integer> value, Pair<Integer, Integer> target){
        matrix[target.getKey()][target.getValue()] = matrix[value.getKey()][value.getValue()];
    }

    public void display(int[][] matrix){
        for (int i = 0;i < matrix.length;i++){
            StringBuilder builder = new StringBuilder();
            for(int j = 0;j < matrix.length;j++){
                builder.append(matrix[i][j] + ",\t");
            }
            System.out.println(builder.toString());
        }
    }
}
