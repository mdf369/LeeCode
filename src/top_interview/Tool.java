package top_interview;

public class Tool {

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
