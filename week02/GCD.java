// notes on the GCD lecture 

import java.util.*;
import java.io.*;

public class GCD {
	public static void main(String[] args) {
		System.out.println("Enter GCD number 1: ");
		String input = System.console().readLine();
		long gcdOne = Integer.parseInt(input);
	
		System.out.println("Enter GCD number 2: ");
		input = System.console().readLine();
		long gcdTwo = Integer.parseInt(input);
	
		System.out.println(naiveGCD(gcdOne, gcdTwo));
		System.out.println(euclidGCD(gcdOne, gcdTwo));
	}

	static long naiveGCD(long gcdOne, long gcdTwo) {
		long best = 0;
		for (int i = 1; i <= gcdOne + gcdTwo; i++) {
			if (gcdOne % i == 0 && gcdTwo % i == 0) {
				best = i;
			}
		}
		return best;	
	}
	// runtime is ~ a + b, which will take forever

	// better algorithm, based on lemma:
	// a' is the remainder when a is divided by b, then
	// gcd(a, b) = gcd(a', b) = gcd(b, a')

	// proof: a = a' + bq for some q
	// d divides a and b IFF it divides a' and b
	static long euclidGCD(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			long aPrime = a % b;
			return euclidGCD(b, aPrime);
		}
	}
}
