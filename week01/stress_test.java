import Java.util.Random;
import java.util.*;
import java.io.*;

public class StressTester {
	
	public static void main() {
	
		while (true) {
			Random rand = new Random();
			int n = rand.nextInt(12) + 3;
			System.out.println(n)
			int[] a = new int[n];
			for (int i = 0; i < n; ++i) {
				a[i] = rand.nextInt(20) + 1;
			}
			System.out.println(a);
			long res1 = MaxPairwiseProduct(a);
			long res2 = MaxPairwiseProductFast(a);
			if (res1 != res2) {
				System.out.println("Wrong answer: " + res1 + " " + res2 + "\n");
				break;
			} else {
				System.out.println("OK");
			}
		}
	}

	static long getMaxPairwiseProduct(long[] numbers) {
	        long result = 0;
	        int n = numbers.length;
		long[] max_numbers = new long[]{-1, -1};
	
		for (int i = 0; i < n; i++) {
			if (numbers[i] >= max_numbers[0]) { max_numbers[1] = max_numbers[0]; max_numbers[0] = numbers[i]; }
			else if (numbers[i] > max_numbers[1]) { max_numbers[1] = numbers[i]; }
		}
	
        	return max_numbers[0] * max_numbers[1];
    	}
}

