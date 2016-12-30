import java.util.*;
import java.io.*;
import java.lang.Math;

public class AlignmentGame {

	public static void main(String[] args) {

		String a = args[0];
		String b = args[1];

		int[][] result = editDistance(a,b);

		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}

		String[] ans = outputAlignment(a,b,result);

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

	public static int[][] editDistance(String a, String b) {

		int[][] d = new int[a.length()+1][b.length()+1];

		for (int i = 0; i < a.length()+1; i++) {

			d[i][0] = i;

			if (i == 0) {

				for (int j = 0; j < b.length()+1; j++) {

					d[i][j] = j;

				}

			}

		}

		for (int j = 1; j <= b.length(); j++) {

			for (int i = 1; i <= a.length(); i++) {

				int match = 0;

				// blue color in lecture
				int insertion = d[i][j-1] + 1;
				// green color in lecture
				int deletion = d[i-1][j] + 1;
				if (a.charAt(i-1) == b.charAt(j-1) ) {
					// purple color in lecture
					match = d[i-1][j-1];
				} else {
					// orange color in lecture
					match = d[i-1][j-1] + 1;
				}

				int ans = Math.min( Math.min(insertion, deletion), match ); 

				d[i][j] = ans;

			}


		}

		return d;

	}

	public static String[] outputAlignment(String a, String b, int[][] d) {

		int i = a.length();
		int j = b.length();

		StringBuilder aBuf = new StringBuilder();
		StringBuilder bBuf = new StringBuilder();

		while (i > 0 || j > 0) {

			if (i > 0 && d[i][j] == d[i-1][j] + 1) {

				aBuf.insert(0, a.charAt(i-1));
				bBuf.insert(0, "-");
				i--;

			} else if (j > 0 && d[i][j] == d[i][j-1] + 1) {

				aBuf.insert(0, "-");
				bBuf.insert(0, b.charAt(j-1));
				j--;

			} else {

				aBuf.insert(0, a.charAt(i-1));
				bBuf.insert(0, b.charAt(j-1));
				i--; j--;

			}

		}

		String[] result = new String[2];
		result[0] = aBuf.toString();
		result[1] = bBuf.toString();

		return result;

	}

}