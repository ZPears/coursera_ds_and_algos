import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    long gcd = euclidGCD(a, b);

    return a * (b / gcd);
  }

  private static long euclidGCD(long a, long b) {
    if (b == 0) {
      return a;
    } else {
      long aPrime = a % b;
      return euclidGCD(b, aPrime);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
