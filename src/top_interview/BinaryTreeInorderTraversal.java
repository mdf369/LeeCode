package top_interview;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        go(root, res);
        return res;
    }

    private void go(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }

        go(node.left, res);
        res.add(node.val);
        go(node.right, res);
    }
}
