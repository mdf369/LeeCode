package top_interview;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }

        if (divisor == dividend){
            return 1;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        if (divisor == Integer.MIN_VALUE){
            return 0;
        }

        boolean flag1 = dividend >= 0;
        boolean flag2 = divisor >= 0;
        int count = 0;
        divisor = Math.abs(divisor);
        if (dividend == Integer.MIN_VALUE){
            count++;
            dividend += divisor;
        }
        dividend = Math.abs(dividend);

        while (true){
            if (dividend < divisor){
                if (flag1 == flag2){
                    return count;
                } else {
                    return -count;
                }
            }

            dividend -= divisor;
            count++;
        }
    }
}
