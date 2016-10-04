import java.util.Scanner;

public class Fibonacci {
  static long calcFib(int n) {
	// create an array F[0...n]
	long[] fibs = new long[n+1];
	fibs[0] = 0; 
	try {
		fibs[1] = 1;
	} catch (IndexOutOfBoundsException e) {};
	for (int i = 2; i <= n; i++) {
		fibs[i] = fibs[i - 1] + fibs[i - 2];
	}
	return fibs[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calcFib(n));
  }
}
