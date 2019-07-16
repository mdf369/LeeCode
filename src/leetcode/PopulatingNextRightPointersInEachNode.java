package leetcode;

public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        connectLeftAndRight(root);
         TreeLinkNode node = root;
         while (node != null){
             connectSubTree(node);
             node = node.left;
         }
    }

    private void connectLeftAndRight(TreeLinkNode node){
        if (node == null || node.left == null || node.right == null){
            return;
        }

        node.left.next = node.right;
        connect(node.left);
        connect(node.right);
    }

    private void connectSubTree(TreeLinkNode node){
        if (node == null){
            return;
        }

        TreeLinkNode previous = null;
        while (node.next != null){
            previous = node;
            node = node.next;
            if (previous.right == null || node.left == null){
                break;
            }

            previous.right.next = node.left;
        }
    }
}
