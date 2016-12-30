import java.util.*;
import java.io.*;
import java.lang.Math;

public class PlaceParens {

	public static int[] operands = {5,8,7,4,8,9};
	public static char[] operators = {'-','+','*','-','+'};

	public static int[][] minValues = new int[operands.length][operands.length];
	public static int[][] maxValues = new int[operands.length][operands.length];
	
	public static void main(String[] args) {

		int greatestValue = parentheses(operands, operators);
		
		for (int i = 0; i < minValues.length; i++) {
			System.out.println(Arrays.toString(minValues[i]));
		}

		for (int i = 0; i < maxValues.length; i++) {
			System.out.println(Arrays.toString(maxValues[i]));
		}
		
		System.out.println(greatestValue);	

	}

	private static int parentheses(int[] operands, char[] operators) {
	
		assert operands.length == operators.length + 1 : "Operands.length must be 1 + operators.length.";

		// initialize values
		for (int i = 0; i < operands.length; i++) {

			minValues[i][i] = operands[i];
			maxValues[i][i] = operands[i];

		}

		for (int s = 1; s < operands.length; s++) { // for each column index > 1...

			for (int i = 0; i < operands.length - s; i++) { // for each int from 0 ... # num cols - s...

				int j = s + i; // this will go from s to operands.length...
				// for s = 1, (0,1), (1,2), (2,3), (3,4), (4,5), (5,6)
				// for s = 2, (0,2), (1,3), (2,4), (3,5), (4,6) 
				// for s = 3, (0,3), (1,4), (2,5), (3,6)				

				int[] vals = minAndMax(i,j); // find the min and max for the i,j cell...
				
				minValues[i][j] = vals[0];
				maxValues[i][j] = vals[1];
	
			}

		}

		return maxValues[0][operands.length-1];

	}

	private static int[] minAndMax(int i, int j) {

		int min = 2147483647;
		int max = -2147483648;

		// from i to j-1...
		for (int k = i; k <= j-1; k++) {
			
			if (operators[k] == '+') {
				int a = maxValues[i][k] + maxValues[k+1][j];
				int b = maxValues[i][k] + minValues[k+1][j];
				int c = minValues[i][k] + maxValues[k+1][j];
				int d = minValues[i][k] + minValues[k+1][j];
				min = Math.min(a, Math.min(b, Math.min(c, Math.min(d, min))));
				max = Math.max(a, Math.max(b, Math.max(c, Math.max(d, max))));
			} else if (operators[k] == '-') {
				int a = maxValues[i][k] - maxValues[k+1][j];
				int b = maxValues[i][k] - minValues[k+1][j];
				int c = minValues[i][k] - maxValues[k+1][j];
				int d = minValues[i][k] - minValues[k+1][j];
				min = Math.min(a, Math.min(b, Math.min(c, Math.min(d, min))));
				max = Math.max(a, Math.max(b, Math.max(c, Math.max(d, max))));
			} else if (operators[k] == '/') {
				int a = maxValues[i][k] / maxValues[k+1][j];
				int b = maxValues[i][k] / minValues[k+1][j];
				int c = minValues[i][k] / maxValues[k+1][j];
				int d = minValues[i][k] / minValues[k+1][j];
				min = Math.min(a, Math.min(b, Math.min(c, Math.min(d, min))));
				max = Math.max(a, Math.max(b, Math.max(c, Math.max(d, max))));
			} else {
				int a = maxValues[i][k] * maxValues[k+1][j];
				int b = maxValues[i][k] * minValues[k+1][j];
				int c = minValues[i][k] * maxValues[k+1][j];
				int d = minValues[i][k] * minValues[k+1][j];
				min = Math.min(a, Math.min(b, Math.min(c, Math.min(d, min))));
				max = Math.max(a, Math.max(b, Math.max(c, Math.max(d, max))));
			}
		}

		int[] result = {min, max};
		
		return result;
	}
}
