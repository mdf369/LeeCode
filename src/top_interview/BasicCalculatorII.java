package top_interview;

public class BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        return calculateAddAndSub(s, 0, s.length());
    }

    private int calculateAddAndSub(String s, int start, int end) {
        int res = 0;
        int index = end;
        while (true) {
            int next = getLastAddOrSub(s, index);

            if (next < start) {
                res += calculateMultAndDiv(s, start, index);
                return res;
            } else if (s.charAt(next) == '+') {
                res += calculateMultAndDiv(s, next + 1, index);
            } else {
                res -= calculateMultAndDiv(s, next + 1, index);
            }

            index = next;
        }
    }

    private int calculateMultAndDiv(String s, int start, int end) {
        int index = getNextMultOrDiv(s, start, end);
        int res = Integer.parseInt(s.substring(start, index).trim());
        while (true) {
            if (index >= end) {
                return res;
            }

            int next = getNextMultOrDiv(s, index + 1, end);

            if (s.charAt(index) == '*') {
                res *= Integer.parseInt(s.substring(index + 1, next).trim());
            } else {
                res /= Integer.parseInt(s.substring(index + 1, next).trim());
            }

            index = next;
        }
    }

    private int getLastAddOrSub(String s, int end) {
        int index = end - 1;
        while (index >= 0 && s.charAt(index) != '+' && s.charAt(index) != '-') {
            index--;
        }
        return index;
    }

    private int getLastMultOrDiv(String s, int start, int end) {
        int index = end - 1;
        while (index >= start && s.charAt(index) != '*' && s.charAt(index) != '/') {
            index--;
        }
        return index;
    }

    private int getNextMultOrDiv(String s, int start, int end) {
        int index = start;
        while (index < end && s.charAt(index) != '*' && s.charAt(index) != '/') {
            index++;
        }
        return index;
    }
}
