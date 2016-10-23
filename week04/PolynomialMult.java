// Notes on Polynomial Multiplication

import java.util.*;
import java.io.*;

public class PolynomialMult {

	public static void main(String[] args) {
		
		// input: the degree, and two n-1 degree polynomials (coefficients only)
		// output: the product of the two polynomials

		// example: 3
		// 3 2 5
		// 5 1 2
		// result: 15 13 33 9 10

		Scanner in = new Scanner(System.in);		

		System.out.println("Enter n: ");
		int n = in.nextInt();                

		int[] a = new int[n];
		int[] b = new int[n];
		System.out.println("Enter a: ");
		
		for (int i=0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
	
		System.out.println("Enter b: ");
	
		for (int i=0; i < b.length; i++) {
			b[i] = in.nextInt();
		}

		System.out.println(Arrays.toString(NaiveSolution(a,b,n)));		

	}

	public static int[] NaiveSolution(int[] a, int[] b, int n) {
		int[] product = new int[2*n-1];
		
		for (int i = 0; i < product.length; i++) {
			product[i] = 0;
		}
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n-1; j++) {
				product[i+j] = product[i+j] + a[i] * b[j];
			}
		}
	
	return product;

	}

	public static int[] NaiveDandC(int[] a, int[] b, int n, int al, int bl) {

		// split a(x) int dsub1(x)x^n/2 + dsub0(x) where
		// dsub1(x) = asubn-1*x^(n/2)-1 + ... + a(n/2)
		// dsub0(x) = asub(n/2)-1*x^(n/2)-1 + ... + a0
	
		// do that same for b
		
		// then AB = (dsub1*x^n/2 + dsub0)(esub1*x^n/2 + esub0)
		// which is (d1e1)x^n + (d1e0 + d0e1)x^n/2  + d0e0
		// so only calculate d1e1, d1e0, d0e1, and d0e0

		int[] r = int[2*n-1];
		if (n == 1) {
			r[0] = a[al] * b[bl];
			return r;
		}	

		return r

		// etc., etc., - it's still big theta n^2, so forget it

	}

	public static int[] Karatsuba() {

		// a(x) = a1(x) + a0
		// b(x) = b1(x) + b0
		// c(x) = a1b1(x^2) + (a1b0 + a0b1)(x) + a0b0
		
		// c(x) needs 4 multiplications to compute, it seems - but Karatsuba can do it with 3:

		// ((a1 + a0)(b1 + b0) - a1b1 - a0b0) === (a1b0 + a0b1)
		//  so by replacing the middle term of c(x) with this new one, we now only need 3 multplications (a1 + a0)(b1 + b0).
		// a1b1 and a0b0 are already calculated elsewhere

	}

} 
