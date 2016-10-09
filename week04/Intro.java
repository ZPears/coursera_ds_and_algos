// Notes on Divide and Conquer Introduction

import java.util.*;
import java.io.*;

public class Intro {
	
	// Searching an array
	// Input: array A with n elements; a key k
	// Output: an index i where A[i] = k

	public static void main(String[] args) {

		String input = System.console().readLine();
		int k = Integer.parseInt(input);
		int[] vals = {1,2,3,4,5,6};
		System.out.println(linearSearch(vals, 0, vals.length, k));

	}

	public static int linearSearch(int[] A, int low, int high, int key) {

		if (A[low] == key) {
			return low;
		} else {
			try {
				return linearSearch(A, low+1, high, key);
			} catch (IndexOutOfBoundsException e) {
				return -1;
			}
		}
	
	}

}
