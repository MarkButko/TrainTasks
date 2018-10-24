package lab.sysan;

import java.io.FileWriter;
import java.io.IOException;

public class last {
    public static double f1(double x1, double x2) {
        return -4 * (x1 - 2) * (x1 - 2) + 5 * x2 * x2 - 10 * (x2 - 2);
    }

    public static double f2(double x1, double x2) {
        return -3 * x1 * x1 + 12 * x1 + 4 * x2 - 2 * x2 * x2 + 5;
    }

    public static final double F1 = 15.0;
    public static final double F2 = 1.;

    public static boolean isF1(double x1, double x2) {
        return f1(x1, x2) >= F1;
    }

    public static boolean isF2(double x1, double x2) {
        return f2(x1, x2) >= F2;
    }

    public static boolean inside(double x1, double x2) {
        boolean result;
        result = (x1 <= 3) && (x1 >= -1) && (x2 <= 4) && (x2 >= 0) && isF1(x1, x2) & isF2(x1, x2);
        return result;
    }

    public static void main(String[] args) throws IOException {

        double X0 = -1;
        double X1 = 3;
        double Y0 = 0;
        double Y1 = 4;
        double step = 0.02;

        long n1 = Math.round((X1 - X0)/ step);
        long n2 = Math.round((Y1 - Y0) / step);

        double xStart = -1;
        double yStart = 0;

        System.out.println(n1);
        System.out.println(n2);

        double xTemp = 0;
        double yTemp = 0;
        double delta = 0;
        double minDelta = Double.MAX_VALUE;
        double minX = -1;
        double minY = 0;
        FileWriter writer = new FileWriter("test.txt", false);

        for (int i = 0; i < n2; i++) {
            yTemp = yStart + step * i;
            for (int j = 0; j < n1; j++) {
                xTemp = xStart + step * j;
                if (inside(xTemp, yTemp)) {
                    delta = getMaxI(xTemp, yTemp);
                    if (minDelta > delta) {
                        minDelta = delta;
                        minX = xTemp;
                        minY = yTemp;
                    }
                    writer.write(String.format("y= %f x= %f delta = %f", yTemp, xTemp, delta) + "\n");
                }
            }
        }

        System.out.println(minDelta);
        System.out.println("x = " + minX);
        System.out.println("y = " + minY);
        writer.flush();
        writer.close();
    }

    public static double getMaxI(double x1, double x2) {
        double result;

        result = Math.max((F1 - f1(x1, x2)), (F2 - f2(x1, x2)));

        result = Math.abs(result);

        return result;
    }

}

