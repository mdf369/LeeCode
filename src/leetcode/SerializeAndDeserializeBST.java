package leetcode;

import javafx.util.Pair;

public class SerializeAndDeserializeBST {

  private void serialize(TreeNode node, StringBuilder builder) {
    builder.append(node.val);
    if (node.left == null && node.right == null) {
      builder.append('N');
    } else if (node.right == null) {
      builder.append('L');
      serialize(node.left, builder);
    } else if (node.left == null) {
      builder.append('R');
      serialize(node.right, builder);
    } else {
      builder.append('F');
      serialize(node.left, builder);
      serialize(node.right, builder);
    }
  }

  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }

    StringBuilder builder = new StringBuilder();
    serialize(root, builder);
    return builder.toString();
  }

  private int getNextSignIndex(String data, int start) {
    while (start < data.length() && data.charAt(start) >= '0' && data.charAt(start) <= '9') {
      start++;
    }
    return start;
  }

  private Pair<TreeNode, Integer> deserialize(String data, int index) {
    int signIndex = getNextSignIndex(data, index);
    int val = Integer.parseInt(data.substring(index, signIndex));
    TreeNode node = new TreeNode(val);

    index = signIndex + 1;
    char sign = data.charAt(signIndex);
    if (sign == 'N') {
    } else if (sign == 'L') {
      Pair<TreeNode, Integer> pair = deserialize(data, index);
      node.left = pair.getKey();
      index = pair.getValue();
    } else if (sign == 'R') {
      Pair<TreeNode, Integer> pair = deserialize(data, index);
      node.right = pair.getKey();
      index = pair.getValue();
    } else {
      Pair<TreeNode, Integer> pair = deserialize(data, index);
      node.left = pair.getKey();
      index = pair.getValue();
      pair = deserialize(data, index);
      node.right = pair.getKey();
      index = pair.getValue();
    }
    return new Pair<>(node, index);
  }

  public TreeNode deserialize(String data) {
    if (data.length() == 0) {
      return null;
    }

    return deserialize(data, 0).getKey();
  }
}
