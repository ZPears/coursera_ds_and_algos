// notes on the fibonacci lecture

import java.util.*;
import java.io.*;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println("Enter Fibonacci index: ");
		String fib = System.console().readLine();
		int fibIndex = Integer.parseInt(fib);
		System.out.println(naiveFib(fibIndex));
		System.out.println(fibList(fibIndex));
	}

	// How many lines of code need to be executed to solve naive version? T(n) is 2 if n <= 1, T(n -1) + T(n -2) + 3 else
	// Therefore T(n) >= Fn, T(100) ~ 1.77 * 10^21
	// THAT'S 56,000 years at 1GHz!
	static long naiveFib(int n) {
		if (n <= 1) {
			return n;
		} else {
			return naiveFib(n - 1) + naiveFib(n - 2);
		}
	}
	// why so slow? Because of thousands and thousands of recursive calls

	
	// a netter  solution:
	static long fibList(int n) {
		// create an array F[0...n]
		long[] fibs = new long[n+1];
		fibs[0] = 0; fibs[1] = 1;
		for (int i = 2; i <= n; i++) {
			fibs[i] = fibs[i - 1] + fibs[i - 2];
		}
		return fibs[n];
	}
	// T(n) = 2n + 2. Trivial to execute on any modern machine
}
