package leetcode;

public class Pow {

    public double myPow(double x, int n) {
        boolean nMinus = n < 0;
        boolean xMinus = false;
        if (x < 0){
            if (n % 2 == 1){
                xMinus = true;
            }
        }
        if (x == 0){
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        x = Math.abs(x);
        n = Math.abs(n);
        if (x == 1){
            if (xMinus){
                return -1;
            } else {
                return 1;
            }
        }

        double ox = x;
        int shift = getBest(n);
        int did = 1;
        for (int i = 0; i < shift; i++){
            did *= 2;
            x = x * x;
        }
        n = n - did;
        for (int i = 0;i < n;i++){
            x *= ox;
        }

        if (nMinus){
            x = 1 / x;
        }
        if (xMinus){
            x = -x;
        }
        return x;
    }

    public int getBest(int n){
        int count = 0;
        while (n > 1){
            n = n / 2;
            count++;
        }
        return count;
    }
}
