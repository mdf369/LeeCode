package top_interview;

public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        if (x < 4){
            return 1;
        }

        return find(x, 0, (int) Math.min(x, 46340));
    }

    private int find(int x, int start, int end){
        if (start >= end){
            return start;
        }

        int middle = (start + end) / 2;
        int value = middle * middle;
        int value2 = (middle + 1) * (middle + 1);
        if (value <= x && x <= value2){
            if (x == value2){
                return middle + 1;
            }
            return middle;
        } else if (value > x){
            return find(x, start, middle);
        } else {
            return find(x, middle + 1, end);
        }
    }
}
