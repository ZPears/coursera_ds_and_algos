// notes on Fractional Knapsack algorithm 

import java.util.*;
import java.io.*;

public class FractionalKnapsack {

	public static void main(String[] args) {
	
	// how to maximize caloric value in n kg knapsack?
	// n items with weights w1, ..., wn and values v1, ..., vn
	// and capacity W

		

	}

	public static Pair<int, int[]> packBag(int[] w, int[] v, int W) {

		// Lemma: there exists an optimal solution
		// that uses as much of an item with the maximum
		// value per unit of weight.

		int[] output = int[w.length];
		int totalValue = 0;
		float[] valuesPerWeight = float[w.length];
	
		// set valuesPerWeights
		for (int i = 0; i < w.length; i++) {

			valuesPerWeight[i] = v[i] / w[i]	

		}

		for (int i = 0; i < w.length; i++) {

			if (W == 0) {
			
				return (totalValue, output)				
			
			} else {
				
				// NOTE: CAN REDUCE FROM O(n^2)
				// BY SORTING VpW FIRST;
				// TAKES IT TO O(n)
				// SORTING TAKES O(n log n)
				// SO RESULT IS O(n log n)				

				// select i with w[i] > 0 and max(v[i]/w[])
				// a = min(w[i], W)
				// v = v + a * valuesPerWeight[i]
				// w[i] = w[i] - a
				// output[i] += a
				// W -= a		

			}
			
			return (totalValue, output)

		}

	}

}
	
