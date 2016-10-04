// notes on Greedy algorithm introduction

import java.util.*;
import java.io.*;

public class Greedy {
	
	public static void main(String[] args) {
		
		System.out.println(greedyMinRefills());

	}
	
	// route \x dist on tank, a is starting point, b is end point,
	// route is an array of gas station points in kms, where starting point = route[0] and end = route[n+1]
	static int greedyMinRefills(int[] route, int l) {
	
		// initialize two variables to hold refill count and current refill
		int numRefills = 0;
		int currentRefill = 0;
		int lastRefill = 0;

		// 
		while (currentRefill <= n) {
			
			lastRefill = currentRefill;
			
			while (currentRefill <= n && x[currentRefill + 1] - x[lastRefill] <= l) {

				currentRefill = currentRefill + 1

			}

			if (currentRefill == lastRefill) {

				throw new Error();			

			}

			if (currentRefill <= n):

				numRefills = numRefills + 1		

			}
		}

		return numRefills;
	}

}
