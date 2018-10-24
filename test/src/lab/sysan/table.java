package lab.sysan;

import java.util.Arrays;

public class table {

    public static double f1(double x1, double x2) {
        return -4 * (x1 - 2) * (x1 - 2) + 5 * x2 * x2 - 10 * (x2 - 2);
    }

    public static double f2(double x1, double x2) {
        return -3 * x1 * x1 + 12 * x1 + 4 * x2 - 2 * x2 * x2 + 5;
    }

    public static void main(String[] args) {
        double[] arrayOfMin = new double[500];
        int[] arrayOfIndexes = new int[500];
        double[][] arrayOfCoords = new double[10][2];
        int count = 0;


        double i;
        double j;
        int counter = 0;
        for (i = -1; i < 3.02; i += 0.02) {
            double min = 10000;
            for (j = 0; j < 4.02; j += 0.02) {
                if (Math.round(f1(i, j) * 1000) / 1000d < min) {
                    min = Math.round(f1(i, j) * 1000) / 1000d;
                    System.out.println(" x1 = " + i + "; x2 = " + j + "; f = " + Math.round(f1(i, j) * 1000) / 1000d);
                    if (Double.compare(Math.round(f1(i, j) * 1000) / 1000d, 15.0) == 0) {
                        arrayOfIndexes[counter] = count;
                        arrayOfCoords[counter][0] = i;
                        arrayOfCoords[counter++][1] = j;
                    }
                }
            }
            arrayOfMin[count] = min;
            System.out.println();
            count++;
        }
        System.out.println(Arrays.deepToString(arrayOfCoords));
        System.out.println("Max = " + Arrays.stream(arrayOfMin).max());


        for (i = -1; i < 3.02; i += 0.02) {
            double min = 10000;
            for (j = 0; j < 4.02; j += 0.02) {
                if (Math.round(f2(i, j) * 1000) / 1000d < min) {
                    min = Math.round(f2(i, j) * 1000) / 1000d;
                    System.out.println(" x1 = " + i + "; x2 = " + j + "; f = " + Math.round(f2(i, j) * 1000) / 1000d);
                    if (Double.compare(Math.round(f2(i, j) * 1000) / 1000d, 1.0) == 0) {
                        arrayOfIndexes[counter] = count;
                        arrayOfCoords[counter][0] = i;
                        arrayOfCoords[counter++][1] = j;
                    }
                }
            }
            arrayOfMin[count] = min;
            System.out.println();
            count++;
        }
        System.out.println(Arrays.deepToString(arrayOfCoords));
        System.out.println("Max = " + Arrays.stream(arrayOfMin).max());
    }

    public static double round(double x) {
        return Math.round(x * 1000) / 1000d;
    }
}
