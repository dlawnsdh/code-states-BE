package optional;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static long[] d = new long[100];
    public static long fibo(int n) {
        if (n == 2 || n == 1)
            return 1;
        if (d[n] != 0)
            return d[n];
        d[n] = fibo(n - 1) + fibo(n - 2);
        return  d[n];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        d[0] = 1; d[1] = 1;
        fibo(n);
        Arrays.stream(d).filter(i -> i > 0).forEach(System.out::println);
    }
}
