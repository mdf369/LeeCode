package top_interview;

public class SearchA2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    if (matrix[0][0] > target) {
      return false;
    }
    if (matrix[matrix.length - 1][0] <= target) {
      return searchRow(matrix[matrix.length - 1], target, 0, matrix[0].length);
    }

    int rowIndex = searchColumn(matrix, target, 0, matrix.length);
    return searchRow(matrix[rowIndex], target, 0, matrix[rowIndex].length);
  }

  private int searchColumn(int[][] matrix, int target, int start, int end) {
    if (start >= end) {
      return start;
    }

    int middle = (start + end) / 2;
    if (matrix[middle][0] > target) {
      return searchColumn(matrix, target, start, middle);
    } else if (matrix[middle + 1][0] <= target) {
      return searchColumn(matrix, target, middle + 1, end);
    } else {
      return middle;
    }
  }

  private boolean searchRow(int[] row, int target, int start, int end) {
    if (start >= end) {
      return false;
    }

    int middle = (start + end) / 2;
    if (row[middle] == target) {
      return true;
    } else if (row[middle] > target) {
      return searchRow(row, target, start, middle);
    } else {
      return searchRow(row, target, middle + 1, end);
    }
  }
}
