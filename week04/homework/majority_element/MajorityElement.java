import java.util.*;
import java.io.*;
import java.lang.Math;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }

        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int i=0; i < a.length; i++) {
            if (counts.get(a[i]) == null) {
                counts.put(a[i], 1);
            } else {
                counts.put(a[i], counts.get(a[i]) + 1);
            }
        }

        int idx = 0;


        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if ( entry.getValue() > Math.ceil(a.length/2) ) {
                return 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

