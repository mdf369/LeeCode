package leetcode;

public class ConstructQuadTree {

  private class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
      val = _val;
      isLeaf = _isLeaf;
      topLeft = _topLeft;
      topRight = _topRight;
      bottomLeft = _bottomLeft;
      bottomRight = _bottomRight;
    }
  }

  private boolean isAllSame(int[][] grid, int startX, int startY, int endX, int endY) {
    int pre = grid[startX][startY];
    for (int i = startX; i < endX; i++) {
      for (int j = startY; j < endY; j++) {
        if (pre != grid[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  private Node convert(int[][] grid, int startX, int startY, int endX, int endY) {
    if (isAllSame(grid, startX, startY, endX, endY)) {
      return new Node(grid[startX][startY] == 1, true, null, null, null, null);
    }

    Node node = new Node();
    node.isLeaf = false;
    int midX = (startX + endX) / 2;
    int midY = (startY + endY) / 2;
    node.topLeft = convert(grid, startX, startY, midX, midY);
    node.topRight = convert(grid, startX, midY, midX, endY);
    node.bottomLeft = convert(grid, midX, startY, endX, midY);
    node.bottomRight = convert(grid, midX, midY, endX, endY);
    return node;
  }

  public Node construct(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return null;
    }

    return convert(grid, 0, 0, grid.length, grid.length);
  }
}
