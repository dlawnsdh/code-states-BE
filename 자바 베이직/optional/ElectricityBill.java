package optional;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("=".repeat(25));
        System.out.println(" 주택용 전기요금(저압) 계산기 ");
        System.out.println("=".repeat(25));

        double[] charge = {60.7, 125.9, 187.9, 280.6, 417.7, 670.6};
        System.out.print("전기 사용량 입력: ");
        int n = s.nextInt();

        double[] arr = (n > 100) ? (n > 500) ? DoubleStream.generate(() -> 100).limit(6).toArray() :
                DoubleStream.generate(() -> 100).limit(n / 100 + 1).toArray() : new double[1];

        arr[arr.length - 1] = (arr.length != 1) ? (arr.length != 6) ? n % 100 : n - 500 : n;
        //System.out.println(Arrays.toString(arr));

        double sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i] * charge[i];
        System.out.printf("%.1f", sum);
    }
}
