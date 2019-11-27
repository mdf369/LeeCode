package leetcode;

public class Tool {

    public static void display(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        System.out.println(builder.toString());
    }

    public static void display(int[][] board) {
        for (int[] line : board) {
            StringBuilder builder = new StringBuilder();
            for (int c : line) {
                builder.append(c).append(",\t");
            }
            System.out.println(builder.toString());
        }
    }

    public static void display(boolean[][] board) {
        for (boolean[] line : board) {
            StringBuilder builder = new StringBuilder();
            for (boolean c : line) {
                builder.append(c).append(",\t");
            }
            System.out.println(builder.toString());
        }
    }

    public static void display(char[][] board) {
        for (char[] line : board) {
            StringBuilder builder = new StringBuilder();
            for (char c : line) {
                builder.append(c).append(",\t");
            }
            System.out.println(builder.toString());
        }
    }

    public static void display(ListNode node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append("->");
            node = node.next;
        }
        System.out.println(builder.toString());
    }

    public static ListNode buildList(int[] nums) {
        ListNode root = new ListNode(0);
        ListNode p = root;

        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            p.next = node;
            p = p.next;
        }
        return root.next;
    }
}
