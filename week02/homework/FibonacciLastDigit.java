import java.util.*;

public class FibonacciLastDigit {

    static long getFibonacciLastDigitNaive(int n) {
        // create an array F[0...n]
        long[] fibs = new long[n+1];
        fibs[0] = 0; fibs[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        return fibs[n] % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

