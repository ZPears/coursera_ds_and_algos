// Notes on Binary Search 

import java.util.*;
import java.io.*;

public class Binary {
	
	public static void main(String[] args) {

	}

	public static int BinarySearch(int[] a, int low, int high, int k) {
	
	// Big theta(log(2) of n)

	// if high < low: return low -1
	// else mid <- floor(low + high-low/2)		
	
	// if key == A[mid]: mid
	// else if key < A[mid]: return BinarySearch(A, low, mid-1, key)
	// else: BinarySearch(A, mid+1, high, key)		
}
