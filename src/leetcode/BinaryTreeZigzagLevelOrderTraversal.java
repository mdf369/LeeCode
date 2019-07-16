package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        go(root, 0, res);
        return res;
    }

    private void go(TreeNode node, int depth, List<List<Integer>> res){
        boolean flag = depth % 2 == 0;

        if (node == null){
            return;
        }

        if (res.size() <= depth){
            res.add(new ArrayList<>());
        }
        if (!flag) {
            res.get(depth).add(0, node.val);
        } else {
            res.get(depth).add(node.val);
        }
        go(node.left, depth + 1, res);
        go(node.right, depth + 1, res);
    }
}
