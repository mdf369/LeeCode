package top_interview;

public class Tool {

    public static void display(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        System.out.println(builder.toString());
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
}
