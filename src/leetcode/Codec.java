package leetcode;

public class Codec {

    private final char SPLITER = ',';
    private final char NULL = '#';

    public String serialize(TreeNode root) {
        int maxDepth = getMaxDepth(root);

        StringBuilder builder = new StringBuilder();
        builder.append(maxDepth).append(SPLITER);
        serialize(root, builder, 0, maxDepth);
        return builder.toString();
    }

    private int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right)) + 1;
    }

    private void serialize(TreeNode node, StringBuilder builder, int depth, int maxDepth) {
        if (depth == maxDepth) {
            return;
        }

        if (node == null) {
            builder.append(NULL).append(SPLITER);
        } else {
            builder.append(node.val).append(SPLITER);
            serialize(node.left, builder, depth + 1, maxDepth);
            serialize(node.right, builder, depth + 1, maxDepth);
        }
    }

    public TreeNode deserialize(String data) {
        String[] nodeStrs = data.split(String.valueOf(SPLITER));

        int maxDepth = Integer.parseInt(nodeStrs[0]);
        if (maxDepth == 0) {
            return null;
        }

        int index = 2;
        TreeNode root = new TreeNode(Integer.parseInt(nodeStrs[1]));
        deserialize(nodeStrs, index, root, 1, maxDepth);
        return root;
    }

    private int deserialize(String[] nodeStrs, int index, TreeNode node, int depth, int maxDepth) {
        if (depth == maxDepth) {
            return index;
        }

        if (nodeStrs[index].charAt(0) == NULL) {
            node.left = null;
            index++;
        } else {
            TreeNode left = new TreeNode(Integer.parseInt(nodeStrs[index]));
            index = deserialize(nodeStrs, index + 1, left, depth + 1, maxDepth);
            node.left = left;
        }

        if (nodeStrs[index].charAt(0) == NULL) {
            node.right = null;
            index++;
        } else {
            TreeNode right = new TreeNode(Integer.parseInt(nodeStrs[index]));
            index = deserialize(nodeStrs, index + 1, right, depth + 1, maxDepth);
            node.right = right;
        }

        return index;
    }
}
