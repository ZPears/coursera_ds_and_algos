import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int coinCount = m / 10;
        int r = m % 10;
        if (r < 5) {
        	coinCount += r;
        } else {
        	coinCount += (r % 5) + 1;
        }
        return coinCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

