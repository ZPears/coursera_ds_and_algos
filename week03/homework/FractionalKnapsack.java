import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double[][] ratios = new double[values.length][2];

        for (int i = 0; i < ratios.length; i++) {
            ratios[i][0] = (double) values[i] / (double) weights[i];
            ratios[i][1] = i;
        }

        Arrays.sort(ratios, new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(b[0], a[0]);
            }
        });

        for (int i = 0; i < ratios.length; i++) {
            if (capacity == 0) {
                break;
            } else {
                double weightsIndex = ratios[i][1];
                double a = Math.min(weights[(int)weightsIndex], capacity);
                value += a * ratios[i][0];
                capacity -= a;
            }
        }

        return value;
    };



    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
