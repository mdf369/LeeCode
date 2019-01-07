import java.util.Random;

public class Temp {

    public static void main(String[] args){
        int m, n;
        n = 10;
        m = 20;
        Random random = new Random(System.currentTimeMillis());

        System.out.println(n + " " + m);
        for (int i = 0; i < m; i++) {
            System.out.println(random.nextInt(n) + " " + random.nextInt(n));
        }
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
    }
}
