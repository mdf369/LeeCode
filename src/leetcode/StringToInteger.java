package leetcode;

public class StringToInteger {

    public int myAtoi(String str) {
        boolean minus = false;
        int start = 0;
        long res = 0;

        while (start < str.length() && str.charAt(start) == ' '){
            start++;
        }

        if (start >= str.length()){
            return 0;
        }

        if (str.charAt(start) == '-' || str.charAt(start) == '+'){
            if (str.charAt(start) == '-') {
                minus = true;
            }
            start++;
        }

        while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9'){
            int n = str.charAt(start) - '0';
            res = res * 10 + n;

            if (res > Integer.MAX_VALUE){
                break;
            }

            start++;
        }

        if (minus){
            res = -res;
        }

        if (res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }

        if (res < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }

        return (int) res;
    }
}
