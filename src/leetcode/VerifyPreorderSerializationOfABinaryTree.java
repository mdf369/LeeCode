package leetcode;

public class VerifyPreorderSerializationOfABinaryTree {

  public boolean isValidSerialization(String preorder) {
    String[] nodes = preorder.split(",");
    return isValid(nodes, 0, nodes.length);
  }

  private boolean isValid(String[] nodes, int start, int end) {
    if (((end - start) & 1) != 1) {
      return false;
    }

    if (nodes[start].equals("#")) {
      return end - start == 1;
    }

    if (end - start == 1) {
      return false;
    }

    int middle = findEnd(nodes, start + 1);
    return isValid(nodes, start + 1, middle) && isValid(nodes, middle, end);
  }

  private int findEnd(String[] nodes, int start) {
    int count = 1;
    while (count > 0) {
      if (nodes[start].equals("#")) {
        count--;
      } else {
        count++;
      }
      start++;
    }
    return start;
  }
}
