import java.io.*;
import java.util.*;
import java.lang.Math;

public class BinarySearch {

    static int binarySearch(int[] a, int x, int start, int end) {

        try {
            if (start <= end) {
                int middle = (start + end)/2;

                if (x == a[middle]) {
                    return middle;
                } else if (x < a[middle]) {
                    return binarySearch(a, x, start, middle-1);
                } else {
                    return binarySearch(a, x, middle+1, end);
                }
            } 
            else {
                return -1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, b[i], 0, a.length) + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
