package leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        appendNode(builder, 0);
        return builder.toString();
    }

    private void appendNode(StringBuilder builder, int shift) {
        appendShift(builder, shift);
        builder.append(val).append('\n');
        if (left != null) {
            left.appendNode(builder, shift + 1);
        }
        if (right != null) {
            right.appendNode(builder, shift + 1);
        }
    }

    private void appendShift(StringBuilder builder, int shift) {
        for (int i = 0; i < shift; i++) {
            builder.append('\t');
        }
    }
}
