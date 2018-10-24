package lab.sysan;

import java.util.Arrays;
import java.util.stream.IntStream;

public class old {

    public static double f1(double x) {
        return (5 - 3 * x + x * x) / 3;
    }

    public static double f2(double x) {
        return (7.5 - x * x) / 3.5;
    }

    public static double max(double func1, double func2) {
        return Math.max(func1, func2);
    }


    public static void main(String[] args) {
        double[] array1 = new double[1001];
        double[] array2 = new double[1001];
        int count = 0;
        for (double x = 0.0; x <= 1.0; x += 0.001) {
            array1[count] = Math.round(Math.max(f1(x), f2(x)) * 10000) / 10000d;
            array2[count] = Math.round(Math.min(f1(x), f2(x))* 10000) / 10000d;
            System.out.println(count + " " + Math.round(x * 10000) / 10000d
                    + " " + Math.round(f1(x) * 10000) / 10000d
                    + " " + Math.round(f2(x)* 10000) / 10000d
                    + " " + Math.round(Math.max(f1(x), f2(x))* 10000) / 10000d
                    + " " + Math.round(Math.min(f1(x), f2(x))* 10000) / 10000d);
            count++;
        }

        double min = Arrays.stream(array1).min().getAsDouble();
        int minIdx = IntStream.range(0,array1.length)
                .reduce((i,j) -> array1[i] > array1[j] ? j : i)
                .getAsInt();

        System.out.println("Minmax = " + min
                + " idx= " + minIdx);

        double max = Arrays.stream(array1).max().getAsDouble();
        int maxIdx = IntStream.range(0,array1.length)
                .reduce((i,j) -> array1[i] < array1[j] ? j : i)
                .getAsInt();

        System.out.println("Maxmin = " + max
                + " idx= " + maxIdx);
    }
}

