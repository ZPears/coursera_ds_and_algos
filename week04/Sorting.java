import java.util.*;
import java.io.*;
import java.lang.Math;

public class Sorting {

	public static void main(String[] args) {

/*		Scanner in = new Scanner(System.in);		

		System.out.println("Enter n: ");
		int n = in.nextInt();                

		int[] a = new int[n];
		System.out.println("Enter a: ");
		
		for (int i=0; i < a.length; i++) {
			a[i] = in.nextInt();
		}*/

		int[] a = {5,7,4,5,6,7,3,8,6,14,11};
		int[] a2 = a.clone();
		int[] a3 = a.clone();
		int[] a4 = a.clone();

		System.out.println("\nInput:");
		System.out.println(Arrays.toString(a));

		int[] aSelect = SelectionSort(a);
		int[] aMerge = MergeSort(a2);
		int[] aCount = CountSort(a3);
		QuickSort(a4, 0, a.length);
	
		System.out.println("\nSelection Sort:");
		System.out.println(Arrays.toString(aSelect));
		
		System.out.println("\nMerge Sort:");
		System.out.println(Arrays.toString(aMerge));

		System.out.println("\nCount Sort:");
		System.out.println(Arrays.toString(aCount));

		System.out.println("\nQuick Sort:");
		System.out.println(Arrays.toString(a4));
		System.out.println("\n");

		
	}

	public static int[] SelectionSort(int[] a) {

		for (int i=0; i < a.length; i++) {

			int minIndex = i;
			
			for (int j=i+1; j < a.length; j++) {
	
				if (a[j] < a[minIndex]) {

					minIndex = j;

				}

			int low = a[minIndex];
			int swp = a[i];
			a[i] = low;
			a[minIndex] = swp;

			}

		} 

		return(a);

	}

	public static int[] MergeSort(int[] a) {

		if (a.length <= 1) {
			
			return(a);

		} else {

		int m = (int) Math.floor(a.length/2);

		int[] b = MergeSort(Arrays.copyOfRange(a,0,m));
		int[] c = MergeSort(Arrays.copyOfRange(a,m,a.length));

		int[] aPrime = Merge(b, c); 

		return(aPrime);

		}

	}

	public static int[] Merge(int[] b, int[] c) {

		// assumes b and c are sorted
		int len = b.length + c.length;
		int[] d = new int[len];
		
		int nextIndex = 0;

		while (b.length > 0 && c.length > 0) {

			int bFirst = b[0];
			int cFirst = c[0];

			if ( bFirst <= cFirst || c.length == 0 ) {
				d[nextIndex] = bFirst;
				b = Arrays.copyOfRange(b, 1, b.length);
			} else {
				d[nextIndex] = cFirst;
				c = Arrays.copyOfRange(c, 1, c.length);
			}

			nextIndex++;

		}

		if (b.length > 0) {
			while (b.length > 0) {
				d[nextIndex] = b[0];
				b = Arrays.copyOfRange(b, 1, b.length);
				nextIndex++;
			}
		}

		if (c.length > 0) {
			while (c.length > 0) {
				d[nextIndex] = c[0];
				c = Arrays.copyOfRange(c, 1, c.length);
				nextIndex++;
			}
		}

		return(d);

	}

	public static int[] CountSort(int[] a) {

		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

		for (int i=0; i < a.length; i++) {
			if (counts.get(a[i]) == null) {
				counts.put(a[i], 1);
			} else {
				counts.put(a[i], counts.get(a[i]) + 1);
			}
		}

		int len = 0;
		for (int i : counts.values()) {
    		len += i;
		}

		int[] result = new int[len];
		int idx = 0;

		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			for (int i = entry.getValue(); i > 0; i--) {
				result[idx] = entry.getKey();
				idx++;
			}
		}

		return(result);

	}

	public static void QuickSort(int[] a, int l, int r) {

		if (l > r || l >= a.length) {
			
		} else {

			int pivotIndex = partition(a, l, r);

			QuickSort(a, l, pivotIndex-1);
			QuickSort(a, pivotIndex+1, r);

		}

	}
	
	public static int partition(int[] a, int l, int r) {

		int pivot = a[l];
		int j = l;

		for (int i = l+1; i < r; i++) {

			if (a[i] <= pivot) {
				j++;
				swapIndices(a, i, j);
			}

		}

		swapIndices(a, l, j);

		return(j);


	}

	public static int[] swapIndices(int[] a, int idx1, int idx2) {
		
		int tmp1 = a[idx1];
		int tmp2 = a[idx2];
		
		a[idx1] = tmp2;
		a[idx2] = tmp1;

		return(a);
	}

}
