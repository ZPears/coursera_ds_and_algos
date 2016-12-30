import java.util.*;
import java.io.*;
import java.lang.Math;

public class Knapsack {

	public static void main(String[] args) {

		int capacity = 10;
		int[] weights = {6,3,4,2};
		int[] values = {30,14,16,9};
		boolean repeating = false;

		int[][] res = discreteKnapsack(capacity, weights, values, repeating);

		for (int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}

		if (!repeating) {
			boolean[] items = showItems(weights, values, res, res.length-1, res[0].length-1, 
				res[res.length-1][res[0].length-1], new boolean[weights.length]);

			System.out.println(Arrays.toString(items));
		}
	}

	private static int[][] discreteKnapsack(int capacity, int[] weights, int[] values, boolean repeating) {

		if (repeating) {
			return repeatableItems(capacity, weights, values);
		} else {
			return nonRepeatableItems(capacity, weights, values);
		}

	}

	private static int[][] repeatableItems(int capacity, int[] weights, int[] values) {

		int[] result = new int[capacity+1];
		result[0] = 0;

		for (int w = 1; w <= capacity; w++) {

			result[w] = 0;

			for (int i = 0; i < weights.length; i++) {

				if (weights[i] <= w) {

					int val = result[w - weights[i]] + values[i];
					if (val > result[w]) {
						result[w] = val;
					}

				}

			}

		}

		int[][] output = { result };

		return output;
	}

	private static int[][] nonRepeatableItems(int capacity, int[] weights, int[] values) {

		int[][] result = new int[weights.length+1][capacity+1];

		for (int itemIdx = 1; itemIdx < weights.length+1; itemIdx++) {

			for (int capa = 1; capa < capacity+1; capa++) {

				result[itemIdx][capa] = Math.max(result[itemIdx][capa-1], result[itemIdx-1][capa]);

				if (weights[itemIdx-1] <= capa) {

					int val = result[itemIdx - 1][capa - weights[itemIdx-1]] + values[itemIdx-1];
					if (result[itemIdx][capa] < val) {
						result[itemIdx][capa] = val;
					}

				}

			}
		}

		return result;
	}

	private static boolean[] showItems(int[] weights, int[] values, int[][] result, 
		int currentRow, int currentCol, int currentValue, boolean[] output) {
		
		if (currentValue == 0) {
			return output;
		} else if (currentValue > result[currentRow-1][currentCol-weights[currentRow-1]] + values[currentRow-1]) {
			output[currentRow-1] = false;
			return showItems(weights, values, result, currentRow-1, currentCol, currentValue, output);
		} else {
			output[currentRow-1] = true;
			int remainingValue = currentValue - values[currentRow-1];
			return showItems(weights, values, result, currentRow-1, currentCol-weights[currentRow-1], remainingValue, output);
		}

	}
}
