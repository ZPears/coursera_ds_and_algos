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

		System.out.println("Input:");
		System.out.println(Arrays.toString(a));

		int[] aSelect = SelectionSort(a);
		int[] aMerge = MergeSort(a2);
		int[] aCount = MergeSort(a3);
	
		System.out.println("Selection Sort:");
		System.out.println(Arrays.toString(aSelect));
		
		System.out.println("Merge Sort:");
		System.out.println(Arrays.toString(aMerge));

		System.out.println("Count Sort:");
		System.out.println(Arrays.toString(aCount));
		
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

	public static int[] aCount(int[] a) {

		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

		for (int i=0; i < a.length; i++) {
			if (counts.get(i) == null) {
				counts.put(i, 1);
			} else {
				counts.put(i, counts.get(i) + 1);
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
	
}
